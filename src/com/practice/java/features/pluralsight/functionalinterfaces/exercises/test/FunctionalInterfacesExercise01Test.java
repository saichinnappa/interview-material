package com.practice.java.features.pluralsight.functionalinterfaces.exercises.test;

import com.practice.java.features.pluralsight.Product;
import com.practice.java.features.pluralsight.functionalinterfaces.exercises.FunctionalInterfacesExercise01;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.function.Predicate;
import static com.practice.java.features.pluralsight.Category.FOOD;
import static com.practice.java.features.pluralsight.functionalinterfaces.exercises.test.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;

class FunctionalInterfacesExercise01Test {

    private FunctionalInterfacesExercise01 exercise = new FunctionalInterfacesExercise01();

    @Test
    @DisplayName("Filter products")
    void filterProducts() {
        assertThat(exercise.filterProducts(TestData.getProducts(), (Predicate<Product>) product -> product.getCategory() == FOOD))
                .describedAs("Exercise 1: When searching for FOOD products, only those should be returned.")
                .containsExactly(APPLES, SPAGHETTI, COFFEE);

        assertThat(exercise.filterProducts(TestData.getProducts(), (Predicate<Product>) product -> product.getCategory() != FOOD))
                .describedAs("Exercise 2: When searching for non-FOOD products, only those should be returned.")
                .containsExactly(PENCILS, PLATES, DETERGENT);
    }
}
