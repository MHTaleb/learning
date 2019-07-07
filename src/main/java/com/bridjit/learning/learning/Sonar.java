package com.bridjit.learning.learning;
/**
 * closest to zero exercice
 * @author taleb
 * */
public class Sonar {

	public static int closestToZero(int[] numbers) {

		if(numbers == null) {
			return 0;
		}
		if(numbers.length == 0) {
			return 0;
		}
		
		int closestNegative= Integer.MIN_VALUE,
			closestPositive = Integer.MAX_VALUE;	
		for (int i : numbers) {
			if(i >= 0 ) {
				closestPositive = (closestPositive > i) ? i : closestPositive ;
			}else {
				closestNegative = (closestNegative < i) ? i : closestNegative ;
			}
		}
		
		if(closestPositive + closestNegative <= 0 )return closestPositive;
		
		return closestNegative;
	}

}
