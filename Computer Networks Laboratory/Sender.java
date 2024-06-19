import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.net.*;

class Sender extends JFrame implements ActionListener, KeyListener {
    JTextArea ta;
    JTextField tf1, tf2;
    JLabel l1, l2, l3;
    JButton b1;
    JScrollPane sp;

    Sender() {
        l1 = new JLabel("To             :");
        l1.setBounds(10, 500, 70, 20);
        tf1 = new JTextField();
        tf1.setBounds(70, 500, 430, 20);

        l2 = new JLabel("Message :");
        l2.setBounds(10, 530, 70, 20);
        tf2 = new JTextField();
        tf2.setBounds(70, 530, 430, 20);

        b1 = new JButton("Send");
        b1.setBounds(510, 500, 70, 50);

        l3 = new JLabel("Welcome Back :)");
        l3.setBounds(230, 20, 150, 20);

        ta = new JTextArea();
        ta.setEditable(false);

        sp = new JScrollPane(ta);
        sp.setBounds(20, 50, 540, 400);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        b1.addActionListener(this);

        // Add KeyListener to the tf2 (message) text field
        tf2.addKeyListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(b1);
        add(l3);
        add(sp);
        setTitle("Sender");
        setLayout(null);
        setSize(600, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        sendMessage();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            sendMessage();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    private void sendMessage() {
        String msg = tf2.getText();
        if (!msg.isEmpty()) {
	    Date date = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm");
    
            ta.append("You ["+ft.format(date)+"] :\n" + msg + "\n");
            tf2.setText("");
	    try
		{
			Socket s1 = new Socket("127.0.0.1",2000);

			OutputStream out = s1.getOutputStream();
			InputStream in = s1.getInputStream();

			byte b[]=new byte[100];

			while(true)
			{
			//in.read(b);
			//System.out.println(new String(b));
			//Scanner sc =  new Scanner(System.in);
			//String str1=sc.nextLine();
			//out.write(str1.getBytes());
			//System.out.print("[Message Sent]\n");
			String str1=tf2.getText();
			out.write(str1.getBytes());
			
			}
			//out.write("Hello".getBytes());
			//Thread.sleep(10000);

			//System.out.println("Message Sent");
		}
	    catch(Exception e){}
        }
    }

    public static void main(String args[]) {
        new Sender();
    }
}
