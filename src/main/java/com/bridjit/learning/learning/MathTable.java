package com.bridjit.learning.learning;

import java.util.stream.DoubleStream;

public class MathTable {

	public static final String NULL_TABLE_PARAM = "please instanciate an empty or a full table of element, null table provided error";
	
	public static double average(double[] values) {
		if(values == null) throw new NullPointerException(NULL_TABLE_PARAM);
		if(values.length == 0) return 0;
		return DoubleStream.of(values).average().getAsDouble();
	}
	
}
