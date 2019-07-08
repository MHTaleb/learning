package com.bridjit.learning.learning;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

	/**
	 * concat an empty table results in an exception rised
	 * */
	@Test
	public void concatEmptyString() {
		try {
			StringUtils.concat(new String[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertEquals(StringUtils.EMPTY_ARRAY_MESSAGE, e.getMessage());
		}
	}
	
	/**
	 * concat a null table results in an exception rised
	 * */
	@Test
	public void concatNullString() {
		try {
			StringUtils.concat(null);
		} catch (Exception e) {
			Assert.assertEquals(StringUtils.NULL_PARAM_MESSAGE, e.getMessage());
		}
	}
	
	/**
	 * concat challenge 
	 * @throws Exception 
	 * */
	@Test
	public void concatString() throws Exception {
		Assert.assertEquals("abc deffoobar armin eren", StringUtils.concat(new String[] {"abc",""," ","def","foobar ","armin eren"}));
	}
}
