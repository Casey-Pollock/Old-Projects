/* @author Casey Pollock
 *         Assignment 3
 *         CSCI 2540
 *
 * This class will be used to create and use a Student object.
 * Student will be used to store a students id number, their 
 * last name, their first name, their gender, their date of 
 * birth, and thier major.  This class can also search through 
 * an array of Students for a specific student.
*/

package assg4_pollockc18;

public class Student{

  private int id;
  private String nameLast;
  private String nameFirst;
  private char gender;
  private String dob;
  private String major;

    /* This method creates a new object that consist of a 
	 * integer number, four Strings and a character.  This 
	 * object will corispond to a Student.
	*/
  public Student(){

    this.id=0;
    this.nameLast="";
    this.nameFirst="";
    this.gender='0';
    this.dob="";
    this.major="";

  }
    /* This method creates a new object that consist of a 
	 * integer number, four Strings and a character.  This 
	 * object will corispond to a Student.
	 *
	 * @param idNo     	    the id of a Student.
	 * @param last  		the last name of a Student.
	 * @param first    	    the first name of a Student.
	 * @param gen  			the gender of a Student.
	 * @param birthDate		the date of birth of a Student.
	 * @param major  		the major of a Student.
	*/
  public Student(int idNo, String last, String first, char gen, String birthDate, String major){

    this.id=idNo;
    this.nameLast=last;
    this.nameFirst=first;
    this.gender=gen;
    this.dob=birthDate;
    this.major=major;

  }
	/* This method will return an integer that will be retrieved
	* from a Student.  This integer will corrispond to 
	* the Id number of a student.
	*
	* @return  the Id number of a Student.
	* @see     Student
	*/
  public int getId(){

    return this.id;

  }
  /* This method will return a String that will be retrieved
	* from a Student.  This String will corrispond to 
	* the last name of a student.
	*
	* @return  the last name of a Student.
	* @see     Student
	*/
  public String getLast(){

    return this.nameLast;

  }
  /* This method will return a String that will be retrieved
	* from a Student.  This String will corrispond to 
	* the first name of a student.
	*
	* @return  the first name of a Student.
	* @see     Student
	*/
  public String getFirst(){

    return this.nameFirst;

  }
	/* This method will return a character that will be retrieved
	* from a Student.  This character will corrispond to 
	* the gender of a student.
	*
	* @return  the gender of a Student.
	* @see     Student
	*/
  public char getGender(){

    return this.gender;

  }
  /* This method will return a String that will be retrieved
	* from a Student.  This String will corrispond to 
	* the date of birth of a student.
	*
	* @return  the date of birth of a Student.
	* @see     Student
	*/
  public String getDOB(){

    return this.dob;

  }
  /* This method will return a String that will be retrieved
	* from a Student.  This String will corrispond to 
	* the major of a student.
	*
	* @return  the major of a Student.
	* @see     Student
	*/
  public String getMajor(){

    return this.major;

  }
    /* This method will take an array of Students, an integer of the
	 * number of Students, and two Strings.  The two Strings will corrispond
	 * to the first and last name of a student.  This method will search
	 * the array for a Student that has a matching first and last name
	 * and return the location of that student.  If there is no student 
	 * with the given names, this method will return a StudentNotFoundException.
	 *
	 * @return									the integer location of the found Student.
	 * @param roster        					an array of Students.
	 * @param rosterNo							the number of Students in roster.
	 * @param last         						the last name of a Student.
	 * @param first   							the first name of a Student
	 * @exception StudentNotFoundException		if the student's name could not be found
	 * @see                 					StudentAccount
	*/
  public static int searchStudent(Student[] roster, int rosterNo, String last, String first)throws StudentNotFoundException{

    for(int count=0; count<rosterNo;count++){

      if(roster[count].getLast().equals(last) && roster[count].getFirst().equals(first)){

        return count;

      }

    }
    throw new StudentNotFoundException();

  }
    /* This method will return the String of a Student.  
	 * All information about a student will be returned 
	 * with an identifier for each part.
	 *
	 * @return      a String of a Student
	 * @see         Student
	 * @overide     toString
	*/
  public String toString(){

    return ("Student ID: "+this.getId()+" Last Name: "+this.getLast()+" First Name: "+this.getFirst()+" Gender: "+this.getGender()+" Date of Birth: "+this.getDOB()+" Major: "+this.getMajor());

  }

}