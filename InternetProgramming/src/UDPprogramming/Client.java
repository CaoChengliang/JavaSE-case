package UDPprogramming;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DatagramSocket ds = new DatagramSocket();
		ds.setSoTimeout(1000);
		ds.connect(InetAddress.getByName("localhost"), 6666);
		//发送数据
		byte[] data = "Hello".getBytes();
		DatagramPacket packet = new DatagramPacket(data,data.length);
		ds.send(packet);
		//接收数据
		
		byte[] buffer = new byte[1024];
		packet = new DatagramPacket(buffer, buffer.length);
		ds.receive(packet);
		String rep = new String(packet.getData(),packet.getOffset(),packet.getLength());
		System.out.println("接收到的数据为====》"+rep);
		ds.disconnect();
		
		
	}

}
