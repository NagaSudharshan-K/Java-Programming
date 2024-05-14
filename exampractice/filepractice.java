import java.io.*;

class filepractice
{
public static void main(String args[])
{
File file1 = new File("file1.txt");
if(file1.exists())
System.out.println("File exists");
else
System.out.println("File Doesn't exist");
try{
file1.createNewFile();}catch(Exception e){}
System.out.println("AFTER CREATING THE FILE (true/false)?"+file1.exists());

File f2 = new File("C:/SUDHARSHAN");
String Files[] = f2.list();
for(String f:Files)
System.out.println(f);
}
}