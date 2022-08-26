package com.practice.java.features.basics.abstractclass;

public class CatAbstractClass extends AnimalAbstractClass{

    public static void main(String[] args) {
        AnimalAbstractClass cat = new CatAbstractClass();
        cat.name = "test";
        cat.age = 2;
        System.out.println(cat.name);
        System.out.println(cat.age);
        cat.color();
        cat.doNoise();
        cat.hello();
    }

    @Override
    public void doNoise() {
        System.out.println("Meow!");
    }

    @Override
    public void color() {
        System.out.println("Brown");
    }

//    @Override
//    public void hello(){
//        System.out.println("Hello, from sub-class!");
//    }
//

}
