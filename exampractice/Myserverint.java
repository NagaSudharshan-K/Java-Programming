import java.rmi.*;

public interface Myserverint extends Remote
{
double add(double a, double b) throws RemoteException;
}