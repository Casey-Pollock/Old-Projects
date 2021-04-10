/* @author Casey Pollock
 * Assignment 7
 * CSCI 2540
 *
 * This class will be be used to create and manipulate a FlightMap.
 * This FlightMap will be automatically loaded with information about 
 * serviced Cities and flight connecting those Cities. The FlightMap 
 * will be automatically searched to see if there is a connecting flight 
 * between two Cities that have been given. If one of the given Cities 
 * is not serviced then that information will be printed.  And if a 
 * flight path can not be created between the two Cities that information 
 * will be printed.  One the path is generated the path will be printed, 
 * but the printed may not be the shortest path
*/


package assg7_Pollockc18;

import java.io.*;
import java.util.*;

public class DeterminePaths {

	/**
	 * Opens a file that contains flight request.
	 * @param requestFile The name of a file showing city adjacencies.  
	 *        There will be two city names listed per line, separated by a tab
	 *        character; the first city on the line is the starting city and
	 *        the second is the final destination.
	 * @throws FileNotFoundException if either the request file are not able to 
	 * 		   be opened.
	 */
	private static Scanner loadRequestFile(String requestFile) throws FileNotFoundException{
		
		return new Scanner(new File(requestFile));
		
	}
	
	public static void main(String[] args) {
		
		FlightMap flights=new FlightMap();
		LinkedList<City> flightPath;
		City originCity, destination, temp;
		Scanner request; 
		try {
		
			flights.loadFlightMap("cityFile.txt", "flightFile.txt");
			
		}
		catch (FileNotFoundException e) {
			
			System.out.println("Error: File Not Found");
			return;
			
		}
		try {
			
			request=loadRequestFile("requestFile.txt");
			
		}
		catch (FileNotFoundException e) {
			
			System.out.println("Error: File Not Found");
			return;
			
		}
		while(request.hasNext()) {
			
			originCity=new City(request.next());
			destination=new City(request.next());
			
			if(!flights.servesCity(originCity))
				System.out.println("The airline does not serve city "+originCity+".");
			else if(!flights.servesCity(destination))
				System.out.println("The airline does not serve city "+destination+".");
			else {
				
				flightPath=flights.getPath(originCity, destination);
				if(flightPath==null)
					System.out.println("No sequence of flights exist between cities "+originCity+" and "+destination+".");
				else {
					
					System.out.println("The following sequence of flights exist between cities "+originCity+" and "+destination+":");
					ListIterator<City> list=flightPath.listIterator();
					while(list.hasNext()) {
						
						temp=list.next();
						System.out.print(temp);
						if(list.hasNext())
							System.out.print(" to ");
						
					}
					System.out.print("\n");
					
				}
				
			}
			
		}
		request.close();
		

	}

}
