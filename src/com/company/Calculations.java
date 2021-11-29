package com.company;

public class Calculations {
	public static String addition(String num1, String num2) {
		
		//Get the length of the strings
		int length1 = num1.length();
		int length2 = num2.length();
		
		
	}
	
	//Adds an amount of 0 to the beginning of the string
	private static String expandString(String string, int amount) {
		StringBuilder stringBuilder = new StringBuilder(string);
		
		//Loop through and add 0 to the beginning of the string
		for (int i = 0; i < amount; i++) {
			stringBuilder.insert(0, "0");
		}
		
		return string;
	}
	
	public static String subtraction(String num1, String num2) {
	
	}
}
