import java.rmi.*;
public interface SerInt extends Remote
{
	int addition(int a, int b) throws RemoteException;
}