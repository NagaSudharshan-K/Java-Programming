import javax.swing.*;
class swing1
{
    swing1()
    {
        JFrame jframe = new JFrame("A simple swing application..");
        jframe.setSize(250, 250);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jlabel = new JLabel("Swing means powerful GUI's");
        jframe.add(jlabel);
        jframe.setVisible(true);
    }
    static public void main(String args[])
    {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run(){new swing1();}});
      }
   }