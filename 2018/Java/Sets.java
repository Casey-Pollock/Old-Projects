import java.util.*;

public class Sets 
{
	public static Scanner kbd;
	
	public static final int MAXSIZE=20;
	
	public static void main(String[] args) 
	{		
		kbd = new Scanner(System.in);
		int size1, size2, size3;
		String string;
		char character;
		boolean tf = false
		int [] array1 = new int[MAXSIZE];
		int [] array2 = new int[MAXSIZE];
		int [] array3 = new int[MAXSIZE];
		
		//Loop to perform the whole program so it can easily be repeated.
		do{
			
			//First set collection
			System.out.println("/nEnter the integers for the first set:");
			size1 = getData(array1);
			
			//Second set collection
			System.out.println("/nEnter the integers for the second set: ");
			size2 = getData(array2);
			
			//Sort both sets from lowest to highest
			sortArry(array1, size1);
			sortArry(array2, size2)
			
			//Display Numbers both sets have in common
			System.out.println("/nThe intersection of set A and set B: ");
			size3 = intersection(array1, size1, array2, size2, array3);
			printArray(array3, size3);
			
			//Display numbers in set A but not in set B
			System,out,println("/nThe difference: set A minus set B: ");
			size3 = difference(array1, size1, array2, size2, array3);
			printArray(array3, size3);
			
			//Display numbers in set B but not in set A
			System,out,println("/nThe difference: set B minus set A: ");
			size3 = difference(array2, size2, array1, size1, array3);
			printArray(array3, size3);
			
			//Potentially restart the program
			System.out.print("Do you want to calculate different sets (y or n)? ");
			string = kbd.nextLine();
			character = string.charAt(0);
			if(character=='n' || character=='N'){
				tf=false;
			}
		}
		while(tf==true);
		
		kbd.close();
	}
	
	/**
	 * Gets a set of unique integers from the keyboard
	 * Input stops when user enters MAXSIZE unique integers, or
	 * when a negative number is entered
	 * @param set The array into which the integers will be placed
	 * @return The number of integers placed into set
	 */
	public static int getData(int [] set)
	{
		int out=0, temp;
		boolean tf, tf1=true;
		
		/*Loops until the return value is equal to the mas set size
		*or until a negative number is provided
		*/
		do{
			
			if(out<MAXSIZE){
				temp = kbd.nextInt();
				tf=true;
				if(temp >= 0){
					
					//Searches for a duplicate.
					for(int count=0; count<out; count++){
						if(set[count]==temp){
							tf=false;
						}
					}
					
					//If there is no duplicate the integer is stored in the set
					if(tf==true){
						set[out]=temp;
						out++;
					}
				}
				else{
					tf1=false;
				}
			}
			else{
				tf1=false;
			}
		}
		while(tf1==true);
		
		//Clears keyboard buffer if more integers are entered than need to be
		kbd.nextLine();
		
		return out;
	}
	
	/**
	 * Computes the intersection of setA and setB
	 * This is the list of integers that both sets have in common
	 * @param setA A set of unique integers
	 * @param sizeA The number of integers in setA
	 * @param setB Another set of unique integers
	 * @param sizeB The number of integers in setB
	 * @param resultSet The array into which the result (intersection) will be placed
	 * @return The number of integers placed into resultSet
	 */
	public static int intersection(int [] setA, int sizeA, int [] setB, int sizeB, int [] resultSet)
	{
		
		int out=0;
		
		for(int count=0; count<sizeA; count++){
			for(int counter=0; counter<sizeB; counter++){
				if(setA[count]==setB[counter]){
					resultSet[out]=setA[count];
					out++;
				}
			}
		}
		
		return out;
	}
	
	/**
	 * Computes the difference of setA and setB
	 * This is the list of integers in setA which do not appear in setB
	 * @param setA A set of unique integers
	 * @param sizeA The number of integers in setA
	 * @param setB Another set of unique integers
	 * @param sizeB The number of integers in setB
	 * @param resultSet The array into which the result (difference) will be placed
	 * @return The number of integers placed into resultSet
	 */
	public static int difference(int [] setA, int sizeA, int [] setB, int sizeB, int [] resultSet)
	{
		
		int out=0;
		boolean tf=true;
		
		for(int count=0; count<sizeA; count++){
			for(int counter=0; counter<sizeB; counter++){
				if(setA[count]==setB[counter]){
					tf=false;
				}
			}
			
			if(tf==true){
				resultSet[out++]=setA[count];
			}
			else{
				tf=true;
			}
		}
		
		return out;
	}
	
	/**
	*Orders an array from smallest to largest
	*@param set A set of unique integers
	*@param size The number of integers in set
	*/
	public static void sortArry(int [] set, int size)
	{
		int temp;
		
		//Loops to go through an array and moves integers into a givin order
		for(int count=1; count<size; count++){
			for (int counter=count; counter>0; counter--){
				if(set[counter]<set[counter-1]){
					temp=set[counter];
					set[counter]=set[counter-1];
					set[counter-1]=temp;
				}
			}
		}
	}
	
	/**
	*Prints an array
	*Seperates the numbers in the array with a
	*comma and a space
	*the final number is printed alone
	*@param set A set of unique integers
	*@param size The number of integers in set
	*/
	public static void printArray(int [] set, int size)
	{
		
		for(int count=0; count<size; count++){
			
			//Last number is just printed to the screen
			if(count+1==size){
				System.out.println(set[count]);
			}
			
			//Prints a number with a comma and a space
			else{
				System.out.print(set[count]+", ");
			}
		}
	}
}

