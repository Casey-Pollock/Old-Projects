/* @author Casey Pollock
 *         Assignment 2
 *         CSCI 2540
*/

package assg2_Pollockc;

public class ComplexNum{
	
	private double real;
	private double imaginary;
	
	/* This method creates a new object that consist of two 
	 * double numbers.  both numbers will be given.  This 
	 * object will corispond to a complexnumber.
	 *
	 * @param real       the real number half of a complex number.
	 * @param imaginary  the imaginary half of a complex number.
	*/
	public ComplexNum(double real, double imaginary){
		
		this.real=real;
		this.imaginary=imaginary;
		
	}
	/* This method creates a new object that consist of two 
	 * double numbers.  One that is given and the other will
	 * be 0.  This object will corispond to a complex number.
	 *
	 * @param real  the real number half of a complex number.
	*/
	public ComplexNum(double real){
		
		this.real=real;
		this.imaginary=0;
		
	}
	/* This method creates a new object that consist of two 
	 * double numbers.  Both numbers will be set to 0.
	 * This object will corispond to a complex number.
	*/
	public ComplexNum(){
		
		this.real=0;
		this.imaginary=0;
		
	}
	/* This method will return a double that will be retrieved
	 * from a complex number.  This double will corrispond to 
	 * the real half of the number.
	 *
	 * @return  the real number from a complex number.
	 * @see     ComplexNum
	*/
	public double getReal(){
		
		return this.real;
		
	}
	/* This method will return a double that will be retrieved
	 * from a complex number.  This double will corrispond to 
	 * the imaginary half of the number.
	 *
	 * @return  the imaginary number from a complex number.
	 * @see     ComplexNum
	*/
	public double getImaginary(){
		
		return this.imaginary;
		
	}
	/* This method will take a double that will become a part
	 * of a complex number.  This double will corrispond to 
	 * the real half of the number.
	 *
	 * @param real  this will become the new real number in 
	 *              an complex number.
	 * @see         ComplexNum
	*/
	public void setReal(double real){
		
		this.real=real;
		
	}
	/* This method will take a double that will become a part
	 * of a complex number.  This double will corrispond to 
	 * the imaginary half of the number.
	 *
	 * 
	 * @param imaginary  this will become the new imaginary 
	 *                   number in an complex number.
	 * @see              ComplexNum
	*/
	public void setImaginary(double imaginary){
		
		this.imaginary=imaginary;
		
	}
	/* This method will take a ComplexNum that will be added
	 * to another complex number.  This method will return the
	 * sum of those two complex numbers as a ComplexNum.
	 *
	 * @param temp  a complex number that will be added to 
	 *              another complex number.
	 * @return      the sum of two complex numbers as a ComplexNum
	 * @see         ComplexNum
	*/
	public ComplexNum add(ComplexNum temp){
		
		return new ComplexNum((this.real+temp.real),(this.imaginary+temp.imaginary));
		
	}
	/* This method will take a ComplexNum that will be subtrated
	 * with another complex number.  This method will return the
	 * difference of those two complex numbers as a ComplexNum.
	 *
	 * @param temp  a complex number that will be subtracted from 
	 *              another complex number.
	 * @return      the difference of two complex numbers as a 
	 *              ComplexNum.
	 * @see         ComplexNum
	*/
	public ComplexNum sub(ComplexNum temp){
		
		return new ComplexNum((((this.real*10.0)-(temp.real*10.0))/10.0),((((this.imaginary*10.0)-(temp.imaginary*10.0))/10.0)));
		
	}
	/* This method will take a ComplexNum that will be multiplyed
	 * by another complex number.  This method will return the
	 * sum of those two complex numbers as a ComplexNum.
	 *
	 * @param temp  a complex number that will be multiplyed by 
	 *              another complex number.
	 * @return      the sum of two complex numbers as a ComplexNum
	 * @see         ComplexNum
	*/
	public ComplexNum mul(ComplexNum temp){
		
		return new ComplexNum(((this.real*temp.real)-(this.imaginary*temp.imaginary)),((this.imaginary*temp.real)+(this.real*temp.imaginary)));
		
	}
	/* This method will return the negation of a complex number
	 * as a ComplexNum
	 *
	 * @return      the negation of a complex number as a ComplexNum
	 * @see         ComplexNum
	*/
	public ComplexNum neg(){
		
		return new ComplexNum((-1*this.real),(-1*this.imaginary));
		
	}
	/* This method will return the String of a complex
	 * number.  This method will place the correct operator
	 * next to each hald of the number and an i behind the 
	 * imaginary half of the number.  If one of the halves is
	 * 0 then that half will be an empty String. If both 
	 * halves are 0 then a String with just 0 is returned.
	 *
	 * @return      the String of a ComplexNum.
	 * @override    toString
	 * @see         ComplexNum
	*/
	public String toString(){
		
		String real, imaginary;
		real=this.realPrint();
		imaginary=this.imaginaryPrint();
		
		if(real.equals("") && imaginary.equals("")){
		
			return "0";
		
		}
		else{
			
			return(real + imaginary);
			
		}
	}
	/* This method will return the String of a complex
	 * number.  This method will place the correct operator
	 * next to each hald of the number and an i behind the 
	 * imaginary half of the number.  If one of the half is
	 * 0 then an empty String will be returned.
	 *
	 * @return      a String of the real half of a ComplexNum,
	 * @see         ComplexNum
	 * @see         toString
	*/
	public String realPrint(){
		
		if(this.real==0){
			
			return "";
			
		}
		else{
			
			return (""+this.real);			
		}
	}
	/* This method will return the String of a complex
	 * number.  This method will place the correct operator
	 * next to each hald of the number and an i behind the 
	 * imaginary half of the number.  If one of the half is
	 * 0 then an empty String will be returned.
	 *
	 * @return      a String of the real half of a ComplexNum,
	 * @see         ComplexNum
	 * @see         toString
	*/
	public String imaginaryPrint(){
		
		if(this.imaginary==0){
			
			return "";
			
		}
		else if(this.imaginary<0){
			
			return (""+this.imaginary+"i");
				
		}
		else{
			
			return ("+"+this.imaginary+"i");			
		}
	}
	/* This method will take an Object and test to see if it is
	 * equal to a certain complex number.  This method will return 
	 * a boolean of true if both sets of real halves and imaginary
	 * halves are the same, otherwise false is returned.
	 *
	 * @param obj  an object that may or may not be a ComplexNum.
	 * @return     true is returned if both complex numbers are 
	 *             the same.
	 * @override   equals().
	 * @see        ComplexNum
	*/
	public boolean equals(Object obj){
		
		if(obj==null){
			
			return false;
			
		}
		else if(obj instanceof ComplexNum){
			
			ComplexNum temp=(ComplexNum)obj;
			return ((this.real==temp.real) && (this.imaginary==temp.imaginary));
			
		}
		else{
			
			return false;
			
		}
	}
}