import java.rmi.*;
import java.rmi.server.*;
public class SerImpl extends UnicastRemoteObject implements SerInt
{
	SerImpl() throws RemoteException
	{}
	public int addition(int a, int b)
	{
		return a+b;
	}
}