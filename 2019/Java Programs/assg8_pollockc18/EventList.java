/* @author Casey Pollock
 * Assignment 8
 * CSCI 2540
 *
 * This class will be used to create and use an EventList object.
 * This object will be a list of Events in order by time.  Events 
 * can be added or removed
*/


package assg8_pollockc18;

import java.util.*;

public class EventList {

	private LinkedList<Event> list;
	
	/**
	 * Initializes an empty EventList.
	 */
	public EventList() {
		
		this.list=new LinkedList<Event>();
		
	}
	
	/**
	 *  Adds an Event to the EventList based on the
	 *  time of the Event.
	 */
	public void add(Event evt) {
		
		Iterator<Event> list=this.list.iterator();
		Event temp; int count=0, size=this.list.size();
		
		do {
		
			if(!list.hasNext()) {
				
				this.list.addLast(evt);
				return;
				
			}
			else {
			
				temp=list.next();
				if(temp.getTime()>evt.getTime()) {
			
					this.list.add(count, evt);
					return;
			
				}
				if(temp.getTime()==evt.getTime()) {
			
					if(evt.getType().equals("arrival")) {
					
						this.list.add(count,evt);
						return;
					
					}
			
				}
				
			}
			count++;
		
		}	 
		while(count<size+1);
		
	}

	/**
	 *  Checks for Events in the EventList.
	 * @return True if the EventList is empty
	 */
	public boolean isEmpty() {
		
		return this.list.isEmpty();
		
	}
	
	/**
	 * Removes the Event with the lowest time 
	 * from the EventList
	 * @return The next Event
	 */
	public Event nextEvent() {
		
		return this.list.remove();
		
	}
	
}
