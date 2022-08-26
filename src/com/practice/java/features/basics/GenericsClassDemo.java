package com.practice.java.features.basics;

public class GenericsClassDemo<V> {
    private V t;

    public void set(V t) {
        this.t = t;
    }

    public V get() {
        return t;
    }

    public static void main(String[] args) {
        GenericsClassDemo<Integer> integerBox = new GenericsClassDemo<Integer>();
        GenericsClassDemo<String> stringBox = new GenericsClassDemo<String>();

        integerBox.set(10);
        stringBox.set(new String("Hello World"));
        System.out.printf("Integer Value :%d\n\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());
    }
}
