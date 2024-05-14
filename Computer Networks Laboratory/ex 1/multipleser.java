import java.net.*;
import java.io.*;

class multipleser
{
	public static void main(String args[])
	{
	try{
	ServerSocket ss = new ServerSocket(9999);
	while(true)
	{
	Socket s = ss.accept();
	System.out.println("Connection Established..");
	ServerThread st = new ServerThread(s);
	st.start();}}
class ServerThread extends Thread
{
	Socket s=null;
	ServerThread(Socket K)
	{s=k;	}
	void run()
	{try{
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