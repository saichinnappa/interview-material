package com.practice.java.features.basics;

import java.util.Arrays;

public final class JavaBasics {

   public static void main(String[] args) {

//      int result1 = add(2, 3);
      double result2 = add(2.5, 4.4);
//      System.out.println("int -> "+ result1);
      System.out.println("double -> "+ result2);

   }


   /**
    * Method Overloading
    * 1. Same method name
    * 2. Different return type and arguments
    */

   public  int add(int a , int b) {
      return a + b;
   }

   private static double add(double a, double b){
      return a + b;
   }

}

class Test1{
   public static void main(String[] args) {
      JavaBasics javaBasics = new JavaBasics();
      System.out.println(javaBasics.add(3,4));
   }
}