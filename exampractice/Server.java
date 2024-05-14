import java.rmi.*;
import java.net.*;

class Server 
{
public static void main(String args[])
{
try
{
Myserverimpl ob = new Myserverimpl();
Naming.rebind("RMserver",ob);
System.out.println("Serevr Started");
}
catch(Exception e){}
}
}