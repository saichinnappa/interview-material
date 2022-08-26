package com.practice.java.features.basics.oops.inheritance;

/**
 *  In Hierarchical Inheritance, one class serves as a superclass (base class) for more than one subclass.
 */

// Java program to illustrate the
// concept of Hierarchical inheritance

class X {
    public void print_X() { System.out.println("Class X"); }
}

class F extends X {
    public void print_F() { System.out.println("Class F"); }
}

class C extends X {
    public void print_C() { System.out.println("Class C"); }
}

class D extends X {
    public void print_D() { System.out.println("Class D"); }
}

// Driver Class
public class HierarchialInheritance {
    public static void main(String[] args)
    {
        F obj_B = new F();
        obj_B.print_X();
        obj_B.print_F();

        C obj_C = new C();
        obj_C.print_X();
        obj_C.print_C();

        D obj_D = new D();
        obj_D.print_X();
        obj_D.print_D();
    }
}