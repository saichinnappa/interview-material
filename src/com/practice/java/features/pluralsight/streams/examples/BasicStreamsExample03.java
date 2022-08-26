/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package com.practice.java.features.pluralsight.streams.examples;

import com.practice.java.features.pluralsight.Category;
import com.practice.java.features.pluralsight.ExampleData;
import com.practice.java.features.pluralsight.Product;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BasicStreamsExample03 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // The filter() intermediate operation filters elements from the stream
        products.stream()
                .filter(product -> product.getCategory() == Category.FOOD)
                .forEach(System.out::println);

        // The map() intermediate operation does a one-to-one transformation on each element
        products.stream()
                .map(product -> String.format("The price of %s is $ %.2f", product.getName(), product.getPrice()))
                .forEach(System.out::println);

        // The flatMap() intermediate operation does a one-to-N transformation on each element
        // The function passed to flatMap() must return a Stream that contains the output elements
        // The streams returned by the calls to the function are "flatted" into a single output stream
        Pattern spaces = Pattern.compile("\\s+");
        products.stream()
                .flatMap(product -> spaces.splitAsStream(product.getName()))
                .forEach(System.out::println);


        //Map example
        List<String> list = List.of("a", "b", "c", "d");
        List<String> mapResult = list.stream().map(s -> s).collect(Collectors.toList());
        System.out.println(mapResult);

        //FlatMap example
        List<List<String>> list1 = List.of(List.of("a","b"), List.of("c","d"));
        List<String> flatMapResult = list1.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println(flatMapResult);
    }
}
