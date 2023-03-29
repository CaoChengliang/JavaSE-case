package UDPprogramming;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Server {

	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(6666); // 监听指定端口
		for (;;) { // 无限循环
		    // 数据缓冲区:
		    byte[] buffer = new byte[1024];
		    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		    ds.receive(packet); // 收取一个UDP数据包
		    // 收取到的数据存储在buffer中，由packet.getOffset(), packet.getLength()指定起始位置和长度
		    // 将其按UTF-8编码转换为String:
		    String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
		    // 发送数据:
		    byte[] data = "ACK".getBytes(StandardCharsets.UTF_8);
		    packet.setData(data);
		    ds.send(packet);
		}
		
	}
	
	
}
