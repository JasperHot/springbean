package com.java.maven.test.example;

import org.springframework.context.support.AbstractApplicationContext;
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
    		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
    			"springModule.xml");
    	    Person obj = (Person) context.getBean("helloBean",Person.class);
    	    System.out.println("who is got: "+obj.getName()+" age: "+obj.getAge()+" home: "+obj.hometwon);
    	    context.close();
    	}catch(Exception e){
    		System.out.println(e.toString());
    	}finally{
    		System.out.println("End!");
    	}
    }

}
