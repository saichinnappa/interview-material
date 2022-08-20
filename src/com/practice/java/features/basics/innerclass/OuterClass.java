package com.practice.java.features.basics.innerclass;

public class OuterClass {

    public class InnerClass{
        public void print(){
            System.out.println("Hello, from inner class!");
        }
    }
    void printInnerClassMessage(){
        System.out.println("Hello, from outer class!");
        InnerClass innerClass = new InnerClass();
        innerClass.print();
    }
}
