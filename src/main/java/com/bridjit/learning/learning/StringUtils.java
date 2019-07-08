package com.bridjit.learning.learning;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class StringUtils {

	public static final String NULL_PARAM_MESSAGE = "please provide an instanciated string array with at least one element";
	public static final String EMPTY_ARRAY_MESSAGE = "please provide an array with one or more elements";
	
	public static String concat(String[] values) throws Exception {
		if(values == null) throw new NullPointerException(NULL_PARAM_MESSAGE);
		if(values.length == 0) throw new Exception(EMPTY_ARRAY_MESSAGE);
		BinaryOperator<String> accumulator = (a,b) -> a+b;
		return Stream.of(values).reduce("", accumulator);
	}

}
