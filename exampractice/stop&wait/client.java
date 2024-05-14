import java.rmi.*;
import java.net.*;

class client
{
public static void main(String args[])
{
try
{
String msg = "rmi://localhost/RMI";
rmiint obj=  (rmiint)Naming.lookup(msg);
System.out.println("ANS:"+obj.addition(10,20));
}catch(Exception e){}
}
}