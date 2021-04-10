/* @author Casey Pollock
 * Assignment 8
 * CSCI 2540
 *
 * This class will be used to create and use an Event object.
 * This will store the Event type, patron number, and the time 
 * of the Event.
*/


package assg8_pollockc18;

public class Event {

	private String type;
	private int patron;
	private int time;
	
	/**
	 * Initializes a City with cityName and marks the
	 * City as unvisited.
	 * @param type The type of event
	 * @param patron A number assigned to each specific person
	 * @param time The time the Event should take place
	 */
	public Event(String type, int patron, int time) {
		
		this.type=type;
		this.patron=patron;
		this.time=time;
		
	}
	
	/** 
	 * Gets the Type of an Event.
	 * @return The Event type
	 */

	public String getType() {
		
		return this.type;
		
	}
	
	/** 
	 * Gets the time of an Event
	 * @return The Event's time
	 */
	public int getTime() {
		
		return this.time;
		
	}
	
	/** 
	 * Gets the patron number of an Event
	 * @return The number of the patron at the Event
	 */
	public int getPatronNum() {
		
		return this.patron;
		
	}
	
	/**
	 * Overridden toString method
	 * @return The type and the time of an Event
	 */
	public String toString() {
		
		return (this.type+" event at time:\t"+this.time);
		
	}
	
}
