package com.practice.java.features.pluralsight.streams.exercise;

import com.practice.java.features.pluralsight.Category;
import com.practice.java.features.pluralsight.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreamsExercise02 {

    /**
     * Exercise 2a: In a list of products, find the products that are in a given category and return their names.
     *
     * @param products A list of products.
     * @param category A product category.
     * @return A List containing the names of the products in the given category.
     */
    public List<String> getProductNamesForCategory(List<Product> products, Category category) {
        // TODO: Add three stream operation methods:
        //
        // 1) Find the products that are in the given category
        // 2) Transform each product to its name
        // 3) Collect the result into a List
        //
        // Hint: Use the API documentation of interface java.util.stream.Stream.

        return products.stream()
                .filter(p -> p.getCategory() == category)
                .map(p -> p.getName())
                .collect(Collectors.toList());
    }

    /**
     * Exercise 2b: Given a map that contains products grouped by category and a stream of categories, get the names of the products
     * for each category in that stream and return all the products in a list.
     *
     * @param productsByCategory A map containing products grouped by category.
     * @param categories         A stream of product categories.
     * @return A list containing the names of products in each of the categories in the given stream.
     */
    public List<String> categoriesToProductNames(Map<Category, List<Product>> productsByCategory, Stream<Category> categories) {
        // TODO: Start with the stream of categories.
        // For each category in that stream, get the products.
        // Then transform them to product names.
        // Finally, collect the results in a list.
        //
        // Hint: You'll need to use different mapping methods.
        return categories.map( c ->  productsByCategory.get(c))
                .flatMap( p -> p.stream())
                .map(p -> p.getName())
                .collect(Collectors.toList());


//        return categories.map(productsByCategory::get).
//                flatMap(p-> p.stream().map(Product::getName)).collect(Collectors.toList());



    }
}
