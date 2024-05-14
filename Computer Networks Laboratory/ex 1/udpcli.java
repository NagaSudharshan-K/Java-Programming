import java.net.*;
import java.io.*;
import java.util.*;

class udpcli
{
	public static void main(String args[])
	{try{
		DatagramSocket ds = new DatagramSocket(5555);
		byte b[] =  new byte[1001];
		DatagramPacket dp = new DatagramPacket(b,0,1000);
		ds.receive(dp);
		System.out.println("Packet received:"+new String(dp.getData()));}catch(Exception e){}
	}
}