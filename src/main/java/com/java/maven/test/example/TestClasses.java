package com.java.maven.test.example;

public class TestClasses {
	public static void main(String[] args) {
		TestClasses testClasses = new TestClasses();
		testInternalClass testInternalClass = testClasses.new testInternalClass();
		System.out.println(testInternalClass.test());
	}
	public class testInternalClass {
		int test() {
			int x = 1;
			try {
				return x;
			} finally {
				x += 1;
				System.out.println("x= " + x);
			}
		}
	}
}

class testPrivateClasses {

}
