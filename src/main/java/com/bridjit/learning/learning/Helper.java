package com.bridjit.learning.learning;

import java.util.Optional;

public class Helper {

	public static int toInteger(String s){
		return Optional.ofNullable(Integer.parseInt(s)).orElseThrow(IllegalArgumentException::new);
	}
	
}
