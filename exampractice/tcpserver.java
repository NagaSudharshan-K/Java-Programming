import java.net.*;
import java.io.*;

class ServerTCP
{
ServerSocket ss;
Socket s;
ObjectInputStream in;
ObjectOutputStream out;

ServerTCP()
{
try
{
ss = new ServerSocket(5678);
while(true)
{
s=ss.accept();
System.out.println("SERVER CONNECTED TO :"+s.getInetAddress());
try{
out =  new ObjectOutputStream(s.getOutputStream);
in =  new ObjectInputStream(s.getInputStream);
Scanner sc = new Scanner(System.in);
while(true)
{
String msg = (String)in.readObject();
System.out.println("MESSAGE FROM CLIENT:"+msg);
System.out.println("Your Message:\n");
sendmsg = sc.nextLine();
out.writeObject(sendmsg);
out.flush();
}
}
catch(Exception e){}
}
}
catch(Exception e){}

}
}