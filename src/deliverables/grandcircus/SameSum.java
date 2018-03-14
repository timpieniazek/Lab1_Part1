package deliverables.grandcircus;

import java.util.Scanner;

/* Tim Pieniazek - Deliverable One */

public class SameSum {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int input1;
		int input2;
		String digits1;
		String digits2;
		int length1;
		int length2;
		int digitSum;
		
		/* App intro block */
		int i;
		for (i = 0; i < 60; ++i) {
			System.out.print("*");
		}
		System.out.printf("%nLet's compare two integers that have same number of digits! %n"
				+ "Each corresponding digit will sum to the same total, True or False: %n");
		for (i = 0; i < 60; ++i) {
			System.out.print("*");
		}
		System.out.println("");
		
		/* Prompts user to enter two integers and converts the absolute value to String
		 * to work with the digits as characters. */
		System.out.println("Please enter the first integer:");
		/* Sends error message if scanner input is not an integer. */
		while (!scnr.hasNextInt()) {
			System.out.println("Error! Please enter a valid integer:");
			scnr.nextLine();
		}
		input1 = scnr.nextInt();
		scnr.nextLine();
		digits1 = Integer.toString(Math.abs(input1));
		length1 = digits1.length();
				
		/* Do-while loop runs the prompt code until the integers are of equal length. */
		do {
			System.out.printf("Please enter the second integer of %d %s:%n", length1, pluralize(length1, "digit"));
			while (!scnr.hasNextInt()) {
				System.out.println("Error! Please enter a valid integer:");
				scnr.nextLine();
			}
			input2 = scnr.nextInt();
			digits2 = Integer.toString(Math.abs(input2));
			length2 = digits2.length();
			if (length1 != length2) {
				System.out.println("Error! Incorrect number of digits.");
				scnr.nextLine();
			}
		}
		while (length1 != length2);
		
		/* Pulls out first digits at charAt(0), converts to integer, initializes checkSum with the sum. */
		digitSum = Character.getNumericValue(digits1.charAt(0)) + Character.getNumericValue(digits2.charAt(0));
		
		/* Output statement runs the compartDigits method */
		if (compareDigits(digits1, digits2, length1, digitSum) == false) {
			System.out.printf("False%nEach digit does not sum to the same number.");
		}
		else {
			System.out.printf("True%nEach digit sums to %s.", digitSum);
		};
	}
	
	/* Method takes two integers as String, string length, and the sum of the first digits,
	 * and outputs boolean true if all other digits sum to checkSum, false if not.  */
	public static boolean compareDigits (String number1, String number2, int length, int checkSum) {
		int nextSum;
		int i;
		boolean sameSum = true;
		
		/* Starting in the second position, sums the digits. */
		for (i = 1; i < length; ++i) {
			nextSum = Character.getNumericValue(number1.charAt(i)) + Character.getNumericValue(number2.charAt(i));
			/* If not equal, method returns false and breaks loop. */
			if (nextSum != checkSum) {
				sameSum = false;
				break;
			}
		}
		return sameSum;
	}
		
	public static String pluralize(int count, String singular)
	{
	   return pluralize(count, singular, singular.concat("s"));
	}

	public static String pluralize(int count, String singular, String plural)
	{
	  return (count == 1 ? singular : plural);
	}
}
