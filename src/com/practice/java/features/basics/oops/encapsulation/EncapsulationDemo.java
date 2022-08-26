package com.practice.java.features.basics.oops.encapsulation;

/**
 * 1. Encapsulation is defined as the wrapping up of data under a single unit
 * 2. The variables or data of a class is hidden from any other class
 * and can be accessed only through any member function of its own class in which it is declared.
 * 3. Encapsulation can be achieved by Declaring all the variables in the class as private
 * and writing public methods in the class to set and get the values of variables.
 */
class Encapsulate {
    // private variables declared
    // these can only be accessed by
    // public methods of class
    private String geekName;
    private int geekRoll;
    private int geekAge;

    // get method for age to access
    // private variable geekAge
    public int getAge() {
        return geekAge;
    }

    // get method for name to access
    // private variable geekName
    public String getName() {
        return geekName;
    }

    // get method for roll to access
    // private variable geekRoll
    public int getRoll() {
        return geekRoll;
    }

    // set method for age to access
    // private variable geekage
    public void setAge(int newAge) {
        geekAge = newAge;
    }

    // set method for name to access
    // private variable geekName
    public void setName(String newName) {
        geekName = newName;
    }

    // set method for roll to access
    // private variable geekRoll
    public void setRoll(int newRoll) {
        geekRoll = newRoll;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Encapsulate obj = new Encapsulate();

        // setting values of the variables
        obj.setName("Harsh");
        obj.setAge(19);
        obj.setRoll(51);

        // Displaying values of the variables
        System.out.println("Geek's name: " + obj.getName());
        System.out.println("Geek's age: " + obj.getAge());
        System.out.println("Geek's roll: " + obj.getRoll());

        // Direct access of geekRoll is not possible
        // due to encapsulation
        // System.out.println("Geek's roll: " +
        // obj.geekName);
    }
}
