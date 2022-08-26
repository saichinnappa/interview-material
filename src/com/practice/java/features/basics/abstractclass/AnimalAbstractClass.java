package com.practice.java.features.basics.abstractclass;

/**
 * Abstract Class features:
 * 1. Can have both abstract and concrete methods.
 * 2. Variables defined are not final, can be changed by the object;
 * 3. Can define method with common implementation.
 * 4. Use when there is an "IS-A" relationship (Cat is an animal)
 * 5. Cannot instantiate, but extend by the subclass
 */
public abstract class AnimalAbstractClass {
    int age;
    String name;

    abstract void doNoise();
    abstract void color();

    void hello(){
        System.out.println("Hello, from non-abstract method.");
    }

}
