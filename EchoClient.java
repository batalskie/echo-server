import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {

		try {
			//make a connection to server socket
			Socket sock = new Socket("127.0.0.1",6013);
			
			// Get the input and output stream from the client socket connection
			PrintWriter pout = new PrintWriter(sock.getOutputStream(),true);
			BufferedReader br = new BufferedReader (new InputStreamReader (sock.getInputStream()));
			
			System.out.println("Client is connected to the Server");
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				//Take user input
				System.out.print("Client Message: ");
				String input = sc.nextLine();
				
				//if the client wants to close the connection
				if("exit".equalsIgnoreCase(input)) {
					break;
				}
				pout.println(input);
				
				//read the user input from the client socket
				String response = br.readLine();
				System.out.println("Server Response: "+response);
				
			}
			//close the socket connection
			sock.close();
		}catch(IOException ioe) {
			System.err.println(ioe);
		}
	}
}
