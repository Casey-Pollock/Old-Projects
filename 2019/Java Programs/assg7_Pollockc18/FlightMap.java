/* @author Casey Pollock
 *         Assignment 3
 *         CSCI 2540
 *
 * This class will be used to create and use a FlightMap. The served 
 * Cities and the flights connecting different Cities will be loaded 
 * from a text file.  The FlightMap can have given Cities visitation 
 * updated, can check if a certain City is served, have the serviced 
 * Cities printed, and have the connecting flights printed.  The 
 * FlightMap can be searched to find if there is some number of connecting 
 * flights between two Cities.
*/


package assg7_Pollockc18;


import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class FlightMap implements FlightMapInterface {
	
	private LinkedList<City> allFlights;
	private LinkedList<City>[] flightPaths;

	/**
	 * Creates an empty FlightMap
	 */
	public FlightMap() {
		
		allFlights=new LinkedList<City>();
		flightPaths=null;
		
	}
	
	/**
	 * Retrieves information about the cities and adjacencies from the two
	 * files provided and stores the information in the FlightMap object.
	 * @param cityFileName The name of a file containing a list of city names; 
	 *        one city name per line.
	 * @param flightFileName The name of a file showing city adjacencies.  
	 *        There will be two city names listed per line, separated by a tab
	 *        character; the first city on the line is adjacent to the 
	 *        second city on the same line.
	 * @throws FileNotFoundException if either the city file or the flight
	 *         file are not able to be opened.
	 */
	public void loadFlightMap(String cityFileName, String flightFileName)
			throws FileNotFoundException {
		
		Scanner inputFile=new Scanner(new File(cityFileName));
		String name;
		
		while(inputFile.hasNext()) {
			
			name=inputFile.nextLine();
			this.allFlights.push(new City(name));
			
		}
		
		inputFile.close(); City tempCity0, tempCity1; int tempInt=this.allFlights.size();
		inputFile=new Scanner(new File(flightFileName));
		this.flightPaths=new LinkedList[tempInt];
		
		for(int count=0; count<tempInt; count++) {
			
			this.flightPaths[count]= new LinkedList<City>();
			
		}
		
		while(inputFile.hasNext()) {
			
			name=inputFile.next(); 
			tempCity0=new City(name);
			name=inputFile.next();
			tempCity1=new City(name);
			this.insertAdjacent(tempCity0, tempCity1);
				
		}
		
		inputFile.close();
		
	}

	/**
	 * Inserts information into the flight map to record the fact that there
	 * is a direct flight between aCity and adjCity. Both aCity and adjCity
	 * are assumed to be valid cities that are served by the airline.
	 * @param aCity The origin city.
	 * @param adjCity The destination city.
	 */
	public void insertAdjacent(City aCity, City adjCity) {		
		
		int tempInt;
		
		tempInt=this.allFlights.indexOf(aCity);
		if(!this.flightPaths[tempInt].contains(adjCity))
			this.flightPaths[tempInt].push(adjCity);
		tempInt=this.allFlights.indexOf(adjCity);
		if(!this.flightPaths[tempInt].contains(aCity))
			this.flightPaths[tempInt].push(aCity);
		
	}

	/**
	 * Displays to the screen, a list of all cities served by the airline
	 * along with the names of cities to which each is adjacent.
	 */
	public void displayFlightMap() {	
		
		City tempCity; int tempInt=this.allFlights.size();
		Iterator<City> listAll= this.allFlights.iterator();
		Iterator<City> listCity;
	
		for(int count=0; count<tempInt; count++) {
		
			tempCity=listAll.next();
			System.out.print(tempCity+" has flights to ");
			listCity=this.flightPaths[count].iterator();
	
			while(listCity.hasNext()) {
		
				tempCity=listCity.next();
				if(listCity.hasNext())
					System.out.print(tempCity.toString()+", ");
				else
					System.out.print("and "+tempCity.toString()+"\n");
	
			}
		
		}
		
	}

	/**
	 * Displays to the screen, the names of all cities served by the airline.
	 */
	public void displayAllCities() {
		
		City temp;			
		Iterator<City> list= this.allFlights.iterator();
		
		System.out.println("Cities that are serviced are:");
		while(list.hasNext()) {
			
			temp=list.next();
			if(list.hasNext())
				System.out.print(temp.toString()+", ");
			else
				System.out.print("and "+temp.toString()+"\n");
			
		}
		
		
	}

	/**
	 * Displays to the screen, the names of all cities which are are adjacent
	 * to aCity; aCity is assumed to be a valid city served by the airline.
	 * @param aCity The city for which the adjacency list is desired.
	 */
	public void displayAdjacentCities(City aCity) {				
		
		int tempInt=this.allFlights.indexOf(aCity); City tempCity;
		Iterator<City> list= this.flightPaths[tempInt].iterator();
		
		System.out.println("Cities that are adjacent to "+aCity+" are:");
		while(list.hasNext()) {
			
			tempCity=list.next();
			if(list.hasNext())
				System.out.print(tempCity.toString()+", ");
			else
				System.out.print("and "+tempCity.toString()+"\n");
			
		}
		
	}

	/**
	 * Records information to note that aCity has been visited in the path 
	 * so that aCity won't be returned again; aCity is assumed to be 
	 * a valid city served by the airline.
	 * @param aCity The city to be marked.
	 */
	public void markVisited(City aCity) {
		
		Iterator<City> list= this.allFlights.iterator();
		int tempInt=this.allFlights.size(); City tempCity;
		
		for(int count=0; count<tempInt; count++) {
			
			tempCity=list.next();
			if(aCity.equals(tempCity)) {
				
				tempCity.visit();
				break;
				
			}
				
			
		}
		
	}

	/**
	 * Removes the visited marks on all cities served by the airline.
	 */
	public void unVisitAll() {		
		
		Iterator<City> list= this.allFlights.iterator();
		int tempInt=this.allFlights.size(); City tempCity;
		
		for(int count=0; count<tempInt; count++) {
			
			tempCity=list.next();
			tempCity.clear();
			
		}
		
	}

	/**
	 * Determines whether or not aCity has been visited
	 * @param aCity The city for which you wish to determine visited status.
	 * @return True if aCity has been visited, and false otherwise.
	 */
	public boolean isVisited(City aCity) {
		
		Iterator<City> list= this.allFlights.iterator();
		int tempInt=this.allFlights.size(); City tempCity;
		
		for(int count=0; count<tempInt; count++) {
			
			tempCity=list.next();
			if(aCity.equals(tempCity)) {
				
				return tempCity.isVisited();
				
			}
				
			
		}
		return false;
		
	}

	/**
	 * Gets the next unvisited city, if any, to which aCity is adjacent.
	 * @param aCity The city for which you wish to get the next adjacency.
	 * @return The next unvisited city to which you can directly travel
	 *         from aCity, or null there are no unvisited cities to which
	 *         you can travel from aCity.
	 */
	public City getNextCity(City aCity) {
		
		Iterator<City> list=this.flightPaths[this.allFlights.indexOf(aCity)].iterator();
		City temp;
		
		while(list.hasNext()) {
			
			temp=list.next();
			if(!this.isVisited(temp))
				return temp;
			
		}
		return null;
		
	}

	/**
	 * Determines if the airline serves aCity
	 * @param aCity The city to check
	 * @return True if the airline has flights leaving or arriving at
	 *         aCity and false otherwise
	 */
	public boolean servesCity(City aCity) {
		
		if(this.allFlights.contains(aCity))
			return true;
		else
			return false;
		
	}

	/**
	 * Determines if there is a sequence of flights which start at originCity,
	 * and take you to destinationCity; Both originCity and destinationCity are
	 * assumed to be valid cities served by the airline.
	 * @param originCity The city from which the search should begin
	 * @param destinationCity The final city at which you wish to arrive
	 * @return A LinkedList object containing a list of cities starting at the
	 *         originCity and ending at destinationCity, if there is a sequence 
	 *         of flights from originCity to destinationCity. The
	 *         originCity will be found in position 0 of the list.
	 *         If no sequence of flights exist, then null will be returned.
	 */
	public LinkedList<City> getPath(City originCity, City destinationCity) {
		
		
		Stack<City> path=new Stack<City>();
		City topCity, tempCity;
		int tempInt;
		
		path.push(originCity);
		this.unVisitAll();
		topCity=path.peek();
		this.markVisited(topCity);
		while(!path.isEmpty()) {

			topCity=path.peek();
			if(topCity.equals(destinationCity)) {
				
				LinkedList<City> pathFin=new LinkedList<City>();
					
				while(!path.isEmpty()) {
						
					tempCity=path.pop();
					pathFin.push(tempCity);
							
				}
				return pathFin;
						
			}
			tempInt=this.allFlights.indexOf(topCity);
			if(this.flightPaths[tempInt].contains(destinationCity)) 				
				tempCity=destinationCity;
			else
				tempCity=this.getNextCity(topCity);
			if(tempCity==null)
				path.pop();
			else {
				
				path.push(tempCity);
				this.markVisited(tempCity);
				
			}
			
		}
		return null;
		
	}


}
