package com.java.maven.test.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleTest {
	static public final Logger logger = LoggerFactory
			.getLogger(ExampleTest.class);
	@BeforeClass
	public void beforeClass() {
		System.out.println("this is before class");
	}

	@Test
	public void testSuite() {
		System.out.println("this is TestNG test case");
		try {
			AbstractApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:springModule.xml");
			Person obj = context.getBean("helloBean", Person.class);
			logger.info(
					"<==== Who is got: {} age: {}; home: {}; brother: {}; pets: {}; ====>",
					obj.getName(), obj.getAge(), obj.hometwon,
					obj.brother.getName(), obj.pets);
			Reporter.log("<==== Who is got: " + obj.getName() + " age: "
					+ obj.getAge() + "; home: " + obj.hometwon + "; brother: "
					+ obj.brother.getName() + "; pets: " + obj.pets
					+ "; ====><br />");
			Person obj2 = context.getBean("secondBean", Person.class);
			logger.info(
					"<==== Who is got: {} age: {}; home: {}; brother: {}; pets: {}; ====>",
					obj2.getName(), obj2.getAge(), obj2.hometwon,
					obj2.brother.getName(), obj2.pets);
			Reporter.log("<br /><==== Who is got: " + obj2.getName() + " age: "
					+ obj2.getAge() + "; home: " + obj2.hometwon + "; brother: "
					+ obj2.brother.getName() + "; pets: " + obj2.pets
					+ "; ====><br />");
			context.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("End!");
		}
	}

	@AfterClass
	public void afterClass() {
		System.out.println("this is after class");
	}

}
