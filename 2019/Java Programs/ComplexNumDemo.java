/* @author Casey Pollock
 *         Assignment 2
 *         CSCI 2540
*/

package assg2_Pollockc;

import ComplexNumber.ComplexNum;

public class ComplexNumDemo{
	
	public static void main(String[] args){
		
		ComplexNum c1, c2, c3;

		System.out.println("Hi! This is a demo to test the ComplexNum class.");
		System.out.println("First a test for the constructors and the ability to print a complex number.");
		System.out.println("The first number that should be printied is 0");
		c1=new ComplexNum();
		System.out.println("The first complex number has been generated and it reads " + c1 + ".");
		System.out.println("The second number that should be printied is 3.5");
		c2=new ComplexNum(3.5);
		System.out.println("The second complex number has been generated and it reads " + c2 + ".");
		System.out.println("The third number that should be printied is 5.6-4.3i");
		c3=new ComplexNum(5.6,(-4.3));
		System.out.println("The third complex number has been generated and it reads " + c3 + ".");
		System.out.println("\n\nThe next test is for the set functions and the addition functions.");
		c1.setReal(3.5); c1.setImaginary(4.3);
		c2.setReal(5.6); c2.setImaginary(7.3);
		System.out.println("The two complex numbers that will be added are "+ c1 + " and "+ c2 +".");
		c3=c1.add(c2);
		System.out.println("The answer should be 9.1+11.6i and the answer is " + c3+".");
		c1.setReal(-3.5); c1.setImaginary(4.3);
		c2.setReal(-5.6); c2.setImaginary(7.3);
		System.out.println("The two complex numbers that will be added are "+ c1 + " and "+ c2 +".");
		c3=c1.add(c2);
		System.out.println("The answer should be -9.1+11.6i and the answer is " + c3+".");		
		System.out.println("\n\nThe next test is for the subtraction function.");
		c1.setReal(13.7); c1.setImaginary(10.6);
		c2.setReal(5.8); c2.setImaginary(3.5);
		System.out.println("The two complex numbers that will be subtracted are "+ c1 + " and "+ c2 +".");
		c3=c1.sub(c2);
		System.out.println("The answer should be 7.9+7.1i and the answer is " + c3+".");
		System.out.println("\n\nThe next test is for the multiplication function.");
		c1.setReal(5.6); c1.setImaginary(3.5);
		c2.setReal(9.8); c2.setImaginary(10.6);
		System.out.println("The two complex numbers that will be multiplied are "+ c1 + " and "+ c2 +".");
		c3=c2.mul(c1);
		System.out.println("The answer should be 17.78+93.66i and the answer is " + c3+".");
		System.out.println("\n\nThe next test is for the negation function.");
		c1.setReal(5.6); c1.setImaginary(3.5);
		System.out.println("The complex number that will be negated is "+ c1 + ".");
		c3=c1.neg();
		System.out.println("The answer should be -5.6-3.5i and the answer is " + c3+".");
		c1.setReal(-5.6); c1.setImaginary(-3.5);
		System.out.println("The complex number that will be negated is "+ c1 + ".");
		c3=c1.neg();
		System.out.println("The answer should be 5.6+3.5i and the answer is " + c3+".");
		c1.setReal(5.6); c1.setImaginary(-3.5);
		System.out.println("The complex number that will be negated is "+ c1 + ".");
		c3=c1.neg();
		System.out.println("The answer should be -5.6+3.5i and the answer is " + c3+".");
		System.out.println("\n\nThe next test is for the equivalence function.");
		c1.setReal(5.6); c1.setImaginary(3.5);
		c2.setReal(9.8); c2.setImaginary(10.6);
		System.out.println("Are "+ c1 + " and "+ c2 +" equal?");
		c2.equals(c1);
		System.out.println("The answer should be false and the answer is " + c2.equals(c1) +".");
		System.out.println("\n\nThe next test is for the equivalence function.");
		c1.setReal(5.6); c1.setImaginary(3.5);
		c2.setReal(5.6); c2.setImaginary(3.5);
		System.out.println("Are "+ c1 + " and "+ c2 +" equal?");
		c2.equals(c1);
		System.out.println("The answer should be true and the answer is " + c2.equals(c1) +".");
	}
	
}