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
	 * optional should be empty unparçable string 
	 * */
	public void testParsingEmpty() {
		assertFalse(Helper.toInteger("a").isPresent());
	}
	

	/**
	 * optional should be present 
	 * */
	public void testParsingPresent() {
		assertTrue(Helper.toInteger("2").isPresent());
	}
}
