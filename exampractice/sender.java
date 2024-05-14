import java.net.*;
import java.util.*;

class sender
{
public static void main(String args[])
{
try{
DatagramSocket s = new DatagramSocket();
byte b[] = new byte[1000];
InetAddress group = InetAddress.getByName("230.1.1.1");
Scanner sc = new Scanner(System.in);
while(true)
{
b = sc.nextLine().getBytes();
DatagramPacket dp = new DatagramPacket(b,b.length,group,1234);
s.send(dp);
}
s.close()
}catch(Exception e){}
}
}