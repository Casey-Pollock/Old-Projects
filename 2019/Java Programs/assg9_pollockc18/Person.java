/* @author Casey Pollock
 * Assignment 9
 * CSCI 2540
 *
 * This class will be be used to create and manipulate a Person.
 * The Person can have their phone number updated or retrieved.
 * The different Persons may also be compared.
*/

package assg9_pollockc18;

public class Person {
	
	private String name;
	private long number;
	
	/**
	 * Initializes a Person with name and a phone number
	 * @param name The name of a person.
	 * @param num  The phone number of a person.
	 */
	public Person(String name, long num) {
		
		this.name=name;
		this.number=num;
		
	}
	
	/** 
	 * Gets the Number of a Person.
	 * @return The phone number.
	 */
	public long getNumber() {
		
		return this.number;
		
	}
	
	/** 
	 * Gets the Name of a Person.
	 * @return The name.
	 */
	public String getName() {
		
		return this.name;
		
	}
	
	/** 
	 * Changes the phone number of a Person.
	 * @param mun The new phone number of the Person.
	 */
	public void setNumber(long num) {
		
		this.number=num;
		
	}
	
	/**
	 * Overridden toString method
	 * @return The name and phone number of a Person
	 */
	public String toString() {
		
		return (this.name+"\t"+this.number);
		
	}
	
	/**
	 * Overridden equals method
	 * @param obj Some object to test equivalence to.
	 * @return True if the two Persons have the same name.
	 */
	public boolean equals(Object obj) {
		
		if(obj==null){
			
			return false;
			
		}
		else if(obj instanceof Person){
			
			Person temp=(Person)obj;
			return (this.name.equalsIgnoreCase(temp.name));
			
		}
		else{
			
			return false;
			
		}

		
	}
	
	/**
	 * Overridden compareTo method
	 * @param temp The Person to be compared with
	 * @return An integer of the difference between the Persons.
	 */
	public int compareTo(Person temp) {
		
		if(this.equals(temp)) {
			
			return 0;
			
		}
		else {
			
			return this.name.compareToIgnoreCase(temp.name);
				
			
		}

		
	}

}
