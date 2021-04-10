/* @author Casey Pollock
 *         Assignment 3
 *         CSCI 2540
 *
 * This class will be used to test the ComplexNum class.
 * This class will use JUnit 3 to test the ComplexNum
 * class.
*/


package assg5_Pollockc18_part2;

import junit.framework.TestCase;

public class TestComplexNum extends TestCase {
	
	private ComplexNum w, x, y, z;

	
	/*
	 * This method will be used to initiate ComplexNums
	 * w, x, and y.  These will be used in each test.
	 * 
	 * @override	setUp()
	*/
	protected void setUp() throws Exception {
		super.setUp();
		
		w=new ComplexNum();
		x=new ComplexNum(2.5);
		y=new ComplexNum(6,-2.3);
	
	}
	/* This method will be used to test the constructor of 
	 * ComplexNums with no parameters.
	*/
	public void testDefaultConstructor() {
		
		assertEquals("Real Number:", 0.0, w.getReal());
		assertEquals("Imaginary Number:", 0.0, w.getImaginary());
		
	}
	/* This method will be used to test the constructor of 
	 * ComplexNums with one parameter.
	*/
	public void testOneParameterConstructor() {
		
		assertEquals("Real Number:", 2.5, x.getReal());
		assertEquals("Imaginary Number:", 0.0, x.getImaginary());
		
	}
	/* This method will be used to test the constructor of 
	 * ComplexNums with two parameters.
	*/
	public void testTwoParameterConstructor() {
		
		assertEquals("Real Number:", 6.0, y.getReal());
		assertEquals("Imaginary Number:", -2.3, y.getImaginary());
		
	}
	/* This method will be used to test the toString method 
	 * of the ComplexNum class.
	*/
	public void testToString() {
		
		z=new ComplexNum(0,5.4);
		assertEquals("Complex Number:", "5.4i", z.toString());
		z.setReal(15.1);
		assertEquals("Complex Number:", "15.1+5.4i", z.toString());
		assertEquals("Complex Number:", "0.0", w.toString());
		assertEquals("Complex Number:", "2.5", x.toString());
		x.setReal(-2.5);
		assertEquals("Complex Number:", "-2.5", x.toString());
		assertEquals("Complex Number:", "6.0-2.3i", y.toString());
		
		
	}
	/* This method will be used to test the setReal method 
	 * of the ComplexNum class.
	*/
	public void testSetReal() {
		
		y.setReal(29.3);
		assertEquals("Real Number", 29.3, y.getReal());
		
	}
	/* This method will be used to test the setImaginary method 
	 * of the ComplexNum class.
	*/
	public void testSetImaginary() {
		
		y.setImaginary(-6.9);
		assertEquals("Imaginary Number:", -6.9, y.getImaginary());
		
	}
	/* This method will be used to test the equal method 
	 * of the ComplexNum class.
	*/
	public void testEquals() {
		
		assertFalse("Complex Numbers:", w.equals(x));
		x.setReal(6);
		x.setImaginary(-2.3);
		assertTrue("Complex Number:", x.equals(y));
		
	}
	/* This method will be used to test the add method 
	 * of the ComplexNum class.
	*/
	public void testAdd() {
		
		z=x.add(y);
		assertEquals("Complex Number:", "8.5-2.3i", z.toString());
		
	}
	/* This method will be used to test the sub method 
	 * of the ComplexNum class.
	*/
	public void testSub() {
		
		z=y.sub(x);
		assertEquals("Complex Number:", "3.5-2.3i", z.toString());
		
	}
	/* This method will be used to test the mul method 
	 * of the ComplexNum class.
	*/
	public void testMul() {
		
		z=w.mul(y);
		assertEquals("Complex Number:", "0.0", z.toString());
		x.setImaginary(4);
		z=x.mul(y);
		assertEquals("Complex Number:", "24.2+18.25i", z.toString());
		
	}
	/* This method will be used to test the neg method 
	 * of the ComplexNum class.
	*/
	public void testNeg() {
		
		z=y.neg();
		assertEquals("Complex Number:", "-6.0+2.3i", z.toString());
		z=x.neg();
		assertEquals("Complex Number:", "-2.5", z.toString());
		z=w.neg();
		assertEquals("Complex Number:", "0.0", z.toString());
		
	}

}
