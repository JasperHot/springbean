package com.java.maven.test.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class example 
{
   static void exception1() throws Exception{
	   try{
		   System.out.println("exception1 try()");
		   exception2();
	   } catch(ArithmeticException e){
		   System.out.println("exception1 catch(ArithmeticException)");
		   throw e;
	   } catch(Exception e){
		   System.out.println("exception1 catch(Exception)");
		   throw e;
	   } finally{
		   System.out.println("exception1 finally()");
	   }
   } 
   static void exception2() throws Exception{
	   boolean result=true;
	   try{
		   int a=3,b=0;
		   System.out.println("exception2 try("+a+"/"+b+")="+a/b);
		   System.out.println("can't be printed");
		   //return true;
	   } catch(ArithmeticException e){
		   System.out.println("exception2 catch(ArithmeticException)");
		   result=false;
		   throw e;/*return() of finally can bypass throw() of catch*/
	   } catch(Exception e){
		   System.out.println("exception2 catch(Exception)");
		   result=false;
		   throw e;
	   } finally{
		   System.out.println("exception2 finally()");
		   //return result;/*so return() in finally is very bad coding*/
	   }
   } 
    public static void main( String[] args )
    {
    	try{
    		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
    			"springModule.xml");
    	    Person obj = (Person) context.getBean("helloBean",Person.class);
    	    System.out.println("who is got: "+obj.getName()+" age: "+obj.getAge()+" home: "+obj.hometwon);
    	    context.close();
    	    exception1();
    	}catch(Exception e){
    		System.out.println(e.toString());
    	}finally{
    		System.out.println("End!");
    	}
    }

}
