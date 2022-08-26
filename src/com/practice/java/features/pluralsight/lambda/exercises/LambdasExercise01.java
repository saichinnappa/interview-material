package com.practice.java.features.pluralsight.lambda.exercises;


import com.practice.java.features.pluralsight.Product;

import java.util.Comparator;
import java.util.List;

public class LambdasExercise01 {

    /**
     * Exercise 1: Sort a list of products by name using a lambda expression.
     *
     * @param products The list of products to sort.
     */
    public void sortProductsByName(List<Product> products) {
        // TODO: Use a lambda expression to sort the list of products by name
        products.sort(Comparator.comparing(Product::getName));
//        products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
//        products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
//       products.sort(new Comparator<Product>(){
//          @Override
//          public int compare(Product p1, Product p2){
//              return p1.getName().compareTo(
//                      p2.getName());
//            }
//       });
    }
}
