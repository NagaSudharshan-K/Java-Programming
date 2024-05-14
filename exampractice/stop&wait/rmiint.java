import java.rmi.*;

public interface rmiint extends Remote
{
double addition(double a, double b) throws RemoteException;
}