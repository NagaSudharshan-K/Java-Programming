import java.net.*;
import java.io.*;
import java.util.*;

class multicli
{
public static void main(String args[])
{
try{
Socket s = new Socket("localhost",9999);
System.out.println("Connection established to-"+s.getInetAddress().getHostName());
System.out.println("Enter the msg to server:");
Scanner sc = new Scanner(System.in);
String str =sc.nextLine();
PrintStream p = new PrintStream(s.getOutputStream());
BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
while(str.compareTo("Exit")!=0)
{
p.println(str);
p.flush();
System.out.println("Sent..");
System.out.println("received msg:"+br.readLine());
System.out.println("Enter the msg to server:");
 sc = new Scanner(System.in);
 str =sc.nextLine();
 p = new PrintStream(s.getOutputStream());
}}
catch(Exception e){}
}
}