package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv in två tal");
		String number1 = input.next();
		String number2 = input.next();
		
		String sum = Calculations.addition(number1, number2);
		String difference = Calculations.subtraction(number1, number2);
		
		System.out.println(sum);
		System.out.println(difference);
    }
}
