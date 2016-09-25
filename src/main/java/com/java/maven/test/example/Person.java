package com.java.maven.test.example;

public class Person {
	private String name;
	private int age;
	/**
	 * setName
	 * @param name
	 */
	public void setName(String name){
		//this.name=name;
		this.name=name;
		}
	/**
	 * setAge
	 * @param age
	 */
	public void setAge(String age){
		//this.name=name;
		this.age=Integer.valueOf(age).intValue();
		}
	/**
	 * getName
	 * @return name
	 */
	public String getName(){
		return name;
		}
	/**
	 * getAge
	 * @return
	 */
	public int getAge(){
		return age;
		}
}
