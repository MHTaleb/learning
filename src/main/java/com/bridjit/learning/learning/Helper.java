package com.bridjit.learning.learning;

import java.util.Optional;

public class Helper {

	public static int toInteger(String s){
		return Optional.ofNullable(s).filter((w)->w.matches("-?\\d+")).map(Integer::parseInt).orElseThrow(IllegalArgumentException::new);
	}
	
}
