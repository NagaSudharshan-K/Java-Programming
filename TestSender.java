import java.net.*;
import java.io.*;
import java.util.*;

class TestSender
{
	public static void main(String args[])
	{	
		try
		{
			ServerSocket ss = new ServerSocket(2000);
			System.out.println("Ready To Provide service: ");
			Socket s = ss.accept();
			
			OutputStream out = s.getOutputStream();
			InputStream in = s.getInputStream();
			byte b[]=new byte[100];

			while(true)	
			{
			Scanner sc =  new Scanner(System.in);
			String str1=sc.nextLine();
			out.write(str1.getBytes());
			System.out.print("[Message Sent]\n");
			in.read(b);
			System.out.println(new String(b));
			if(str1.equals('q'))
			break;
			}
			//Thread.sleep(10000);
			//in.read(b);
			//System.out.println(new String(b));
		}
		catch(Exception e)
		{
			
		}
	}
}