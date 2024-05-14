import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;


class Cli
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

Cli()
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
String msg=tf.getText();
tf.setText("");
sendmes(msg);
}});
f.setTitle("Client");
f.setVisible(true);
f.setLayout(new FlowLayout());
}
public void running()
{
try{
ta.append("\nTrying to connect..");
try
{
s = new Socket(InetAddress.getByName("127.0.0.1"),port);
}catch(Exception e){}
ta.append("\n Server connected to "+s.getInetAddress().getHostName());
op = new ObjectOutputStream(s.getOutputStream());
op.flush();
ip = new ObjectInputStream(s.getInputStream());
whilechat();
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
ta.append("\nME(Client):"+msg);
op.writeObject("\n Client:"+msg);
op.flush();}catch(Exception e){}
}
public static void main(String args[])
{
Cli obj =  new Cli();
obj.running();
}
}