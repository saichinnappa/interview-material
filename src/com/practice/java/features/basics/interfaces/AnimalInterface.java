package com.practice.java.features.basics.interfaces;

/**
 * Interface features:
 *
 * 1. Supports Multiple Inheritance
 * 2. No implementation, caller classes must implement the contract
 * 3. All variables declared in an interface are final.
 * 4. Default methods provide backward compatibility (Java 8 and above)
 * 5. Can define static methods, which groups the all functions in one class and can be called without need of an object
 */
public interface AnimalInterface {
    int age = 0;
    String name = "test";

    void doNoise();
    void color();

    default String defaultMethod(){
        return "Hello, from default method!";
    }

    static void hello(){
        System.out.println("Hello, from static method!");
    }

}
