// CSCI 2540
// Assignment: 1
// Author:     Casey Pollock
// File:       EuropeanDate

// Converts the U.S.'s date writing method to the European method.

import java.util.*;

public class EuropeanDate{
	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		String date, month, day, year; int temp, temp1;
		
		System.out.println("Enter a date in the form mm/dd/yyyy:");
		date=kbd.nextLine();
		temp=date.indexOf("/");
		temp1=date.lastIndexOf("/");
		day=date.substring(temp+1,temp1);
		month=date.substring(0,temp);
		year=date.substring(temp1+1,date.length());
		System.out.println("\nYour date in European form is:");
		System.out.println(day+"."+month+"."+year);
		
		kbd.close();
	}
}