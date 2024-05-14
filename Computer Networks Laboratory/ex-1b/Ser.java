import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;


class Ser
{
ObjectOutputStream op;
ObjectInputStream ip;
ServerSocket ss;
Socket s;
String msg="";
int port=9999;
int totcli = 50;
JFrame f;
JTextArea ta;
JTextField tf;
JButton b;

Ser()
{
f = new JFrame();
ta = new JTextArea(40,40);
tf = new JTextField(20);
b = new JButton("Send");
f.add(ta);
f.add(tf);
f.add(b);
b.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent ae)
{
String s1=tf.getText();
tf.setText("");
sendmes(s1);
}});
f.setTitle("Server");
f.setVisible(true);
f.setLayout(new FlowLayout());
}
public void running()
{
try
{
ss = new ServerSocket(port,totcli);
while(true)
{
try
{
ta.append("\nServer waiting to connect..");
s= ss.accept();
ta.append("\n Server connected to "+s.getInetAddress().getHostName());
op = new ObjectOutputStream(s.getOutputStream());
op.flush();
ip = new ObjectInputStream(s.getInputStream());
whilechat();
}catch(Exception e){}
}
}catch(Exception e){}
}
public void whilechat()
{
while(!msg.equals("Bye"))
{
try
{
msg = (String)ip.readObject();
ta.append(msg);

}catch(Exception e){}
}
}
public void sendmes(String msg)
{
try{
ta.append("\nME(SERVER):"+msg);
op.writeObject("\n Server:"+msg);
op.flush();}catch(Exception e){}
}
public static void main(String args[])
{
Ser obj =  new Ser();
obj.running();
}
}