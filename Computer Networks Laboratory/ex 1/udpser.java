import java.net.*;
import java.io.*;
import java.util.*;

class udpser
{
	public static void main(String args[])
	{
		try{
		DatagramSocket ds = new DatagramSocket(9999);
		DatagramPacket dp = new DatagramPacket("welcome".getBytes(),"welcome".length(),InetAddress.getByName("127.0.0.1"),5555);
		ds.send(dp);
		System.out.println("sent..");}catch(Exception e){}
	}
}