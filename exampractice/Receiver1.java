import java.io.*;
import java.net.*;

class Receiver {
    private static final int WINDOW_SIZE = 2;

    public static void main(String[] args) {
        try {
            DatagramSocket udpSocket = new DatagramSocket(12345);
            ServerSocket tcpServerSocket = new ServerSocket(9876);
            Socket tcpSocket = tcpServerSocket.accept();
            DataOutputStream tcpOutputStream = new DataOutputStream(tcpSocket.getOutputStream());
            DataInputStream tcpInputStream = new DataInputStream(tcpSocket.getInputStream());

            int expectedSequenceNumber = 0;

            while (true) {
                // Simulate receiving messages
                for (int i = 0; i < WINDOW_SIZE; i++) {
                    DatagramPacket packet = receiveMessage(udpSocket);
                    String message = new String(packet.getData(), 0, packet.getLength());

                    if (Integer.parseInt(message.split(" ")[1]) == expectedSequenceNumber) {
                        System.out.println("Received: " + message);
                        expectedSequenceNumber++;
                    } else {
                        System.out.println("Received out-of-sequence message: " + message);
                    }
                }

                // Simulate sending acknowledgment
                String acknowledgment = (Math.random() < 0.8) ? "ACK" + expectedSequenceNumber : "NACK" + expectedSequenceNumber;
                tcpOutputStream.writeUTF(acknowledgment);
                System.out.println("Sent: " + acknowledgment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static DatagramPacket receiveMessage(DatagramSocket socket) throws IOException {
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        return packet;
    }
}