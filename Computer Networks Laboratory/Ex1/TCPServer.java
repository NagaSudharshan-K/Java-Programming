import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
class sert{
   JFrame f;
   JTextField t1;
   JButton b1;
   JTextArea a1;
   int port;
   int no;
   ServerSocket ss;
   Socket s;
   ObjectInputStream oi;
   ObjectOutputStream os;
   sert(){
       f=new JFrame();
       f.setTitle("Server");
       t1=new JTextField(20);
       b1=new JButton("send");
       a1=new JTextArea(40,40);
       port=9999;
       no=10;
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
           ss=new ServerSocket(port, no);
           while(true){
               s=ss.accept();
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
           os.writeObject("                  Server-"+sr);
           os.flush();
       }
       catch(Exception ew){}


   }


}
class TCPServer{
   public static void main(String[] args) {
       sert s1=new sert();
       s1.startRun();
   }
}
