import java.net.*;

class Sendergbn
{
public static void main(String args[])
{
int window=4;
try{
Socket s = new Socket("localhost",1234);
ObjectInputStream in = new ObjectInputStream(s.getInputStream());
ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
int counter=window;
int sqn = 0;
while(true)
{
for(int i=0;i<counter;i++)
{
String Msg = "Message " + sqn;
out.writeObject(Msg);
out.flush();
sqn++;
}
String msgrcv =(String) in.readObject();
if(msgrcv.startsWith("ACK"))
{
int ackn = Integer.parseInt(msgrcv.substring(3));
counter+=ackn;
System.out.println("ACK received for "+ackn);
}
else
{
int ackn = Integer.parseInt(msgrcv.substring(3));
sqn = ackn;
System.out.println("NACK received for "+ackn);
}
}
}
catch(Exception e){}
}
}