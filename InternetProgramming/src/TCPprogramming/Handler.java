package TCPprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Handler extends Thread {
          
	Socket sock;
	
	public Handler(Socket sock) {
		
		this.sock = sock;
		
	}
	
	
	@Override
	public void run() {
		
		try (InputStream input = sock.getInputStream();){
			try (OutputStream output = sock.getOutputStream()){
				
				handle(input, output);//获取输入输出值
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void handle(InputStream input, OutputStream output) throws IOException {
		
		var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
		var reader = new BufferedReader(new InputStreamReader(input,StandardCharsets.UTF_8 ));
		
		writer.write("Hello\n");
		writer.flush();
		
		for (;;) {
            String s = reader.readLine();
            if (s.equals("bye")) {
                writer.write("bye\n");
                writer.flush();
                break;
            }
            writer.write("ok: " + s + "\n");
            writer.flush();
        }
		
		
		
	}
	
	
}
