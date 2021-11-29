package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv in två tal");
		String number1 = input.next();
		String number2 = input.next();
		
		String sum = addition(number1, number2);
		String difference = subtraction(number1, number2);
		
		System.out.println(sum);
		System.out.println(difference);
    }
	
	//Addition for two numbers as strings
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
		for (int i = length1-1; i >= 0; i--) {
			int char1 = Character.getNumericValue(num1.charAt(i));
			int char2 = Character.getNumericValue(num2.charAt(i));
			
			//Add the two chars and the overflow together
			int output = char1 + char2 + overflow;
			
			//Check if the int is larger than 10 if overflow is needed or not
			if(output >= 10) {
				output = output % 10;
				overflow = 1;
			}
			else {
				overflow = 0;
			}
			
			//Add the output into the string
			stringBuilder.insert(0, output);
		}
		
		//Return the string made with the stringBuilder
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
	
	//Subtraction for two numbers as a string
	// num1 needs to be bigger than num2
	public static String subtraction(String num1, String num2) {
		
		String sum = "";
		StringBuilder stringBuilder = new StringBuilder(sum);
		
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
		
		//Used if you need to load from the number to the left
		int loan = 0;
		
		//Loop through all the numbers from right to left
		for (int i = length1-1; i >= 0; i--) {
			int char1 = Character.getNumericValue(num1.charAt(i));
			int char2 = Character.getNumericValue(num2.charAt(i));
			
			//Initialize the output
			int output;
			
			//Check if the char1 is smaller than char2 and loan from the number to the left
			if(char1 < char2) {
				output = (10 + char1) - char2 - loan;
				loan = 1;
			}
			//If char1 is 0 and was loaned before, reset the loan
			else if(char1 == 0 && loan == 1) {
				output = (10 + char1) - char2 - loan;
				loan = 0;
			}
			//If not loaned before calculate the output and set loan to 0
			else {
				output = char1 - loan - char2;
				loan = 0;
			}
			
			//Add the output into the string
			stringBuilder.insert(0, output);
		}
		return stringBuilder.toString();
	}
}
