package com.bridjit.learning.learning.oca.chap2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Tale21 {
	public static void main(String args[]) {
		int baseDecimal = 267;
		int octVal = 0413;
		int hexVal = 0x10B;
		int binVal = 0b100001011;
		System.out.println(baseDecimal + octVal);
		System.out.println(hexVal + binVal);

		int v1 = 012;
		int v2 = 12;
		int v3 = 0_12;

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		long var1 = 0_100_267_760;

		double d = 4351321e2;

		System.out.println((int) d);

		char c1 = 122;
		char c2 = '\u0122';
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		// fails char c3 = -122;
		char c3 = (char) -122;
		System.out.println("c3 = " + c3);

		List<List<Map<String, Object>>> myList = new ArrayList<>();

		List<Map<String, Object>> e1 = new ArrayList<>();
		e1.add(new HashMap<String, Object>() {
			{
				put("test", 1);
			}
		});
		e1.add(new HashMap<String, Object>() {
			{
				put("test", 6);
			}
		});

		List<Map<String, Object>> e2 = new ArrayList<>();
		e2.add(new HashMap<String, Object>() {
			{
				put("test", 9);
			}
		});
		e2.add(new HashMap<String, Object>() {
			{
				put("test", 2);
			}
		});

		myList.add(e1);
		myList.add(e2);

		BinaryOperator<Object> accumulator = (a, b) -> Double.parseDouble("" + a) + Double.parseDouble("" + b);

		List sums = myList.stream().map((e) -> e.stream()
				.map((content) -> content.values().stream().reduce(0, accumulator)).reduce(0, accumulator))
				.collect(Collectors.toList());
		System.out.println("sums \n" + sums);
	}
}
