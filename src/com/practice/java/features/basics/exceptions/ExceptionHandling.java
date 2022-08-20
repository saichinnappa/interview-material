package com.practice.java.features.basics.exceptions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandling {
    public static void main(String[] args) {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        exceptionHandling.checkedExceptionExample();
        exceptionHandling.unCheckedExceptionExample();
    }

    //Compile time
    void checkedExceptionExample(){
        File file = new File("E://file.txt");
        try (FileReader fr = new FileReader(file)) {
        }catch (IOException e){
            System.out.println("Checked Exception Encountered - "+ e.getMessage());
        }
    }

    //Run time
    void unCheckedExceptionExample(){
        int[] arr = {1,2,3,4,5};
        for(int i = 0; i < 6; i++){
            try {
                int x = arr[i];
            }catch (Exception e){
                System.out.println("UnChecked Exception Encountered - "+ e.getMessage());
            }
        }
    }

    /*
        Errors, beyond programmer control.
        ex: Stack overflow error, out of memory.
        JVM cannot recover from errors
     */

}
