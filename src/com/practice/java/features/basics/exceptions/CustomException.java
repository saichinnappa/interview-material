package com.practice.java.features.basics.exceptions;

public class CustomException {
    public static void main(String[] args) {
        CustomException customException = new CustomException();
        try {
            customException.invokeCustomCheckedException(4);
        } catch (CustomCheckedException e){
            System.out.println("CustomCheckException Caught - " + e.getMessage());
        }

        try {
            customException.invokeCustomUnCheckedException(6);
        } catch (CustomUnCheckedException e){
            System.out.println("CustomUnCheckException caught - "+ e.getLocalizedMessage());
        }


    }

    private void invokeCustomCheckedException(int x) throws CustomCheckedException {
        if(x < 5){
            throw new CustomCheckedException("Invalid Input");
        }
    }

    private void invokeCustomUnCheckedException(int x){
        if(x > 5)
            throw new CustomUnCheckedException("Invalid Input!");
    }

}

class CustomCheckedException extends Exception{
    CustomCheckedException(String message){
        super(message);
    }
}

class CustomUnCheckedException extends RuntimeException{
    CustomUnCheckedException(String message){
        super(message);
    }
}