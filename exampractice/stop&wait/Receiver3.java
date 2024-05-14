import java.io.*;
import java.net.*;

class Receiver3
{
public static void main(String args[])
{
try
{
ServerSocket ss = new ServerSocket(1234);
System.out.println("CONNECTing TO SENDER");
Socket s = ss.accept();
ObjectInputStream in = new ObjectInputStream(s.getInputStream());
ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
System.out.println("CONNECTED TO SENDER");
while(true)
{


String msg = (String)in.readObject();
System.out.println("Message Received:"+msg);
if(Math.random()<0.8)
{
out.writeObject("ACK");
out.flush();
System.out.println("ACK sent for:"+msg);
}
else
{
out.writeObject("NACK");
out.flush();
System.out.println("NACK sent for:"+msg);
}
}
}
catch(Exception e){}
}
}