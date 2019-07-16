package com.bridjit.learning.learning.oca.chap2;

import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

public class ArethmiticOperators {
	public static Map<String, Frame> framePool = new Hashtable<String, Frame>();
	
	public static void main(String[] args) {
		
		// using casting
		byte age1 = 10;
		byte age2 = 20;
		short sum = (short) (age1 + age2);
		
		//using final to disable type widening :) 
		final byte age11 = 10;
		final byte age22 = 20;
		short sum1 = age11 + age22;
		/**
		 * byte age1 = 10;
		 * byte age2 = 20;
		 * short sum = age1 + age2; // compilation error : lossy conversion
		 * */
		
		
		int a = 20;
		int b = 10;
		int c = ++a-++b-++a*b+++a++-++a;
		System.out.println(c);
		System.out.println(b);
	
		String word = "toto";
		word.concat("nono");
		System.out.println(word);
		
		
		// string pool experiance  one
		String name = "paul";//population pool with paul
		String test = new String(name);// will the compiler alocate or use the same ref
		
		System.out.println("paul" == test);
		System.out.println("paul" == name);
		System.out.println(name == test);
		
		// result the new will always use a new ref to get the value of any ref
		
		String paul = name;
		String $paul = new String(test);
		String €paul = test;

		System.out.println($paul == €paul);
		System.out.println($paul == test);
		System.out.println(€paul == test);
		System.out.println(paul == "paul");
		
		
		// a JFRame or a Frame is an object so the following is true
		new Frame("toto", 0);
		new Frame("fofo",1);
		
		// in this case they are sibling and nor frame is referencing another frame
		// we use the framepool
		int switchId = framePool.get("fofo").getId();
		framePool.get("fofo").setId(framePool.get("toto").getId());
		framePool.get("toto").setId(switchId);
		
		
	}
	
	public static class Frame{
		private String name;
		private int id;
		
		
		
		public Frame(String name, int id) {
			this.name = name;
			this.id = id;
			
			//registring in frame pool this created frame
			ArethmiticOperators.framePool.put(name, this);
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public int getId() {
			return id;
		}
		
		public void setName(String name) {
			this.name = name;
		}  
		
		public String getName() {
			return name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Objects.hash(id, name);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Frame)) {
				return false;
			}
			Frame other = (Frame) obj;
			return id == other.id && Objects.equals(name, other.name);
		}

		
		
	}
	
}
