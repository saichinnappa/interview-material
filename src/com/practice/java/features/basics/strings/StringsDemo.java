package com.practice.java.features.basics.strings;

/**
 * StringBuffer - Threadsafe (reserves room for 16 characters)
 * StringBuilder - Not Threadsafe (reserves room for 16 characters)
 * String - Immutable (constant and cannot be changed, built on char array)
 * Creates a new object in the string pool in heap memory.
 * If a new string is created with same value, both objects refer to the same location in string pool.
 */
public class StringsDemo {
    public static void main(String[] args) {
        String s1 = "teststring"; // creates an object in string pool in heap memory
        String s2 = "teststring"; //since s2 also has the same value, it points to the same value in string pool
        System.out.println("s1: "+s1.hashCode()+" s2: "+ s2.hashCode());

        //Thread safe
        StringBuffer s3 = new StringBuffer("teststring");
        System.out.println("s3: " +s3.hashCode());

        //Not threadsafe, but faster. Preferred in single threaded environment to perform operations on string.
        StringBuilder s4 = new StringBuilder("teststring");
        System.out.println("s4: "+ s4.hashCode());
    }
}
