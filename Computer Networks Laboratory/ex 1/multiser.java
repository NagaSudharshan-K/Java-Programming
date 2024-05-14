import java.net.*;
import java.io.*;

class multiser
{
	public static void main(String args[])
	{
	try{
	ServerSocket ss = new ServerSocket(9999);
	Socket s = ss.accept();
	System.out.println("Connection Established..");
	BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	PrintStream p = new PrintStream(s.getOutputStream());
	String str = br.readLine();
	while(str.compareTo("Exit")!=0)
	{
	p.println(str);
	p.flush();
	System.out.println("MSG RECEIVED:"+str);
	str= br.readLine();
	}
	}catch(Exception e){}
	}
}