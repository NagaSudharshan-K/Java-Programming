import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

class swing4 extends JFrame implements ActionListener, KeyListener {
    JTextArea ta;
    JTextField tf1, tf2;
    JLabel l1, l2, l3;
    JButton b1;
    JScrollPane sp;

    swing4() {
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
        setTitle("Chat Box");
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
        }
    }

    public static void main(String args[]) {
        new swing4();
    }
}
