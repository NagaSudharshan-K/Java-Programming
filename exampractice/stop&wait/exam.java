import java.io.*;

class exam
{
public static void main(String args[]) throws Exception
{
FileReader f = new FileReader("file1.txt");
String msg = new String();
int i;
while((i=f.read())!=-1)
msg+=(char)i;
System.out.println(msg);
}
}