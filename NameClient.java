/*
 * Bryan Bermejo
 * ACO350 Operating Systems
 * Prof. Eckert
 * Feb. 2, 2022
 *  */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NameClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/*String sent to server*/
		String query = "ID: 1216563751";
      
		//Attempts to establish connection to server
		try (Socket sock = new Socket("profeckert.com", 3501)) {
			/*returns an output stream named output for this socket.*/
			OutputStream output = sock.getOutputStream();
         
         //Creates a new PrintWriter from an existing OutputStream.
			PrintWriter writer = new PrintWriter(output, true);
			writer.println(query);
         
			/*in gathers the data stream from the server, and is allocated to the buffer of size in*/
			InputStream in = sock.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			String line;
			
			while((line = bin.readLine()) != null) {
			   System.out.println(line);
			}
			sock.close();
			
		} catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
       		} 	
	}
}