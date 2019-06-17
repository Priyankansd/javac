package javaclass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ddd {tUserChoice(Scanner readInput) {
		int choice;
		System.out.println("Welcome to Priyanka's Handy Calculator");
		System.out.print("\t1. Addition");
		System.out.println("\t2. Subtraction");
		System.out.println("\t3. Multiplication");
		System.out.println("\t4. Division");
		System.out.println("\t5. Exit");
		System.out.println("What would you like to do? ");
		do {
			try {
				choice = readInput.nextInt();
				if (choice >= 1 && choice <= 5) {
					readInput.nextLine();
					break;
				} else {
					System.out.print("You have entered an invalid choice, please re-retry your choice:");
					readInput.nextLine();
					continue;
				}
			} catch (final InputMismatchException e) {
				System.out.println("You have entered an invalid choice, please re-retry your choice:");
				readInput.nextLine();
				continue;
			}
		} while (true);
		return choice;
	}

	public static void getTwoFloats(float[] myFloats, Scanner readInput, String choiceName) {
		do {
			System.out.println("Please enter two floats to " + choiceName + " separated by a space:");

			try {
				myFloats[0] = readInput.nextFloat();
				myFloats[1] = readInput.nextFloat();
				readInput.nextLine();
				break;

			} catch (final InputMismatchException e) {
				System.out.println("Invalid input, please retry");
				readInput.nextLine();
				continue;

			}

		} while (true);

	}

	public static float addition(float num1, float num2) {
		return num1 + num2;

	}

	public static float subtraction(float num1, float num2) {
		return num1 - num2;

	}

	public static float multiplication(float num1, float num2) {
		return num1 * num2;

	}

	public static float division(float num1, float num2) {
		float div = num1 / num2;
		return div;

	}

	public static void calculate(int choice, Scanner readInput) {
		float[] operand = new float[2];

		if (choice == 1) {
			getTwoFloats(operand, readInput, "add");
			System.out.printf("Result of addition of is" + addition(operand[0], operand[1]));
		} else if (choice == 2) {
			getTwoFloats(operand, readInput, "subtract");
			System.out.printf("Result of subtraction of is" + subtraction(operand[0], operand[1]));
		} else if (choice == 3) {
			getTwoFloats(operand, readInput, "multipy");
			System.out.printf("Result of multiplying is" + multiplication(operand[0], operand[1]));
		} else if (choice == 4) {
			getTwoFloats(operand, readInput, "divide");
			while (operand[1] == 0) {
				System.out.println("you cant divide by zero please re-enter both floats");
				getTwoFloats(operand, readInput, "divide");
			}
			System.out.printf("Result of division of is" + division(operand[0], operand[1]));
		}
	}

	public static void userEnterKey() {
		System.out.println("Press enter key to continue.....");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int userChoice = getUserChoice(scan);
			if (userChoice == 5) {
				System.out.println("Thank you for using Priyanka's Handy Calculator ");
				System.exit(0);
			}
			System.out.println();
			calculate(userChoice, scan);
			System.out.println();
			userEnterKey();
		}

	}

}
