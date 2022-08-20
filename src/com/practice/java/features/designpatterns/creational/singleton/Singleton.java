package com.practice.java.features.designpatterns.creational.singleton;

public class Singleton {

//    Eagerly loaded -> creating instance always whether used or not.
//    private static DBSingleton instance = new DBSingleton();

//    Lazily loaded -> only create instance on demand basis
//    private static DBSingleton instance = null;

//    To make thread safe add volatile
//    1. volatile variable will always be read from the main memory, not from the local thread cache.
//    2. volatile variables are always visible to other threads.
//    3. Volatile keyword is used to modify the value of a variable by different threads.
    private static volatile Singleton instance = null;


//     Mark constructor as private, so no exposed to other classes to create instances
    private Singleton(){
//     To avoid reflection
        if(instance != null)
            throw new RuntimeException("Must use getInstance() to create instance.");
    }

    // To get instance of a class call this method.
    // It checks if instance already exists and return
    // if not return existing instance.
    public static Singleton getInstance(){
       if(instance == null) {
//         only add synchronize to this statement, so two threads won't be creating two instances
           synchronized (Singleton.class){
               if(instance == null) {
                   instance = new Singleton();
               }
           }

       }
       return instance;
    }
}
