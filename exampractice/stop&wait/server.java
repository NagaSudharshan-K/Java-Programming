import java.rmi.*;
import java.net.*;

class server
{
public static void main(String args[])
{
try
{
rmiimpl obj = new rmiimpl();
Naming.rebind("RMI",obj);
System.out.println("Server Started!");
}
catch(Exception e){}
}
}