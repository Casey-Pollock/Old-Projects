/* @author Casey Pollock
 * Assignment 2
 * CSCI 3000
 *
 * This class will create the server to send date information to the client.
 *
*/

import java.net.*;
import java.io.*;

public class DateServer{
	
	public static void main(String[] args) {

		try {
			
			//Establish a socket.
			ServerSocket sock = new ServerSocket(3000);
			

			/* now listen for connections */
			while (true) {

				//connect server and client sockets.
				Socket client = sock.accept();
				//create a new thread with the folowing runnable.
				Thread t1 = new Thread(new Runnable() {
					
					public void run() {
					
						try {
							
							PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
							/* write the Date to the socket */
							pout.println(new java.util.Date().toString());
							/* close the socket */
							client.close();
						
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					
				}});
				
				//Start the thread.
				t1.start();
				
			
				
			}
		}
		catch (IOException ioe) {
			
			System.err.println(ioe);

		}

	}

}
