import java.net.*;

class receiverudp
{
public static void main(String args[])
{
try
{
MulticastSocket socket = new MulticastSocket(1234);
byte b[]=new byte[1000];
socket.joinGroup(InetAddress.getByName("230.1.1.1"));
DatagramPacket dp = new DatagramPacket(b,b.length);
socket.receive(dp);
System.out.println("MESSAGE RECEIVED :"+new String(dp.getData(),dp.getLength()));
socket.leaveGroup(InetAddress.getByName("230.1.1.1"));
socket.close();
}
catch(Exception e){}
}
}