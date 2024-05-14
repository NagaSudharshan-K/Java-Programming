import java.io.*;
import java.net.*;

public class Sender {
    public static void main(String[] args) {
        try {
            // Establish a TCP connection with the receiver
            Socket socket = new Socket("localhost", 5555);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Simulate sending messages
            for (int i = 0; i < 5; i++) {
                String message = "Message " + i;

                // Send message to the receiver
                out.writeObject(message);
                out.flush();

                System.out.println("Sender: Sent message - " + message);

                // Wait for acknowledgment from the receiver
                try {
                    socket.setSoTimeout(60000); // 1 minute timeout
                    String acknowledgment = (String) in.readObject();
                    System.out.println("Sender: Received acknowledgment - " + acknowledgment);

                    if (acknowledgment.equals("ACK")) {
                        // If ACK is received, send the next message
                        System.out.println("Sender: Sending the next message.");
                    } else {
                        // If NACK is received, retransmit the previous message
                        System.out.println("Sender: Retransmitting the previous message.");
                        i--; // Re-send the previous message
                    }
                } catch (SocketTimeoutException e) {
                    // Timeout occurred, retransmit the previous message
                    System.out.println("Sender: Timeout occurred, retransmitting the previous message.");
                    i--; // Re-send the previous message
                }
            }

            // Close the connection
            out.close();
            in.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
