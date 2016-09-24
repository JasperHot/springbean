package com.java.maven.test.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class example 
{

    public static void main( String[] args )
    {
    	try{
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
    			"springModule.xml");
    	Person obj = (Person) context.getBean("helloBean");
    	System.out.println("who is got: "+obj.getName());
    	context.close();
    	}catch(Exception e){
    		System.out.println(e.toString());
    	}
    }

}
