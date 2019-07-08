package com.bridjit.learning.learning;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Factoriel {
	public static final String NEGATIVE_NUMBER_MESSAGE = " Negative number exception in factorial,"
														+ " factorial is not defined in negative numbers"
														+ " \n please provide a 0 or positive number";

	public static int facto(int f) throws Exception {
		if(f < 0) throw new Exception(NEGATIVE_NUMBER_MESSAGE);
		if(f==0) return 1;
		IntBinaryOperator multiply = (a,b) -> a*b ;
		return IntStream.rangeClosed(1, f).reduce(1, multiply );
	}
}
