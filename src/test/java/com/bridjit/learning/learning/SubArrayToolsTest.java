package com.bridjit.learning.learning;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SubArrayToolsTest extends TestCase{
	public SubArrayToolsTest(String testName) {
		super(testName);
	}
	
	public static Test suite() {
		return new TestSuite(SubArrayToolsTest.class);
	}
	
	/**
	 * empty array
	 * */
	public void testEmptyArray(){
		int[] values = new int[]{};
		int n1 = 0, n2 = 0;
		try {
			assertEquals(0, SubArrayTools.calc(values,n1,n2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * error  in limits negative limit range
	 * */
	public void testLimitErrorInBegining() {
		int[] values = new int[]{1,2,3,4};
		int n1 = -4, n2 = 0;
		try {
			SubArrayTools.calc(values,n1,n2);
		} catch (Exception e) {
			assertEquals(SubArrayTools.STARING_BOUND_ERROR, e.getMessage());
		}
	}
	
	/**
	 * error in limit array out of bound exception
	 * */
	public void testLimitErrorInEnding() {
		int[] values = new int[]{1,2,3,4};
		int n1 = 2, n2 = 8;
		try {
			SubArrayTools.calc(values,n1,n2);
		} catch (Exception e) {
			assertEquals(SubArrayTools.ENDING_BOUND_ERROR, e.getMessage());
		}
	}
	
	/**
	 * the sum is good case 1 fliping doesnt matter
	 * */
	public void testFlippingBoundsDoesntMatter() {
		int[] values = new int[]{1,2,3,4};
		int n1 = 0, n2 = 2;
		try {
			assertEquals(SubArrayTools.calc(values, n1, n2), SubArrayTools.calc(values, n2, n1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * the sum is good case 2
	 * */
	public void testSumIsCorrect() {
		int[] values = new int[]{1,2,3,4,5,6,7,8,9};
		int n1 = 2, n2 = 6 , sum = 3+4+5+6+7;
		try {
			assertEquals(SubArrayTools.calc(values, n1, n2), sum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
