class trial
{
public static void main(String args[])
{
String s = "hello";
int val[]= new int[5];
for (int i=0;i<s.length();i++)
{
val[i] = (int)s.charAt(i) + 4;
System.out.println(Character.toString((char)val[i]));
}
for (int i=0;i<s.length();i++)
{
val[i] -= 4;
System.out.println(Character.toString((char)val[i]));
}
}
}