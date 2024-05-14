import java.net.*;

class senderudp
{
public static void main(String args[])
{
try
{
DatagramSocket socket = new DatagramSocket();
byte b[] = "Hello World!".getBytes();
DatagramPacket dp = new DatagramPacket(b,b.length,InetAddress.getByName("230.1.1.1"),1234);
socket.send(dp);
socket.close();
}
catch(Exception e){}
}
}