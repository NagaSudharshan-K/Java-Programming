import java.io.*;
import java.net.*;

class Sender3
{
public static void main(String args[])
{
try
{
Socket s = new Socket("localhost",1234);
ObjectInputStream in = new ObjectInputStream(s.getInputStream());
ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
System.out.println("CONNECTED TO RECEIVER");

for(int i=0;i<5;i++)
{
String msg = "Message"+i;
out.writeObject(msg);
out.flush();
try
{
s.setSoTimeout(60000);
String msgrcv = (String) in.readObject();
System.out.println("Message Received:"+msgrcv);
if(msgrcv.equals("ACK"))
{
System.out.println("MEssage sent successfully");
}
else
{
System.out.println("MEssage not sent successfully");
i--;
}
}
catch(Exception e){
System.out.println("MEssage not sent successfully");
i--;
}
}
out.close();in.close();s.close();}
catch(Exception e){}
}
}