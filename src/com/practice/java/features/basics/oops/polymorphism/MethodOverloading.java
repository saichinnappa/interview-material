package com.practice.java.features.basics.oops.polymorphism;

/**
 * Static/Compile-time Polymorphism - Same method name, different signatures.
 * Overloading cannot be done by return type.
 */

// Class 1
// Helper class
class Helper {

    // Method with 2 integer parameters
    static final int Multiply(int a, int b) {

        // Returns product of integer numbers
        return a * b;
    }

    // Method 2
    // With same name but with 2 double parameters
    static final double Multiply(double a, double b) {

        // Returns product of double numbers
        return a * b;
    }
}

// Class 2
// Main class
public class MethodOverloading {

    // Main driver method
    public static void main(String[] args) {

        // Calling method by passing
        // input as in arguments
        System.out.println(Helper.Multiply(2, 4));
        System.out.println(Helper.Multiply(5.5, 6.3));
    }
}