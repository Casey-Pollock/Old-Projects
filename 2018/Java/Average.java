//Casey Pollock

import java.util.*;

public class Average {

	public static Scanner kbd;
	
	public static final int MAXSIZE=10;
	
	public static void main(String[] args) {
		
		kbd = new Scanner(System.in);
		int count, counter=0, sum=0; double avg;
		
		//number collection
		int array[]= new int[MAXSIZE];
		System.out.println("Enter " + MAXSIZE + " integers:");
		
		//number distribution and sum calculator
		for(count=MAXSIZE-1; count>=0; count--){
			array[count]=kbd.nextInt();
			sum=sum+array[count];
		}
	
	    //Average calculation
		avg=new Double(sum);
		avg=avg/MAXSIZE;
		System.out.printf("The average of your numbers is: %.1f\n", avg);
		
		//Find numbers higher than the average
		int highArray[]=new int[MAXSIZE-1];
		sum=sum/MAXSIZE;
		for(count=0;count<MAXSIZE;count++){
			if(array[count]>sum){
				highArray[counter]=array[count];
				counter=counter+1;
			}
		}
		
		//display results
		System.out.println("There are "+counter+" numbers above the average.\n");
		System.out.println("Those numbers are: ");
		for(count=0;count<counter;count++){
			System.out.println(highArray[count]);
		}
		
		kbd.close();
	}
}
