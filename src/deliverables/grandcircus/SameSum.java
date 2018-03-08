package deliverables.grandcircus;

import java.util.Scanner;

public class SameSum {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int input1;
		int input2;
		int numberOfDigits;
		
		
		//prompts and scanner inputs
		System.out.println("Please enter an integer:");
		input1 = scnr.nextInt();
		numberOfDigits = String.valueOf(input1).length();
		
		System.out.println("Please enter a second integer:");
		input2 = scnr.nextInt();
		
		//check for same number of digits
		while (numberOfDigits != String.valueOf(input2).length()) {
			System.out.println("Your first integer is " + input1 +". Please enter a second integer with the same number of digits:");
			input2 = scnr.nextInt();
		}
		
		System.out.println(compareDigits(input1, input2));
	}
	
	//method to compare and check 
	public static boolean compareDigits (int number1, int number2) {
		return true;
	}
	
}
