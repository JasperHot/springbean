package com.java.maven.test.example;

public class MyClass {

    class Base{
        Base(){
            aMethod();
        }
        void aMethod(){
        System.out.println("this is first method");
    }};
    class Son extends Base implements Intf {
        Son(){
            aMethod();
        }
        @Override
        void aMethod(){
            System.out.println("this id second method");
        }
    }
    interface Intf{}
    public static void main(String [] args){
        Base base = new MyClass().new Base();base.aMethod();
        Son son = new MyClass().new Son();
        Intf intf = son;
        base = son;base.aMethod();//upcast
        Object obj = base;
        obj = son;
        son = (Son) base;//downcast

        return;
    }
}
