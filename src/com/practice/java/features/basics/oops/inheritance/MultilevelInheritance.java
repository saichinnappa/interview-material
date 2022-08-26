package com.practice.java.features.basics.oops.inheritance;


/**
 * In Multilevel Inheritance, a derived class will be inheriting a base class
 * and as well as the derived class also act as the base class to other class.
 */
class A {
    public void print_geek1()
    {
        System.out.println("Geeks");
    }
}

class B extends A {
    public void print_for() { System.out.println("for"); }
}

class three extends B {
    public void print_geek()
    {
        System.out.println("Geeks");
    }
}

// Drived class
public class MultilevelInheritance {
    public static void main(String[] args)
    {
        three g = new three();
        g.print_geek();
        g.print_for();
        g.print_geek1();
    }
}
