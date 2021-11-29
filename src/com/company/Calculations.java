package com.company;

public class Calculations {
	public static String addition(String num1, String num2) {
		
		//Get the length of the strings
		int length1 = num1.length();
		int length2 = num2.length();
		
		//Check if a number is shorter than the other
		if(length1 < length2) {
			num1 = expandString(num1, (length2-length1));
			length1 = num1.length();
		}
		else if(length1 > length2) {
			num2 = expandString(num2, (length1-length2));
		}
		
		//Add a string for the sum and create a stringBuilder with it
		String sum = "";
		int overflow = 0;
		StringBuilder stringBuilder = new StringBuilder(sum);
		
		//Loop through all the chars of the strings from right to left and add them together
		for (int i = length1; i > 0; i--) {
			int char1 = Character.getNumericValue(num1.charAt(i-1));
			int char2 = Character.getNumericValue(num2.charAt(i-1));
			
			int output = char1 + char2 + overflow;
			if(output >= 10) {
				output = output % 10;
				overflow = 1;
			}
			else {
				overflow = 0;
			}
			
			stringBuilder.insert(0, output);
		}
		
		return stringBuilder.toString();
	}
	
	//Adds an amount of 0 to the beginning of the string
	private static String expandString(String string, int amount) {
		StringBuilder stringBuilder = new StringBuilder(string);
		
		//Loop through and add 0 to the beginning of the string
		for (int i = 0; i < amount; i++) {
			stringBuilder.insert(0, "0");
		}
		
		return stringBuilder.toString();
	}
	
	public static String subtraction(String num1, String num2) {
	
	}
}
