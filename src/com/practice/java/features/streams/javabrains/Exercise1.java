package com.practice.java.features.streams.javabrains;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        Stream<Integer> intStream = StreamSources.intNumbersStream();
        intStream.forEach(System.out::print);

        System.out.println("##############");

        // Print numbers from intNumbersStream that are less than 5
        Stream<Integer> intStream1 = StreamSources.intNumbersStream();
        intStream1.filter(i -> i < 5).forEach(System.out::print);

        System.out.println("##############");
        // Print the second and third numbers in intNumbersStream that's greater than 5
        Stream<Integer> intStream2 = StreamSources.intNumbersStream();
        intStream2.filter(i-> i > 5).skip(1).limit(2).forEach(System.out::print);
        System.out.println("##############");

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Stream<Integer> intStream3 = StreamSources.intNumbersStream();
        int x = intStream3.filter(i-> i > 5).skip(1).limit(1).findFirst().orElse(-1);
        System.out.println(x);

        // Print first names of all users in userStream
        System.out.println("##############");
        Stream<User> userStream = StreamSources.userStream();
        userStream.forEach(u -> System.out.println(u.getFirstName()));

        System.out.println("##############");
        // Print first names in userStream for users that have IDs from number stream
        Stream<User> userStream2 = StreamSources.userStream();
        Stream<Integer> intStream4 = StreamSources.intNumbersStream();
        intStream4
                .forEach(one -> {userStream2
                        .filter(two -> {return two.getId() == one;})
                        .forEach(System.out::println
                                );
                });

    }

}
