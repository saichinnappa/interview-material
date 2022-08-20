package com.practice.java.features.designpatterns.creational.builder;

public class LunchOrderBuilderDemo {
    public static void main(String[] args) {
        LunchOrder.Builder builder = new LunchOrder.Builder();
        builder.bread("Wheat")
                .dressing("Mayo")
                .condiments("Lettuce")
                .meat("Chicken");
        LunchOrder lunchOrder = builder.build();
        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());

    }
}
