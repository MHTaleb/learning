package com.bridjit.learning.learning;

import org.junit.Assert;
import org.junit.Test;

public class FactorielTest{
	
		/**
		 * check that factoriel of a number is well calculated
		 * @throws Exception 
		 * */
		@Test
		public void checkFactoriel4() throws Exception {
			Assert.assertEquals(1*2*3*4, Factoriel.facto(4));
		}
		
		
		/**
		 * check that factoriel zero is 1
		 * @throws Exception 
		 * */
		@Test
		public void checkFactoriel0() throws Exception {
			Assert.assertEquals(1, Factoriel.facto(0));
		}
		
		/**
		 * check that negative numbers are rising an exception
		 * */
		@Test
		public void checkNegativeRisingException() {
			try {
				Factoriel.facto(-5);
			} catch (Exception e) {
				Assert.assertEquals(Factoriel.NEGATIVE_NUMBER_MESSAGE, e.getMessage());
			}
		}
}
