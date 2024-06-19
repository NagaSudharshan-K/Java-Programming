import java.net.*;
import java.io.*;
import java.util.*;

class TestReceiver
{
	public static void main(String args[])
	{	
		try
		{
			Socket s1 = new Socket("127.0.0.1",2000);

			OutputStream out = s1.getOutputStream();
			InputStream in = s1.getInputStream();

			byte b[]=new byte[100];

			while(true)
			{
			in.read(b);
			System.out.println(new String(b));
			Scanner sc =  new Scanner(System.in);
			String str1=sc.nextLine();
			out.write(str1.getBytes());
			System.out.print("[Message Sent]\n");
			
			}
			//out.write("Hello".getBytes());
			//Thread.sleep(10000);

			//System.out.println("Message Sent");
		}
		catch(Exception e)
		{
			
		}
	}
}