/* @author Casey Pollock
 * Assignment 2
 * CSCI 3000
 *
 * This class will create the client to retrieve the date information from the server.
 *
*/

import java.io.*;
import java.net.*;
import java.util.*;

public class DateClient{
	
	public static void main(String[] args) {
		
		try {
			
			Socket sock = new Socket("127.0.0.1",3000);								//Socket that will connect to my server.
			InputStream in = sock.getInputStream();									//The input that comes from the server.
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));		//The storage of the string from the in.
			String line;															//String to hold the transfering information.
			line = bin.readLine();													//Retrieving the echoed information from the server.
			System.out.println(line);												//Printing the echoed information.
			sock.close();
			
		}
		catch (IOException ioe) {
			
			System.out.print("Error: Connection not established.");
					
		}
		
	}
	
}
