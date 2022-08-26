package com.practice.java.features.basics.oops.inheritance;

/**
 * In Multiple inheritances, one class can have more than one superclass and inherit features from all parent classes
 * In java, we can achieve multiple inheritances only through Interfaces
 */
interface Q {
    public void print_geek();
}

interface W {
    public void print_for();
}

interface E extends Q, W {
    public void print_geek();
}
class child implements E {
    @Override public void print_geek()
    {
        System.out.println("Geeks");
    }
    @Override
    public void print_for() { System.out.println("for"); }
}

// Driver class
public class MultipleInheritance {
    public static void main(String[] args)
    {
        child c = new child();
        c.print_geek();
        c.print_for();
        c.print_geek();
    }
}

