/* @author Casey Pollock
 *         Assignment 3
 *         CSCI 2540
 *
 * This class will create an array of Students that can then be searched
 * through.  It will search for Students based on their fist an last name.
 * After the first search is completed the use will have the option to 
 * to search for another Student if the choose to do so.
*/


package assg4_pollockc18;
import java.io.*;
import java.util.*;

class StudentSearch {
	/* This method will take an array of Students. This method will 
	 * fill the array with Students from the file roster.txt and will 
	 * return the number of Students.  If the file is not found this
	 * method will return a FileNotFoundException.
	 *
	 * @return								the number of Students placed into roster.
	 * @exception FileNotFoundException		if the roster.txt file is not found
	*/
  public static int fillRoster(Student[] roster) throws FileNotFoundException{

    Scanner inputFile=new Scanner(new File("roster.txt"));
    int count=0, id; char gender; String last, first, dob, major;
    
    while(inputFile.hasNextLine()){
     
      id=inputFile.nextInt();
      last=inputFile.next();
      first=inputFile.next();
      gender=inputFile.next().charAt(0);
      dob=inputFile.next();
      major=inputFile.next();
      roster[count]=new Student(id, last, first, gender, dob, major);
    
      count++;

    }
    inputFile.close();
    return count;

  }
  /* This method will create an array of Students that can then be searched
   * through.  It will search for Students based on their fist an last name.
   * After the first search is completed the use will have the option to 
   * to search for another Student if the choose to do so.
   *
   * @exception FileNotFoundException		if the roster.txt file is not found.
   * @exception StudentNotFoundException	if the searched student's name is not found.
  */
  public static void main(String[] args) {

    Scanner kbd= new Scanner(System.in);
    int count, stdtlocation; String findFirst, findLast; boolean search=true; char questionResponse;
    Student[] roster = new Student[100];

    try{
    
      count=fillRoster(roster);

      while(search){
        
        System.out.println("\nPlease enter a person's first and last name.");
        findFirst=kbd.next();
        findLast=kbd.next();
        try{
          
          System.out.println(roster[Student.searchStudent(roster,count, findLast, findFirst)]);

        }
        catch(StudentNotFoundException e){

          System.out.println("Error: Student not Found");

        }
        System.out.println("\nWould you like to search fo another student? (Y/N)");
        questionResponse=kbd.next().charAt(0);
        if(questionResponse=='N'||questionResponse=='n'){

          search=false;

        }

      }

    }
    catch (FileNotFoundException e){

      System.out.println("Error: File Not Found");


    }

  }

}