/* @author Casey Pollock
 * Assignment 1
 * CSCI 3000
 *
 * This class will create the client half of the client-server.  This client is made 
 * to take information and have it echoed back at the client.  The client will end 
 * when quit is sent as the input. The client and server will be shut down if kill is sent.
*/

import java.io.*;
import java.net.*;
import java.util.*;

public class Question_4_Client{
	
	public static void main(String[] args) {
		
		try {
			
			Socket sock = new Socket("127.0.0.1",3000);								//Socket that will connect to my server.
			Scanner kbd = new Scanner(System.in);									//Keyboard input.
			InputStream in = sock.getInputStream();									//The input that comes from the server.
			OutputStream out = sock.getOutputStream();								//The output that goes to the server.
			PrintWriter pout = new PrintWriter(out, true);							//The converter from a string into bytes for the output.
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));		//The storage of the string from the in.
			String line;															//String to hold the transfering information.
			boolean escape = false;													//Used to notify when the client should close.
			while(!escape) {
				
				System.out.println("Please Enter your phrase or enter quit to exit.");
				line = kbd.nextLine();												//Getting information that will be echoed.
				if(line.equalsIgnoreCase("quit")||line.equalsIgnoreCase("kill")) {	//Checking if the user wishes to exit the client.
					
					escape = true;
					pout.println(line);												//Informing the server that the client has left.
					
				}
				else {
					
					pout.println(line);												//Sending information to the server.
					line = bin.readLine();											//Retrieving the echoed information from the server.
					System.out.println(line);										//Printing the echoed information.
		
				}
				
			}
			sock.close();
			kbd.close();
			
		}
		catch (IOException ioe) {
			
			System.out.print("Error: Input/OutPut could not be completed.");
					
		}
		
	}
	
}
