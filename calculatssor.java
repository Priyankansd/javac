package javaclass;

import java.util.Scanner;

public class calculatssor {

	public static void main(String args[]) {
		float a, b, res;
		char choice, ch;
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Priyanka's Handy Calculator");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Exit");
		System.out.println("What would you like to do? ");
		do {
			choice = scan.next().charAt(0);
			switch (choice) {
			case '1':
				System.out.print("Please enter two floats to add, Seperated by a space :   ");
				a = scan.nextFloat();
				b = scan.nextFloat();
				res = a + b;
				System.out.print("Result of adding  " + a + " and  " + b + " is " + res);
				break;
			case '2':
				System.out.print("Please enter two floats to Subtract, Seperated by a space :  ");
				a = scan.nextFloat();
				b = scan.nextFloat();
				res = a - b;
				System.out.print("Result of Subtracting  " + a + " and  " + b + " is " + res);
				break;
			case '3':
				System.out.println("Please enter two floats to multiply, Seperated by a space : ");
				a = scan.nextFloat();
				b = scan.nextFloat();
				res = a * b;
				System.out.println("Result of multiplying  " + a + " and " + b + " is " + res);
				System.out.println("Press enter key to continue ...");
				break;
			case '4':
				System.out.print("Please enter two floats to divide, Seperated by a space :  ");
				a = scan.nextFloat();
				b = scan.nextFloat();
				while (b == 0) {
					System.out.println("you cant divide by zero please re-enter both floats");
					a = scan.nextFloat();
					b = scan.nextFloat();
				}
				res = a / b;
				System.out.println("Result of dividing  " + a + " and " + b + " is " + res);
				break;
			case '5':
				System.out.println("Thank you for using Priyanka's Handy Calculator ");
				System.exit(0);
				break;
			default:
				System.out.println("you have entered a invalid Choice,please re-enter your choice: ");
				break;
			}

		} while (choice != 5);
	}
}
