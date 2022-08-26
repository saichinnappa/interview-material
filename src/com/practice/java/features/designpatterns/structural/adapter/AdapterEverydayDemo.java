package com.practice.java.features.designpatterns.structural.adapter;

import java.util.Arrays;
import java.util.List;

public class AdapterEverydayDemo {

	public static void main(String args[]) {
		
		Integer[] arrayOfInts = new Integer[] { 42, 43, 44 };

		//Converting legacy arrays to Lists
		List<Integer> listOfInts = Arrays.asList(arrayOfInts);
		
		System.out.println(arrayOfInts);
		
		System.out.println(listOfInts);
		
	}
}
