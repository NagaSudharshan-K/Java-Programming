import java.net.*;
import java.rmi.*;
import java.io.*;


class client
{
public static void main(String args[])
{
try
{
String s = "rmi://localhost/RMserver";
Myserverint obj = (Myserverint)Naming.lookup(s);
System.out.println("ANS:"+obj.add(10,20));
}
catch(Exception e){}
}

}