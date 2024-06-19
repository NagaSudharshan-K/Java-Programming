import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class swing2 extends JFrame implements ActionListener
{
	JLabel l;
	JTextField tf;
	JButton b;

	swing2()
	{
		tf = new JTextField();
		tf.setBounds(250,300,100,20);
		l = new JLabel();
		l.setBounds(300,50,80,20);
		b = new JButton("Send");
		b.setBounds(370,300,40,20);
		add(l);add(tf);add(b);
		b.addActionListener(this);
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		setTitle("ChatBox");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = tf.getText();
		l.setText(s);
	}
	public static void main(String args[])
	{
		new swing2();
	}
}