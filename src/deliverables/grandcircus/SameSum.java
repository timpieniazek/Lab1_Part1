package deliverables.grandcircus;

import java.util.Scanner;

public class SameSum {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int input1;
		int input2;
		String digits1;
		String digits2;
		
		/* Prompts user to enter two integers and converts the absolute value to String
		 * to work with the digits as characters. */
		System.out.println("Please enter an integer:");
		input1 = scnr.nextInt();
		digits1 = Integer.toString(Math.abs(input1));
		
		System.out.println("Please enter a second integer:");
		input2 = scnr.nextInt();
		digits2 = Integer.toString(Math.abs(input2));
		
		/* Compares string length to ensure the same number of digits. Prompts user for
		 * second integer until it matches the number of digits in the first integer. */
		while (digits1.length() != digits2.length()) {
			System.out.println("Your first integer is " + input1
					+ ". Please enter a second integer with the same number of digits:");
			input2 = scnr.nextInt();
			digits2 = Integer.toString(Math.abs(input2));
		}
		
		System.out.println(compareDigits(digits1, digits2));
	}
	
	/* Method takes in two integers as strings of the same length */
	public static boolean compareDigits (String number1, String number2) {
		int checkSum;
		int nextSum;
		int i;
		boolean sameSum = true;
		
		/* Sums the first digit of each integer to compare with the other digits. */
		checkSum = (int)number1.charAt(0) + (int)number2.charAt(0);
		
		/* Starting in the second position, sums the two digits. If not equal, method returns 
		 * false and breaks loop. Boolean variable is initialized as true, so if the loop completes,
		 * then each digit must sum to the same number and return true. */
		for (i = 1; i < number1.length(); ++i) {
			nextSum = (int)number1.charAt(i) + (int)number2.charAt(i);
			if (nextSum != checkSum) {
				sameSum = false;
				break;
			}
		}
		return sameSum;
	}
	
}
