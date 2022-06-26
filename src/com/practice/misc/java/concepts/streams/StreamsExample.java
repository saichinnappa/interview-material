package com.practice.misc.java.concepts.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsExample {
    public static void main(String[] args) {

        Address a1 = new Address("plymouth", "unit 1", 55317);
        Address a2 = new Address("plymouth", "unit 2", 55317);
        Person p1 = new Person("Sai", 1, a1, Arrays.asList("green", "yellow", "blue"));
        Person p2 = new Person("Keerthi", 2, a2, Arrays.asList("white", "black", "grey"));

        List<Person> personList = Arrays.asList(p2, p1);

        System.out.println("********************* STEAMS EXAMPLES ***********************\n");

        System.out.println("------------------FETCH PERSON WITH 2 IN ADDRESS LANE TWO---------------------");
        //All persons whose address line two contains "2"
        List<Person> addresses = personList.stream().filter(p -> p.address.lineTwo.contains("2")).collect(Collectors.toList());
        System.out.println(addresses);

        System.out.println("\n------------------FETCH ALL COLORS ACROSS ALL PERSONS---------------------");

        // Collect all colors across all persons
        List<String> colorList = personList.stream().flatMap(p -> p.colors.stream()).collect(Collectors.toList());
        System.out.println(colorList);

        System.out.println("\n------------------FETCH PERSONS WITH ONLY GREEN COLOR---------------------");
        //List of persons with color green
        Predicate<Person> pp = p -> p.colors.contains("green");
        List<Person> result1 = personList.stream().filter(pp).collect(Collectors.toList());
        System.out.println(result1);

        System.out.println("\n------------------FETCH ALL PERSON IDs---------------------");
        //Fetch all id's from the persons list
        List<Integer> pIds = personList.stream().map( p -> p.id).collect(Collectors.toList());
        System.out.println(pIds);

        System.out.println("\n------------------FETCH A MAP OF PERSON ID AND PERSON NAME---------------------");
        //Collecting to a map
        Map<Integer, String> result2 = personList.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(result2);

        System.out.println("\n------------------FETCH A MAP OF PERSON ID AND PERSON OBJECT---------------------");
        //Collecting to a map (id as key and person as value)
        Map<Integer, Person> result3 = personList.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(result3);


        IntStream stream = IntStream.range(1, 100);
        List<Integer> primes = stream.filter(StreamsExample::isPrime)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(primes);


    }

    public static boolean isPrime(int i)
    {
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
    }

    static class Person{
        String name;
        int id;
        Address address;
        List<String> colors;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", address=" + address +
                    ", colors=" + colors +
                    '}';
        }

        public Person(String name, int id, Address address, List<String> colors) {
            this.name = name;
            this.id = id;
            this.address = address;
            this.colors = colors;
        }

        public List<String> getColors() {
            return colors;
        }

        public void setColors(List<String> colors) {
            this.colors = colors;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    static class Address{
        String lineOne;
        String lineTwo;
        int zipCode;

        @Override
        public String toString() {
            return "Address{" +
                    "lineOne='" + lineOne + '\'' +
                    ", lineTwo='" + lineTwo + '\'' +
                    ", zipCode=" + zipCode +
                    '}';
        }

        public Address(String lineOne, String lineTwo, int zipCode) {
            this.lineOne = lineOne;
            this.lineTwo = lineTwo;
            this.zipCode = zipCode;
        }

        public String getLineOne() {
            return lineOne;
        }

        public void setLineOne(String lineOne) {
            this.lineOne = lineOne;
        }

        public String getLineTwo() {
            return lineTwo;
        }

        public void setLineTwo(String lineTwo) {
            this.lineTwo = lineTwo;
        }

        public int getZipCode() {
            return zipCode;
        }

        public void setZipCode(int zipCode) {
            this.zipCode = zipCode;
        }
    }

}


