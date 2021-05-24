import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		try {
			ServerSocket sock = new ServerSocket (6013);
			System.out.println("[Server]: Started. Waiting for connection ");
			
			//now listen for connections
			while(true) {
				
				Socket client = sock.accept();
				System.out.println("Server is connected to the Client.");
				
				// Get the input and output stream from the socket connection
				BufferedReader br = new BufferedReader (new InputStreamReader (client.getInputStream()));
				PrintWriter pout = new PrintWriter (client.getOutputStream(),true);
				
				String line;
				
				//read the input stream from the socket connection
				while((line = br.readLine()) != null){
					System.out.println("From Client: "+line);
					//write input stream to the socket
					pout.println(line);
				}
				//close the socket and resume listening for connection
				client.close();
			}
		}catch(IOException ioe) {
			System.err.println(ioe);
		}
	}
}
