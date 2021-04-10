/* @author Casey Pollock
 * Assignment 1
 * CSCI 3000
 *
 * This class will create three threads that will find the average, 
 * maximum, and minimum vale in a set of integers. The list of numbers 
 * on entry must end with a letter.
*/

import java.util.*;

public class Question_5{

	static int avg;													//The average to some set of integers.
	static int maximum;												//The maximum to some set of integers.
	static int minimum;												//The minimum to some set of integers.
	
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();				//A list to hold all of the inputted integers.
		Scanner kbd = new Scanner(System.in);						
		int input;													
		System.out.println("Please enter a list of numbers, where the numbers "
						 + "are separated by a space.\nEnd by entering a letter.");
		while(kbd.hasNextInt()) {									//True if there are mor integers that need to be added to the list.
			
			input = kbd.nextInt();
			list.add(new Integer(input));							
			
		}
		Thread t1 = new Thread(new Runnable() {						//Thread that will find the average of the integers provided.
		
			public void run() {
			
				Iterator<Integer> iter = list.iterator();			//Iterator to go through the list sequentially.
				int count = 0, temp, total = 0 ;					//Count keeps the total number of numbers.
				while(iter.hasNext()) {								//Temp is just a temporary integer storage
																	//Total is the total for all added integers thus far.
					temp = (int) iter.next();
					total = temp + total;
					count++;
				
				}
				avg = total/count;									//Sets the glogal variable to the new average.
			
		}});
		
		Thread t2 = new Thread(new Runnable() {						//Thread that will find the maximum of the integers provided.
			
				public void run() {
				
				Iterator<Integer> iter = list.iterator();			//Iterator to go through the list sequentially.
				int temp, max;										//Temp is just a temporary integer storage
																	//max is the maximum of the integers thus far.
					max = (int) iter.next();						//Sets first value in the list as the max.
					while(iter.hasNext()) {	
					
						temp = (int) iter.next();					
						if(temp > max)
							max = temp;
					
					}
					maximum = max;									//Sets the glogal variable to the new maximum.
			
		}});
		
		Thread t3 = new Thread(new Runnable() {						//Thread that will find the maximum of the integers provided.
			
			public void run() {
				
				Iterator<Integer> iter = list.iterator();			//Iterator to go through the list sequentially.
				int temp, min;										//Temp is just a temporary integer storage
																	//min is the minimum of the integers thus far.
					min = (int) iter.next();						//Sets first value in the list as the min.
					while(iter.hasNext()) {						
					
						temp = (int) iter.next();
						if(temp < min)
							min = temp;
					
					}
					minimum = min;									//Sets the glogal variable to the new minimum.
				
		}});
		t1.start();
		t2.start();
		t3.start();	
		try {
			
			t1.join();
			t2.join();
			t3.join();												//All threads join to update the global variables.
			System.out.println("The average value is " + avg + 
							   "\nThe minimum value is " + minimum +
							   "\nThe maximum value is " + maximum);
		}
		catch(InterruptedException e){
			
			System.out.print("Error has occured:  values could not be found or printed.");
			
		}
		
		kbd.close();

	}

}