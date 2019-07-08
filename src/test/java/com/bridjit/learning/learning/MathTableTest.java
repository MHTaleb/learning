package com.bridjit.learning.learning;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class MathTableTest {

	/**
	 * check if an empty table return 0
	 * */
	@Test
	public void checkEmptyTableReturnZero() {
		Assert.assertEquals(0, MathTable.average(new double[] {}),0);
	}
	
	/**
	 * check that null table rise exception message
	 * */
	@Test
	public void checkNullTableException() {
		try {
			MathTable.average(null);
		}catch(NullPointerException e) {
			Assert.assertEquals(MathTable.NULL_TABLE_PARAM, e.getMessage());
		}
	}
	
	/**
	 * check Average well calculated (negative numbers are okey since the average is the sum/cardinality )
	 * */
	@Test
	public void checkAverage() {
		Assert.assertEquals((1.0+2+3+4+5+6+7)/7.0, MathTable.average(new double[] {1,2,3,4,5,6,7}),0);
	}
	
	@Test
	public void checkAverage2() {
		Assert.assertEquals(
				IntStream.rangeClosed(-5, 120).average().getAsDouble(), 
				MathTable.average(
						IntStream.rangeClosed(-5, 120).asDoubleStream().toArray()
						),
				0);
	}
}
