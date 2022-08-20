package com.practice.java.features.designpatterns.creational.builder;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello ");
        stringBuilder.append("World ");
        stringBuilder.append(20);
        System.out.println(stringBuilder);
    }
}
