package deliverables.grandcircus;

/* Tim Pieniazek - Deliverable One */

import java.util.Scanner;

public class SameSum {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int input1;
		int input2;
		String digits1;
		String digits2;
		int digitSum;
		
		/* Prompts user to enter two integers and converts the absolute value to String
		 * to work with the digits as characters. */
		
		// TODO: Add exceptions for not entering an integer
		System.out.printf("Let's compare two integers with the same number of digits! %n"
				+ "Each corresponding digit will sum to the same total (True/False): %n");
		System.out.println("Please enter the first integer:");
		/* Sends error message if scanner input is not an integer. */
		while (!scnr.hasNextInt()) {
			System.out.println("Error. Please enter an integer.");
			scnr.nextLine();
		}
		input1 = scnr.nextInt();
		digits1 = Integer.toString(Math.abs(input1));
		
		System.out.println("Please enter the second integer:");
		while (!scnr.hasNextInt()) {
			System.out.println("Error. Please enter an integer.");
			scnr.nextLine();
		}
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
		
		/* Pull out first digits as char, converts to int and then sums */
		digitSum = Character.getNumericValue(digits1.charAt(0)) + Character.getNumericValue(digits2.charAt(0));
		
		System.out.println(digitSum);
		
		/* Output statements to capitalize "True" and "False" */
		if (compareDigits(digits1, digits2, digitSum) == false) {
			System.out.printf("False%nEach digit does not sum to the same number.");
		}
		else {
			System.out.printf("True%nEach digit sums to " + digitSum + ".");
		};
	}
	
	/* Method takes in two integers as strings, already checked for the same length */
	public static boolean compareDigits (String number1, String number2, int checkSum) {
		int nextSum;
		int i;
		boolean sameSum = true;
		
		/* Starting in the second position, sums the two digits. */
		for (i = 1; i < number1.length(); ++i) {
			nextSum = Character.getNumericValue(number1.charAt(i)) + Character.getNumericValue(number2.charAt(i));
			System.out.println(nextSum);
			/* If not equal, method returns false and breaks loop. */
			if (nextSum != checkSum) {
				sameSum = false;
				break;
			}
		}
		return sameSum;
	}
	
}
