/* @author Casey Pollock
 *         Assignment 3
 *         CSCI 2540
 *
 * This class will be used to replace characters
 * in a string with some other character.  This will
 * either replace just the first instance of the 
 * character or all instances of the character.
*/


import java.util.*;
package assg5_Pollockc18_part2;

public class RecursionTest {
	
	
	/* This method will find the first instance of oldChar
	 * and replace it with newChar in a string and return 
	 * the new string.  If there is no instance of oldChar 
	 * the original string will be returned.
	 *
	 * @param str		The string that will have some character replaced. 
	 * @param oldChar	The character that will be replaced.
	 * @param newChar	The character that will replace oldChar.
	 * @return 			A string that will have the first 
	 * 					oldChar replaced with newChar.
	*/
	public static String replaceFirst(String str, char oldChar, char newChar) {
		
		if(str==null|| str.equals("")) {
			
			return "";
			
		}
		else if(str.charAt(0)==oldChar) {
			
			return (newChar+str.substring(1));
			
		}
		else {
			
			return (str.charAt(0)+replaceFirst(str.substring(1), oldChar, newChar));
			
		}
		
	}
	/* This method will find the all instances of oldChar
	 * and replace them with newChar in a string and return 
	 * the new string.  If there is no instance of oldChar 
	 * the original string will be returned.
	 *
	 * @param str		The string that will have some character replaced. 
	 * @param oldChar	The character that will be replaced.
	 * @param newChar	The character that will replace oldChar.
	 * @return 			A string that will have the all instances of
	 * 					oldChar replaced with newChar.
	*/
	public static String replaceAll(String str, char oldChar, char newChar) {
		
		if(str==null|| str.equals("")) {
		
			return "";
			
		}
		else if(str.charAt(0)==oldChar) {
			
			return (newChar + replaceAll(str.substring(1), oldChar, newChar));
			
		}
		else {
			
			return (str.charAt(0)+replaceAll(str.substring(1), oldChar, newChar));
			
		}
		
	}
	public static void main(String[] args) {
		
		int choice; 
		String str, newstr; 
		char oldChar, newChar;
		Scanner kbd= new Scanner(System.in);
		
		do {
			
			System.out.println("1. Test replaceFirst method\n2. Test replaceAll method\n3. Exit");
			System.out.print("Enter your choice: ");
			choice=kbd.nextInt();
			if(choice==1) {
				
				System.out.print("Please enter a string: ");
				str=kbd.next();
				System.out.print("Please enter a character you would like to change: ");
				oldChar=kbd.next().charAt(0);
				System.out.print("Please enter the character that "+oldChar+" will be replaced with: ");
				newChar=kbd.next().charAt(0);
				newstr=replaceFirst(str, oldChar, newChar);
				System.out.println("The new string is: "+newstr);
				
			}
			if(choice==2) {
				
				System.out.print("Please enter a string: ");
				str=kbd.next();
				System.out.print("Please enter a character you would like to change: ");
				oldChar=kbd.next().charAt(0);
				System.out.print("Please enter the character that "+oldChar+" will be replaced with: ");
				newChar=kbd.next().charAt(0);
				newstr=replaceAll(str, oldChar, newChar);
				System.out.println("The new string is: "+newstr);
				
			}
			
		} while(choice!=3);
		
		kbd.close();

	}
	

}
