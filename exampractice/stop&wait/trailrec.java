import java.io.*;
import java.net.*;

class trailrec
{
public static void main(String args[])
{
try
{
ServerSocket ss = new ServerSocket(567);
DatagramSocket ds = new DatagramSocket(1234);
while(true)
{
Socket s = ss.accept();
ObjectInputStream in = new ObjectInputStream(s.getInputStream());
System.out.println("CONNECTED TO RECVR:"+s.getInetAddress());
byte b[] =new byte[1000];
DatagramPacket dp =new DatagramPacket(b,b.length);
ds.receive(dp);
System.out.println( new String(dp.getData(),0,dp.getLength()));
}
}catch(Exception e){}
}
}