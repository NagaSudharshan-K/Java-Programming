import java.rmi.*;
import java.net.*;

public class Server
{
	public static void main(String args[])
	{	
		try
		{
		SerImpl obj = new SerImpl();
		Naming.rebind("AdditionRM",obj);
		System.out.println("Server Started...");
		}
		catch(Exception e){System.out.println("Eception"+e);}
	}
}