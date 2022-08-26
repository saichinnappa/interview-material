package com.practice.java.features.designpatterns.creational.factory;

import java.util.Calendar;

public class FactoryEverydayDemo {

	public static void main(String args []) {

		// Don't know what kind of calendar is returned
		// in this context GregorianCalendar returned (which is a concrete class)
		Calendar cal = Calendar.getInstance();
		//Calendar cal = Calendar.get
		
		System.out.println(cal);
		
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
	}
	
}
