package com.java.maven.test.example;

public class Person {
	private String name;
	private int age;
	public String hometwon;
	public Person brother;
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
	 * setHome
	 * @param home
	 */
	public void setHometown(String home){
		this.hometwon=home;
		}
	/**
	 * setBrother
	 * @param brother
	 */
	public void setBrother(Person brother){
		this.brother=brother;
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
