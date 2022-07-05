/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package com.practice.java.features.streams.pluralsight.lambda.exercises.test;

import com.practice.java.features.streams.pluralsight.lambda.Product;
import com.practice.java.features.streams.pluralsight.lambda.exercises.LambdasExercise03;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.practice.java.features.streams.pluralsight.lambda.Category.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LambdasExercise03Test {

    private static final List<Product> TEST_PRODUCTS = Arrays.asList(
            new Product(OFFICE, "Pencils", new BigDecimal("5.79")),
            new Product(FOOD, "Apples", new BigDecimal("1.29")),
            new Product(UTENSILS, "Plates", new BigDecimal("12.95")),
            new Product(FOOD, "Spaghetti", new BigDecimal("2.79")),
            new Product(FOOD, "Coffee", new BigDecimal("7.49")),
            new Product(CLEANING, "Detergent", new BigDecimal("3.79")));

    private LambdasExercise03 exercise = new LambdasExercise03();

    @Test
    @DisplayName("Exercise 3: Use a shopping cart")
    void useShoppingCart() {
        LambdasExercise03.ShoppingCartFactory factory = exercise.getShoppingCartFactory();
        assertThat(factory, instanceOf(LambdasExercise03.ShoppingCartFactory.class));

        LambdasExercise03.ShoppingCart shoppingCart = factory.newShoppingCart();
        assertThat(shoppingCart, instanceOf(LambdasExercise03.ShoppingCart.class));

        for (Product product : TEST_PRODUCTS) {
            shoppingCart.add(product);
        }

        assertEquals(new BigDecimal("34.10"), shoppingCart.getTotalAmount());

    }
}
