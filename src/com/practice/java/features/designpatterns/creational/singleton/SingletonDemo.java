package com.practice.java.features.designpatterns.creational.singleton;

public class SingletonDemo{
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1);
    }
}