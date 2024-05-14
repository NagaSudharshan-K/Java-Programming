import java.io.*;
import java.net.*;
import java.util.*;

class trailsend
{
public static void main(String args[])
{
try
{
DatagramSocket ds = new DatagramSocket();
Socket s = new Socket("localhost",567);
ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
Scanner sc = new Scanner(System.in);

System.out.println("CONNECTED TO RECVR:"+s.getInetAddress());
String msg = sc.nextLine();
byte b[]=msg.getBytes();
DatagramPacket dp = new DatagramPacket(b,b.length,InetAddress.getByName("localhost"),1234);
ds.send(dp);
}catch(Exception e){}
}
}