package com.practice.java.features.basics.innerclass;

public class TestInnerClass {
    public static void main(String[] args) {
        //Accessing innerclass print() func via outerclass method
        OuterClass outerClass = new OuterClass();
        outerClass.printInnerClassMessage();
        //Accessing inner class via outerclass object
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.print();

    }
}
