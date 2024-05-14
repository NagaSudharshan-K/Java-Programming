import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class tcpser
{
	ObjectOutputStream op;
	ObjectInputStream ip;
	Socket s;
	ServerSocket ss;
	int totcli=50;
	int port = 9999;
	String msg="";
	JFrame f;
	   JTextField t1;
   JButton b1;
   JTextArea a1;
	
	tcpser()
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
            
            a1.append("\nME(Server) - "+message);
            op.writeObject("                                                             Server - " + message);
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
			ss = new ServerSocket(port,totcli);
			while(true)
			{
				try
				{
					System.out.println("Server waiting for client to connect...");
					s=ss.accept();
					System.out.println("Connected to -"+s.getInetAddress().getHostName());
					op = new ObjectOutputStream(s.getOutputStream());
					op.flush();
					ip = new ObjectInputStream(s.getInputStream());
					whilechat();
				}
				catch(EOFException e){}
			}
		}catch(IOException i){}
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
	tcpser obj = new tcpser();
	obj.running();
}
}
