package com.practice.java.features.basics.interfaces;

public class CatInterfaceImplementation implements AnimalInterface{

    public static void main(String[] args) {
        AnimalInterface cat = new CatInterfaceImplementation();
        cat.doNoise();
        cat.color();
        System.out.println(CatInterfaceImplementation.age);
        System.out.println(CatInterfaceImplementation.name);
        System.out.println(cat.defaultMethod());
        AnimalInterface.hello();
    }

    @Override
    public String defaultMethod() {
        return "Overridden default method!";
    }

    @Override
    public void doNoise() {
        System.out.println("Meow!");
    }

    @Override
    public void color() {
        System.out.println("Brown");
    }

}
