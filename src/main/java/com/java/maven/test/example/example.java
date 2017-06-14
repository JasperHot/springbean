package com.java.maven.test.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class example 
{
  /*test exception*/
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
   public static <T extends Comparable<T>> T maximum(T x, T y, T z)
   {                     
      T max = x; // 假设x是初始最大值
      if ( y.compareTo( max ) > 0 ){
         max = y; //y 更大
      }
      if ( z.compareTo( max ) > 0 ){
         max = z; // 现在 z 更大           
      }
      return max; // 返回最大对象
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
    	
    	   /*test hashcode*/
    	   final class A{
    		   String name;
    		   String age;
    		   public A(String name, String age){
    			   this.name=name;
    			   this.age=age;
    		   }
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((age == null) ? 0 : age.hashCode());
				result = prime * result + ((name == null) ? 0 : name.hashCode());
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				A other = (A) obj;
				if (age == null) {
					if (other.age != null)
						return false;
				} else if (!age.equals(other.age))
					return false;
				if (name == null) {
					if (other.name != null)
						return false;
				} else if (!name.equals(other.name))
					return false;
				return true;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getAge() {
				return age;
			}
			public void setAge(String age) {
				this.age = age;
			}
    		   
    	   }
    	   
    	   final class B{
    	       String b;
    	       List<A> bb=new ArrayList<>();
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				int tmpForList=0;
				result = prime * result + ((b == null) ? 0 : b.hashCode());
				for(A tmp:bb){
					tmpForList+=tmp.hashCode();
				}
				result = prime * result + ((bb == null) ? 0 : tmpForList);
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				B other = (B) obj;
				if (b == null) {
					if (other.b != null)
						return false;
				} else if (!b.equals(other.b))
					return false;
				if (bb == null) {
					if (other.bb != null)
						return false;
				} else if (other.bb!=null){
					
					if(bb.size()!=other.bb.size()){
					return false;
					}
					for(A tmp:other.bb){
						if(!bb.contains(tmp)){
							return false;
						}
					}
					for(A tmp:bb){
						if(!other.bb.contains(tmp)){
							return false;
						}
					}
				}
				return true;
			}
    	       
    	   }
       List<A> aa=new ArrayList<>();
       aa.add(new A("Zhangsan","33"));
       aa.add(new A("Lisi","44"));
       List<A> bb=new ArrayList<>();

       bb.add(new A("Zhangsan","33"));
       bb.add(new A("Lisi","44"));
       System.out.println("aa="+aa.hashCode());
       System.out.println("bb="+bb.hashCode());
       System.out.println("aa[0]="+aa.get(0).getAge()+" "+aa.get(0).getAge().hashCode());
       System.out.println("aa[1]="+aa.get(1).getAge()+" "+aa.get(1).getAge().hashCode());
       System.out.println("bb[0]="+bb.get(0).getAge()+" "+bb.get(0).getAge().hashCode());
       System.out.println("bb[1]="+bb.get(1).getAge()+" "+bb.get(1).getAge().hashCode());
       System.out.println("aa[0]?=bb[1]:"+aa.get(0).equals(bb.get(1)));
       String aaa=new String("Zhangsan");
       String bbb=new String("Zhangsan");
       System.out.println("aaa?=bbb:"+aaa.equals(bbb)+" "+(aaa.hashCode()==bbb.hashCode())+" "+(aaa==bbb));
       
       B x=new B();
       x.b=new String("1");
       x.bb.add(new A("Zhangsan","33"));
       x.bb.add(new A("Lisi","44"));
       
       B y=new B();
       y.b=new String("1");
       y.bb.add(new A("Lisi","44"));
       y.bb.add(new A("Zhangsan","33"));
       System.out.println("x?=y:"+x.equals(y)+" "+(x.hashCode()==y.hashCode())+" "+(x==y));
       System.out.println(" "+x.bb.hashCode()+" "+y.bb.hashCode());
       
    }

}
