import java.net.*;
import java.util.*;

class receiver
{
public static void main(String args[])
{
try
{
MulticastSocket s = new MulticastSocket(1234);
InetAddress group = InetAddress.getByName("230.1.1.1");
s.joinGroup(group);
byte b[]= new byte[1000];
DatagramPacket dp = new DatagramPacket(b,b.length);
int num=5;
while(num>0)
{
s.receive(dp);
System.out.println("MESSAGE RECEIVED :"+new String(dp.getData(),0,dp.getLength()));
num--;
}
s.leaveGroup(group);
s.close();
}
catch(Exception e){}
}
}