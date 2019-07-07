package com.bridjit.learning.learning;

public class SubArrayTools {

	public static final String NULL_ERROR_MESSAGE = "Empty Array please provide an instanciated array";
	public static final String STARING_BOUND_ERROR = "starting bound exception n1 should be greater than 0 and less then array lenght";
	public static final String ENDING_BOUND_ERROR = "ending bound exception n2 should be greater than 0 and less then array lenght";

	public static Object calc(int[] values, int n1, int n2) throws Exception {
		
		// checking for possible input exceptions
		if(values == null) throw new NullPointerException(NULL_ERROR_MESSAGE);
		
		if( n1<0 || n1 > values.length) throw new Exception(STARING_BOUND_ERROR);
		if( n2<0 || n2 > values.length) throw new Exception(ENDING_BOUND_ERROR);
		
		// assuming empty array is zero
		if(values.length == 0) return 0;
		
		// flipping bounds if possible when input is reversed
		if(n1 > n2) {
			n1 = n1 + n2 ;
			n2 = n1 - n2 ;
			n1 = n1 - n2 ;	
		}
		
		// classic sum using bounds
		int sum = 0 ;
		for (int i = n1; i <= n2; i++) {
			sum+=values[i];
		}
		
		return sum;
	}

}
