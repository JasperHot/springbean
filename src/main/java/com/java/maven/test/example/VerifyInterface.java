package com.java.maven.test.example;

public class VerifyInterface {
	public class Account{
    	String name;
    	int age;
    }
	private String findName(Account user, int number){
		return user.name+"."+user.age+"."+number;
	}
	public String externalInterface(Account user, int number){
		return findName(user,number);
	}
	public String externalInterface(Account user){
		return externalInterface(user,0);
	}
}
