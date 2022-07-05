package com.practice.misc.java.concepts.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {

        Address a1 = new Address("plymouth", "unit 1", 55317);
        Address a2 = new Address("plymouth", "unit 2", 55317);
        Person p1 = new Person("Sai", 1, a1, Arrays.asList("green", "yellow", "blue"));
        Person p2 = new Person("Keerthi", 2, a2, Arrays.asList("white", "black", "grey"));

        List<Person> personList = Arrays.asList(p2, p1);

        System.out.println("********************* STEAMS EXAMPLES ***********************\n");
        /**
         * 1. MAP (Convert one data type to another data type result
         * 2. FLAT MAP (Convert nested object to flat map)
         * 3. FILTER (Check a condition on the object)
         * 4. COLLECT (Result collector type ex: list, map)
         */

        System.out.println("------------------FETCH PERSON WITH 2 IN ADDRESS LANE TWO---------------------");
        //All persons whose address line two contains "2"
        List<Person> result1 = personList.stream().filter(p -> p.address.lineTwo.contains("2")).collect(Collectors.toList());
        System.out.println(result1);

        // Collect all colors across all persons
        System.out.println("\n------------------FETCH ALL COLORS ACROSS ALL PERSONS---------------------");
        List<String> result2 = personList.stream().flatMap( p -> p.colors.stream()).collect(Collectors.toList());
        System.out.println(result2);

        System.out.println("\n------------------FETCH PERSONS WITH ONLY GREEN COLOR---------------------");
        //List of persons with color green
        Predicate<Person> predicate = p -> p.colors.contains("green");
        List<Person> result3 = personList.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(result3);

        System.out.println("\n------------------FETCH ALL PERSON IDs---------------------");
        //Fetch all id's from the persons list
        Function<Person, String> func = (p) -> p.name;
        List<String> result4 = personList.stream().map(func).collect(Collectors.toList());
        System.out.println(result4);

        System.out.println("\n------------------FETCH A MAP OF PERSON ID AND PERSON NAME---------------------");
        //Collecting to a map
        Map<Integer, String> result5 = personList.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(result5);


        System.out.println("\n------------------FETCH A MAP OF PERSON ID AND PERSON OBJECT---------------------");
        //Collecting to a map (id as key and person as value)
        Map<Integer, Person> result6 = personList.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(result6);

        System.out.println("\n------------------FETCH MAP OF COLOR SIZES FOR EACH PERSON---------------------");
        //Colors size for each person
        Function<Person, Long> func1 = p -> (long)p.colors.size();
        Map<Integer, Long> result7 = personList.stream().collect(Collectors.toMap(Person::getId, func1));
        System.out.println(result7);


        System.out.println("********************* REDUCE EXAMPLES ***********************\n");
        /**
         *  3 components for REDUCE
         *  1. Identity (default value)
         *  2. Accumulator ( a function performs action on the input stream)
         *  3. Combiner ( works only on parallel stream, aggregates the result of the accumulator)
         */
        System.out.println("------------------REDUCE LIST OF NUMBERS---------------------");
        int result8 = Stream.of(1, 2, 3).reduce(10, Integer::sum);
        System.out.println(result8);

        System.out.println("------------------REDUCE LIST OF NUMBERS WITH COMBINER [PARALLEL STREAM]---------------------");
        int result9 = Stream.of(1, 2, 3).parallel().reduce(10, Integer::sum, Integer::sum);
        System.out.println(result9);

        System.out.println("********************* COLLECTOR EXAMPLES ***********************\n");
        System.out.println("-------------------BUILD STRING COLLECTING ALL NAMES-------------------");
        String result10 = personList.stream().map(Person::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(result10);

        List<Integer> result11 = personList.parallelStream().map(p -> p.id * 10).collect(Collectors.toList());
        System.out.println(result11);

//        IntStream stream = IntStream.range(1, 100);
//        List<Integer> primes = stream.filter(StreamsExample::isPrime)
//                .boxed()
//                .collect(Collectors.toList());
//        System.out.println(primes);


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


