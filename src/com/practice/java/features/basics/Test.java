package com.practice.java.features.basics;

public class Test {
    public static void main(String args[]) {
        RunTimePolymorphismParentExample obj = new RunTimePolymorphismSubClassExample();
        obj. display();
    }
}

class RunTimePolymorphismParentExample {
    public void display() {
        System.out.println("Overridden Method");
    }
}

class RunTimePolymorphismSubClassExample extends RunTimePolymorphismParentExample {

    public void display() {
        super.display();
        System.out.println("Overriding Method");
    }
}