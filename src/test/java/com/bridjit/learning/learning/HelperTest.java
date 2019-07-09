package com.bridjit.learning.learning;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class HelperTest extends TestCase{

	public HelperTest() {
		super("using optional in methods");
	}
	
	public static Test suite() {
		return new TestSuite(HelperTest.class);
	}

	/**
	 * parsing non numeric string rise illegal argument exception
	 * */
	public void testParsingArgumentException() {
		try {
			Helper.toInteger("a");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * parsing null string rise illegal argument exception
	 * */
	public void testParsingNullArgumentException() {
		try {
			Helper.toInteger(null);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	

	/**
	 * optional should be present 
	 * */
	public void testParsingPresent() {
		assertTrue(Helper.toInteger("2") == 2);
	}
	
	/**
	 * optional should be present 
	 * */
	public void testParsingNegativeNumber() {
		assertTrue(Helper.toInteger("-2") == -2);
	}
}
