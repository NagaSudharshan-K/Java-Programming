import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class tcpcli
{
	JFrame f;
	   JTextField t1;
   JButton b1;
   JTextArea a1;
	ObjectOutputStream op;
	ObjectInputStream ip;
	Socket s;
	ServerSocket ss;
	int totcli=50;
	int port = 9999;
	String msg="";
	tcpcli()
	{
	f=new JFrame();
       f.setTitle("client");
       t1=new JTextField(20);
       b1=new JButton("send");
       a1=new JTextArea(40,40);
	f.add(a1);
       f.add(t1);
       f.add(b1);
       b1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               String s2=t1.getText();
               t1.setText(" ");
               sendmes(s2);
           }
       });
       f.setVisible(true);
       f.setLayout(new FlowLayout());
	}
	public void sendmes(String message)
	{
	try
        {
            
            a1.append("\nME(Client) - "+message);
            op.writeObject("                                                             Client - " + message);
            op.flush();
        }
        catch(IOException ioException)
        {
            a1.append("\n Unable to Send Message");
        }
	}
	public void running()
	{
		try
		{
			System.out.println("Attempting to connect...");
			try{
			s = new Socket(InetAddress.getByName("127.0.0.1"),port);}catch(IOException e){}
					System.out.println("Connected to -"+s.getInetAddress().getHostName());
					op = new ObjectOutputStream(s.getOutputStream());
					op.flush();
					ip = new ObjectInputStream(s.getInputStream());
					whilechat();
		}
		catch(Exception e){}
	}
public void whilechat()
{
	while(!msg.equals("Bye"))
	{	try{
		msg = (String) ip.readObject();
		a1.append(msg);}catch(Exception e){}
	}
}
public static void main(String args[])
{
	tcpcli obj = new tcpcli();
	obj.running();
}
}
