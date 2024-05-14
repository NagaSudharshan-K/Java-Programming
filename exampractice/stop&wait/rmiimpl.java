import java.rmi.*;
import java.rmi.server.*;

class rmiimpl extends UnicastRemoteObject implements rmiint
{
rmiimpl() throws RemoteException {}
public double addition(double a, double b){return a+b;}
}