import java.io.*;
import java.net.*;

class Sender {
    private static final int WINDOW_SIZE = 4;

    public static void main(String[] args) {
        try {
            DatagramSocket udpSocket = new DatagramSocket();
            Socket tcpSocket = new Socket("localhost", 9876);
            DataOutputStream tcpOutputStream = new DataOutputStream(tcpSocket.getOutputStream());
            DataInputStream tcpInputStream = new DataInputStream(tcpSocket.getInputStream());

            int counter = WINDOW_SIZE;
            int sequenceNumber = 0;

            while (true) {
                // Simulate sending messages
                for (int i = 0; i < counter; i++) {
                    sendMessage(udpSocket, "Message " + sequenceNumber, InetAddress.getLocalHost(), 12345);
                    System.out.println("Sent: Message " + sequenceNumber);
                    sequenceNumber++;
                }

                // Simulate receiving acknowledgment
                String acknowledgment = tcpInputStream.readUTF();

                if (acknowledgment.startsWith("ACK")) {
                    int ackNumber = Integer.parseInt(acknowledgment.substring(3));
                    counter += ackNumber;
                    System.out.println("Received ACK" + ackNumber);
                } else if (acknowledgment.startsWith("NACK")) {
                    int nackNumber = Integer.parseInt(acknowledgment.substring(4));
                    sequenceNumber = nackNumber;
                    System.out.println("Received NACK" + nackNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(DatagramSocket socket, String message, InetAddress address, int port) throws IOException {
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        socket.send(packet);
    }
}


