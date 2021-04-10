// CSCI 2540
// Assignment: 1
// Author:     Casey Pollock
// File:       Average

// Takes some given amount of grades, prints the average of all grades given, and prints the grades above the average.

import java.util.*;

public class Average{
	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		int numOfGrade, counter=0, count=0; double average=0;
		System.out.println("Please enter the number of grades: ");
		numOfGrade=kbd.nextInt();
		if(numOfGrade>0){
			int array[]= new int[numOfGrade];
			while(counter<numOfGrade){
			
				System.out.println("Enter a grade: ");
				array[counter]=kbd.nextInt();
				counter++;
			
			}
			counter=0;
			while(counter<numOfGrade){
			
				average=average+array[counter];
				counter++;
			
			}
			average=average/numOfGrade;
			counter=0;
			System.out.printf("The average grade is: %.2f\n\nThe grades above the average grade are: \n", average);
			while(counter<numOfGrade){
			
				if(array[counter]>average){
				
					System.out.println(array[counter]);
					count++;
				
				}
				counter++;
			
			}
			System.out.println("for a total of "+count+" grades.");
		} else
		System.out.println("Please enter a number greater than 0.");
		
		kbd.close();
	}
}