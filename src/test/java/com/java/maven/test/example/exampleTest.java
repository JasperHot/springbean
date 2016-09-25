package com.java.maven.test.example;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class exampleTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("this is before class");
    }

    @Test
    public void TestNgLearn() {
        System.out.println("this is TestNG test case");
    	try{
    		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
    			"springModule.xml");
    	    Person obj = (Person) context.getBean("helloBean",Person.class);
    	    System.out.println("who is got: "+obj.getName()+" age: "+obj.getAge()+" home: "+obj.hometwon+" brother: "+obj.brother.getName());
    	    Person obj2 = (Person) context.getBean("secondBean",Person.class);
    	    System.out.println("who is got: "+obj2.getName()+" age: "+obj2.getAge()+" home: "+obj2.hometwon+" brother: "+obj2.brother.getName());
    	    context.close();
    	}catch(Exception e){
    		System.out.println(e.toString());
    	}finally{
    		System.out.println("End!");
    	}
    }

    @AfterClass
    public void afterClass() {
        System.out.println("this is after class");
    }

}
