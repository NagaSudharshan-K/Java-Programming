import java.io.*;
import java.net.*;
class TestReceiver1
{
	public static void main(String ar[])
	{
		try
		{
			DatagramSocket ds=new DatagramSocket(4000);
			byte b[]=new byte[1000];

			DatagramPacket dp=new DatagramPacket(b,0,100);
			ds.receive(dp);

			System.out.println(new String(dp.getData()));
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}