import java.util.*;
import java.net.*;
import java.io.*;

class clientTCP
{
Socket s;
ObjectInputStream in;
ObjectOutputStream out;
Scanner sc;

clientTCP()
{
try
{
s = new Socket("localhost",5678);
System.out.println("YOU ARE CONNECTED TO THE SERVER:"+s.getInetAddress());
out = new ObjectOutputStream(s.getOutputStream());
in = new ObjectInputStream(s.getInputStream());
sc = new Scanner(System.in);
while(true)
{
System.out.println("Your Message?\n");
String sendmsg = sc.nextLine();
out.writeObject(sendmsg);
out.flush();
String msg = (String)in.readObject();
System.out.println("MESSAGE FROM SERVER:"+msg);
}
}
catch(Exception e){}
}
public static void main(String args[])
{
clientTCP c = new clientTCP();
}
}