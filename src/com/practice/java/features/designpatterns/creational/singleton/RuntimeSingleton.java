package com.practice.java.features.designpatterns.creational.singleton;

/**
 * 1. Guarantees only one instance is created
 * 2. control of resource
 * 3. Lazily loaded
 * 4. ex: Runtime, Logger, Spring beans, Graphic Managers
 */

public class RuntimeSingleton {
    public static void main(String[] args) {

        // Java Runtime example
        Runtime instanceOne = Runtime.getRuntime();
        Runtime instanceTwo = Runtime.getRuntime();

        System.out.println("Address for instanceOne: "+ instanceOne);
        System.out.println("Address for instanceTwo: "+ instanceTwo);
        if(instanceOne == instanceTwo)
            System.out.println("Both are equal.");

    }

}
