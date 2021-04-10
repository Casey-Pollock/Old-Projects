/* @author Casey Pollock
 * Assignment 7
 * CSCI 2540
 *
 * This class will be used to create and use a City object.
 * Book will be used to store the City's name and if the 
 * City has been visited. This class can also manipulate any 
 * given City. The City can also be compared to one another.
*/


package assg7_Pollockc18;

public class City {

	private String name;
	private boolean visited;
	
	/**
	 * Initializes a City with cityName and marks the
	 * City as unvisited.
	 * @param cityName The name of the city to create
	 */
	public City(String cityName) {
		
		name=cityName;
		visited=false;
		
	}
	
	
	/** 
	 * Gets the name of the City
	 * @return The city name
	 */
	public String getName() {
		
		return this.name;
		
	}
	

	/**
	 * Determines if a City has been visited
	 * @return True if the city has been visited
	 *         and false otherwise
	 */
	public boolean isVisited() {
		
		return this.visited;
		
	}
	
	
	/**
	 * Marks the City as having been visited
	 */
	public void visit() {
		
		this.visited=true;
		
	}
	

	/**
	 * Clears the visited mark so the city will
	 * be marked as unvisited.
	 */
	public void clear() {
		
		this.visited=false;
		
	}


	/**
	 * Overridden equals method determines if the
	 * current City name is equal to obj
	 * @param obj The object to be compared to this City
	 * @return True if this city name matches the city name
	 *         in obj, and false otherwise
	 */
	public boolean equals(Object obj) {
		
		if(obj==null){
			
			return false;
			
		}
		else if(obj instanceof City){
			
			City temp=(City)obj;
			return this.name.equals(temp.name);
			
		}
		else{
			
			return false;
			
		}
		
	}
	

	/**
	 * Overridden toString method
	 * @return The name of the city
	 */
	public String toString() {
		
		return this.name;
		
	}

}
