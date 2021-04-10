// CSCI 2540
// Assignment: 1
// Author:     Casey Pollock
// File:       IntReverse

// Prints the reverse of a given integer.

import java.util.*;

public class IntReverse{
	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		int num;
		
		System.out.println("Please enter an integer: ");
		num=kbd.nextInt();
		System.out.println("\nYour number printed in reverse order is:");
		while(num!=0){
			
			System.out.println(num%10);
			num=num/10;
			
		}
		
		kbd.close();
	}
}