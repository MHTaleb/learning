package com.bridjit.learning.learning;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TwinTest extends TestCase {
	public TwinTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(TwinTest.class);
	}

	/**
	 * check twin is true for abc bca
	 */
	public void testABCandBCA() {
		assertTrue(Twin.isTwin("abc", "bca"));
	}

	/**
	 * check twin is false for null bca
	 */
	public void testNullandBCA() {
		assertFalse(Twin.isTwin(null, "bca"));
	}

	/**
	 * check twin is true for aBc bca
	 */
	public void testCaseSensitive() {
		assertTrue(Twin.isTwin("abC", "bca"));
	}

	/**
	 * check twin is true for "abc " "bca"
	 */
	public void testTrim() {
		assertTrue(Twin.isTwin("abc  ", "bca"));
	}

	/**
	 * check twin is true for "a bc" "bca"
	 */
	public void testSpace() {
		assertTrue(Twin.isTwin("a  bc", "bca"));
	}
}
