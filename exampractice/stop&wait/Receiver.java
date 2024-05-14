import java.io.*;
import java.net.*;

public class Receiver {
    public static void main(String[] args) {
        try {
            // Create a TCP server socket
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("Receiver: Waiting for connection...");

            // Wait for the sender to establish a connection
            Socket socket = serverSocket.accept();
            System.out.println("Receiver: Connection established with Sender.");

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // Simulate receiving messages
            while (true) {
                try {
                    // Receive message from the sender
                    String message = (String) in.readObject();
                    System.out.println("Receiver: Received message - " + message);

                    // Simulate error by randomly deciding to send ACK or NACK
                    if (Math.random() < 0.8) {
                        // Send ACK
                        out.writeObject("ACK");
                        out.flush();
                        System.out.println("Receiver: Sent acknowledgment - ACK");
                    } else {
                        // Send NACK
                        out.writeObject("NACK");
                        out.flush();
                        System.out.println("Receiver: Sent acknowledgment - NACK");
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
