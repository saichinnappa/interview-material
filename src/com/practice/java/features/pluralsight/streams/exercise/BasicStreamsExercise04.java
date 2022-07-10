package com.practice.java.features.pluralsight.streams.exercise;

import com.practice.java.features.pluralsight.Category;
import com.practice.java.features.pluralsight.ExampleData;
import com.practice.java.features.pluralsight.Product;

import java.util.List;
import java.util.Optional;

public class BasicStreamsExercise04 {

    /**
     * Exercise 4: In a list of products, find the cheapest cleaning product.
     *
     * @param products A list of products.
     * @return An Optional containing the cheapest product in the category CLEANING in the list,
     * or an empty Optional if there is no such product in the list.
     */
    public Optional<Product> findCheapestCleaning(List<Product> products) {
        // TODO: Look for products that are in the category CLEANING and find the cheapest one.
        //
        // Hint: Use a terminal operation to find the cheapest product.
        // Look at the API documentation of interface java.util.stream.Stream, find out which operation would be suitable.

       return products.stream()
               .filter(p -> p.getCategory() == Category.CLEANING).min((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

//        return products.stream()...;


    }
}
