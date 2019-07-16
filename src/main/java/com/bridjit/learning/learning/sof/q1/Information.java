package com.bridjit.learning.learning.sof.q1;

public class Information {
	public static void main(String[] args) {
		DataEntryLogger logger = DataEntryLogger.USER_CLASS;
		User user = new User("taleb", "mhaleb", "talcorpdz@gmail.com");
		System.out.println("mutate methode invoked : " + logger.log(user, "mutate"));
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		showUser(user);
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		logger = DataEntryLogger.GENERIC;
		user = new User("genric", "genericUser", "generic@gmail.com");
		System.out.println("mutate methode invoked : " + logger.log(user, "mutate"));
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		showUser(user);
	}

	public static void showUser(User u) {
		System.out.println("case of object used as dto");
		DataEntryLogger logger = DataEntryLogger.USER_CLASS;
		System.out.println("showUser methode invoked : " + logger.log(u, "reflectAll"));

	}
}
