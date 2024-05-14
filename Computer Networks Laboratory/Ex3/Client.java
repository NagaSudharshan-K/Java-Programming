import java.rmi.*;
import java.net.*;

public class Client
{
	public static void main(String args[])
	{
		try
		{
			String name="rmi://"+args[0]+"/AdditionRM";
			SerInt obj = (SerInt)Naming.lookup(name);
			System.out.println(obj.addition(1,1));
		}	
		catch(Exception e){System.out.println("Eception"+e);}
	}
}