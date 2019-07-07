package com.bridjit.learning.learning;

import java.util.Arrays;

/**
 * @author taleb
 * twin exercice
 * */
public class Twin {

	/**
	 * is twin check if all letters in two strings are the same ( not case sensitive, letters must be same count )
	 * */
	public static boolean isTwin(String word1, String word2) {

		if (word1 != null && word2 != null) {
			word1 = word1.replaceAll("\\s+", "").toLowerCase();
			word2 = word2.replaceAll("\\s+", "").toLowerCase();
			if (word1.length() == word2.length()) {
				char[] word1letters = word1.toCharArray();
				char[] word2letters = word2.toCharArray();
				Arrays.parallelSort(word1letters);
				Arrays.parallelSort(word2letters);
				return Arrays.equals(word1letters, word2letters);
			}
		}
		
		return false;
	}

}
