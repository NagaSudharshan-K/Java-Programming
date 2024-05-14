import java.io.*;
import java.net.*;
import java.util.*;
class TestSender1
{
	public static void main(String ar[])
	{
		try
		{
			DatagramSocket ds=new DatagramSocket(3000);
			Scanner sc= new Scanner(System.in);
			String s = sc.nextLine();
			DatagramPacket dp=new DatagramPacket(s.getBytes(),s.length(),InetAddress.getByName("127.0.0.1"),4000);
			
			ds.send(dp);
			System.out.println("Successfully sent...");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}