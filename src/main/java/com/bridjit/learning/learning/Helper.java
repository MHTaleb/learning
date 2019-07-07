package com.bridjit.learning.learning;

import java.util.Optional;

public class Helper {

	public static Optional<Integer> toInteger(String s){
		try {
			return Optional.ofNullable(Integer.parseInt(s));
		}catch(NumberFormatException ex) {
			return Optional.empty();
		}
		
	}
	
}
