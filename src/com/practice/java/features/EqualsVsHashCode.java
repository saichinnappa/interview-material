package com.practice.java.features;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualsVsHashCode {
    public static void main(String[] args) {
        Money m1 = new Money(55, "USD");
        System.out.println(m1.hashCode());
        Money m2 = new Money(55, "USD");
        System.out.println(m2.hashCode());
        System.out.println(m1.equals(m2));

        Map<Money, String> map = new HashMap<>();
        map.put(m1, "m1");
        map.put(m2, "m2");
        Money m3 = new Money(55, "USD");

        System.out.println(map.size());

        System.out.println(map.get(m3)); //this fails, since hashcode is different for m3 and m1 (without overridding hashcode for Money class)
        //if hashcode is overidden correct value is calculated and retrieved from the hashmap.
    }
}


class Money {
    int amount;
    String currencyCode;

    public Money(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Money money = (Money) o;
//        return amount == money.amount && currencyCode.equals(money.currencyCode);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currencyCode);
    }
}