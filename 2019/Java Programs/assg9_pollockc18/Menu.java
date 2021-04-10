/* @author Casey Pollock
 * Assignment 
 * CSCI 2540
 *
 * This class will use the PhoneBook, Person and Node classes 
 * to create and maintain a collection of phone numbers and their 
 * associated person.  The people in the collection may be added, 
 * deleted or updated.  The collection may also be searched for a 
 * specific person and their phone number.  The collection will be 
 * saved once the user decides they wish to quit.
*/

package assg9_pollockc18;

import java.io.*;
import java.util.*;

public class Menu {

	public static void main(String[] args) {
		
		PhoneBook temp=new PhoneBook(); String name; boolean quit=false;
		Scanner kbd=new Scanner(System.in); int choice; long number; Node found;
		
		try {
		
			temp.load("C:\\Users\\HP\\Desktop\\Test\\phoneBook.txt.txt");

		}
		catch(FileNotFoundException e) {
			
			System.out.println("Error: File not found.");
			kbd.close();
			return;
			
		}
		System.out.println("Your phonebook has been loaded.");
		while(!quit) {
			
			System.out.println("What would you like to do next?\n\n1.\tAdd to the phonebook.\n2.\tDelete a person from the phonebook.\n3.\tUpdate a phone number.\n4\tFind a phone number.\n5.\tQuit.");
			choice=kbd.nextInt();
			switch (choice) {
			
			case 1:
				System.out.println("Please enter the person's first and last name:");
				name=kbd.next();
				name=(name+" "+kbd.next());
				System.out.println("Please enter a phone number just as a line of numbers:");
				number=kbd.nextLong();
				temp.add(new Person(name, number));
				break;
			case 2:
				System.out.println("Please enter the person's first and last name:");
				name=kbd.next();
				name=(name+" "+kbd.next());
				temp.delete(name);
				break;
			case 3:
				System.out.println("Please enter the person's first and last name:");
				name=kbd.next();
				name=(name+" "+kbd.next());
				System.out.println("Please Enter a phone number just as a line of numbers");
				number=kbd.nextLong();
				temp.update(name, number);
				break;
			case 4:
				System.out.println("Please enter the person's first and last name:");
				name=kbd.next();
				name=(name+" "+kbd.next());
				found=temp.search(name);
				if(found!=null)
					System.out.println(found.toString());
				else
					System.out.println(name+" has not been found.");
				break;
			case 5:
				try {
					
					temp.save("C:\\Users\\HP\\Desktop\\Test\\phoneBook.txt.txt");
					System.out.println("Your phonebook has been saved.");
					quit=true;
					
				}
				catch(IOException e) {
					
					System.out.println("Error: File could not be saved.");
					
				}
				break;
			default:
				System.out.println("Error: Please enter a valid number.");
				
			
			}
			
		}
		kbd.close();
		
	}

}
