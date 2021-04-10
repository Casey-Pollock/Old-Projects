/* @author Casey Pollock
 * Assignment 1
 * CSCI 3000
 *
 * This class will create the server half of the client-server.  This server is made 
 * to take information and echo it back to the client.  The server will be shutdown 
 * if the client enters kill.
*/

import java.io.*;
import java.net.*;

public class Question_4_Server{
	
	public static void main(String[] args) {
		
		try {
			
			ServerSocket sock = new ServerSocket(3000);											//ServerSocket that will await a client.
			System.out.println("Server Established");
			boolean kill = false;
			while (!kill) {
				
				Socket client = sock.accept();													//Socket that will connect to my client.
				System.out.println("Server connected.");
				while(!client.isClosed()) {
				
					InputStreamReader in = new InputStreamReader(client.getInputStream());		//The input that comes from the client.
					OutputStream out = client.getOutputStream();								//The output that goes to the client.
					PrintWriter pout = new PrintWriter(out, true);								//The converter from a string into bytes for the output.
					BufferedReader bin = new BufferedReader(in);								//The storage of the string from the in.
					String line;																//String to hold the transferring information.
					line = bin.readLine();														//Retrieves client's next message
					if(line.equalsIgnoreCase("quit")||line.equalsIgnoreCase("kill")) {			//Checks if the client wishes to close the connection.
						
						client.close();
						System.out.println("Client has disconnected.");
						if(line.equalsIgnoreCase("Kill")) {
							
							kill = true;
							
						}																		
					
					}
					else {
						
						pout.println(line);														//Returns information to client.
						
					}
					
				}
				
			}
			System.out.println("Server shuting down.");
			sock.close();
			
		}
		catch (IOException ioe) {
			
			System.out.print("Error: Input/OutPut could not be completed.");
					
		}
		
	}
	
}
