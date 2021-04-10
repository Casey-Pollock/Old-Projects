//Does not print arrays 


//Casey Pollock
import java.util.*;

public class CharCount {
	
	public static Scanner kbd;
	
	//Printing the results
	public static void printResults(int [] arrayn, char [] arraya){
		
		System.out.println("/nLetter frequencies:");
		for(int counter=0; counter<26; counter++){
			if(arrayn[counter] != 0){
				System.out.println(arraya[counter]+ " - " + arrayn[counter]);
			}
		}
	}
	
	//Creates an array that store the numbers for the characters
	public static int[] countLetters(String str){
		int [] arrayn = new int[27];int length; char charhold;
		
		str=str.toLowerCase();
		length=str.length();
		
		//Loop to obtain the characters from the string and add them into the final array.
		for(int counter=0; counter<length; counter++){
		    charhold=str.charAt(counter);
			arrayn[pos(charhold)]=arrayn[pos(charhold)]++;
		}
		
		return arrayn;
	}
	
	//converts the letters and symbols to numbers
	public static int pos(char charhold){
		
		switch(charhold){
			case 'a':
				return 0;
			case 'b':
				return 1;
			case 'c':
				return 2;
			case 'd':
				return 3;
			case 'e':
				return 4;
			case 'f':
				return 5;
			case 'g':
				return 6;
			case 'h':
				return 7;
			case 'i':
				return 8;
			case 'j':
				return 9;
			case 'k':
				return 10;
			case 'l':
				return 11;
			case 'm':
				return 12;
			case 'n':
				return 13;
			case 'o':
				return 14;
			case 'p':
				return 15;
			case 'q':
				return 16;
			case 'r':
				return 17;
			case 's':
				return 18;
			case 't':
				return 19;
			case 'u':
				return 20;
			case 'v':
				return 21;
			case 'w':
				return 22;
			case 'x':
				return 23;
			case 'y':
				return 24;
			case 'z':
				return 25;
			default:
				return 26;
		}
	}

	public static void main(String[] args) {
		
		kbd = new Scanner(System.in);
		String string; int [] arrayn; char [] arraya = new char[26];
		
		//Get a string
		System.out.println("Enter a line of text:");
		string=kbd.nextLine();
		
		//Arrays prepared for printing the results
		arrayn=countLetters(string);
		arraya[0]='a';
		arraya[1]='b';
		arraya[2]='c';
		arraya[3]='d';
		arraya[4]='e';
		arraya[5]='f';
		arraya[6]='g';
		arraya[7]='h';
		arraya[8]='i';
		arraya[9]='j';
		arraya[10]='k';
		arraya[11]='l';
		arraya[12]='m';
		arraya[13]='n';
		arraya[14]='o';
		arraya[15]='p';
		arraya[16]='q';
		arraya[17]='r';
		arraya[18]='s';
		arraya[19]='t';
		arraya[20]='u';
		arraya[21]='v';
		arraya[22]='w';
		arraya[23]='x';
		arraya[24]='y';
		arraya[25]='z';
		
		//print the results
		printResults(arrayn, arraya);
		
		kbd.close();
	}
}