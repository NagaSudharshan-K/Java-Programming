import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
class sert2{
   JFrame f;
   JTextField t1;
   JButton b1;
   JTextArea a1;
   int port;
   Socket se;
   String serip;
   Socket s;
   ObjectInputStream oi;
   ObjectOutputStream os;
   sert2(String ser){
       f=new JFrame();
       f.setTitle("client");
       t1=new JTextField(20);
       b1=new JButton("send");
       a1=new JTextArea(40,40);
       port=9999;
       serip=ser;
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
   void startRun(){
     
       try{
           s=new Socket(InetAddress.getByName(serip),port);
           while(true){
               os=new ObjectOutputStream(s.getOutputStream());
               oi=new ObjectInputStream(s.getInputStream());
               whilech();
           }
       }
       catch(Exception e){}
   }
   void whilech(){
       try{
           int ctr=0;
           String rea;
           do{
               rea=(String) oi.readObject();
               a1.append(rea+"\n");
               ctr++;
           }while(ctr<10);
       }
       catch(Exception g){}
   }
   void sendmes(String sr){
       try{
           a1.append("me-"+sr);
           os.writeObject("                  Client-"+sr);
           os.flush();
       }
       catch(Exception ew){}


   }




}
public class TCPClient{
   public static void main(String[] args) {
       sert2 s1=new sert2("127.0.0.1");
       s1.startRun();
   }
}
