package com.bridjit.learning.learning;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SonarTest extends TestCase{
	
	public SonarTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(SonarTest.class);
	}
	
	/**
	 * return zero if null or empty
	 * */
	public void testEmptyOrNull() {
		int[] numbers = new  int[] {};
		assertEquals(0, Sonar.closestToZero(numbers));
		assertEquals(0, Sonar.closestToZero(null));
	}
	
	/**
	 * return closest negative number
	 * */
	public void testClosestNegativeWinner() {
		int[] numbers = new  int[] {-9,-8,-7,-6,-5,-4,5,6,7,8,9};
		assertEquals(-4, Sonar.closestToZero(numbers));
	}
	
	public void testClosestNegativeWinner2() {
		int[] numbers = new  int[] {-9,-8,-7,-6,-5,-4};
		assertEquals(-4, Sonar.closestToZero(numbers));
	}
	/**
	 * return closest positive number
	 * */
	public void testClosestPositiveWinner() {
		int[] numbers = new  int[] {-9,-8,-7,-6,5,6,7,8,9};
		assertEquals(5, Sonar.closestToZero(numbers));
	}
	
	public void testClosestPositiveWinner2() {
		int[] numbers = new  int[] {5,6,7,8,9};
		assertEquals(5, Sonar.closestToZero(numbers));
	}
	
	/**
	 * return positove over negative number as answer
	 * */
	public void testpositiveWinOverNegative() {
		int[] numbers = new  int[] {-9,-8,-7,-6,-5,5,6,7,8,9};
		assertEquals(5, Sonar.closestToZero(numbers));
	}
	
}
