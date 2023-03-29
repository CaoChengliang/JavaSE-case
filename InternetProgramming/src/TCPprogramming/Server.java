package TCPprogramming;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		//TCP 编程 服务器段
		ServerSocket ss = new ServerSocket(6666);
		
		System.out.println("服务器正在运行");
		
		for(;;) {
			
			Socket socket = ss.accept();
			
			System.out.println("connected from " + socket.getRemoteSocketAddress());
			
			Thread t = new Handler(socket);
			t.start();
			
		}

	}

}
