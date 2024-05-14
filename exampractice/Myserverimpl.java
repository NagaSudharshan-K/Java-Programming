import java.rmi.*;
import java.rmi.server.*;

class Myserverimpl extends UnicastRemoteObject implements Myserverint
{
Myserverimpl() throws RemoteException {}
public double add(double a, double b) throws RemoteException
{
return a+b;
}
}