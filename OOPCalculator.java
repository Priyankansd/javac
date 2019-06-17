package javaclass;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OOPCalculator {

	private Scanner scan;
	private float firstFloat;
	private float secondFloat;
	private String menuChoice;
	private int menuChoiceInt;
	private HashMap<String, Integer> possibleChoices;
	private HashMap<Integer, String> supportedOperations;

	OOPCalculator() {
		this.scan = new Scanner(System.in);
		initializeMaps();
	}

	private void initializeMaps() {
		this.possibleChoices = new HashMap<String, Integer>();
		this.possibleChoices.put("a", 1);
		this.possibleChoices.put("A", 1);
		this.possibleChoices.put("1", 1);
		this.possibleChoices.put("s", 2);
		this.possibleChoices.put("S", 2);
		this.possibleChoices.put("2", 2);
		this.possibleChoices.put("m", 3);
		this.possibleChoices.put("M", 3);
		this.possibleChoices.put("3", 3);
		this.possibleChoices.put("d", 4);
		this.possibleChoices.put("D", 4);
		this.possibleChoices.put("4", 4);
		this.possibleChoices.put("x", 5);
		this.possibleChoices.put("X", 5);
		this.possibleChoices.put("5", 5);

		this.supportedOperations = new HashMap<Integer, String>();
		this.supportedOperations.put(1, "add");
		this.supportedOperations.put(2, "substract");
		this.supportedOperations.put(3, "multiply");
		this.supportedOperations.put(4, "divide");

	}

	/**
	 * Methods captures user choice for mathematical calculation
	 * 
	 * @param readInput
	 * @return return users choice
	 */
	public int askCalcChoice() {
		System.out.println("Welcome to Sweta's Handy Calculator\n");
		System.out.println("\t1. Addition");
		System.out.println("\t2. Subtraction");
		System.out.println("\t3. Multiplication");
		System.out.println("\t4. Division");
		System.out.println("\t5. Exit\n");
		System.out.print("What would you like to do? ");
		do {
			try {
				this.menuChoice = this.scan.nextLine();
				if (this.possibleChoices.keySet().contains(this.menuChoice)) {
					break;
				} else {
					System.out.print("You have entered an invalid choice, please re-retry your choice:");
					continue;
				}
			} catch (final InputMismatchException e) {
				System.out.print("You have entered an invalid choice, please re-retry your choice:");
				continue;
			}
		} while (true);
		this.menuChoiceInt = this.possibleChoices.get(this.menuChoice);
		return this.menuChoiceInt;
	}

	/**
	 * Method reads user input and save in an array
	 * 
	 * @param myFloats
	 * @param readInput
	 */
	public void askTwoValues() {
		do {
			System.out.print("Please enter two floats to " + this.supportedOperations.get(this.menuChoiceInt)
					+ ", separated by a space:");

			try {
				this.firstFloat = this.scan.nextFloat();
				this.secondFloat = this.scan.nextFloat();
				this.scan.nextLine();
				break;

			} catch (final InputMismatchException e) {
				System.out.println("Invalid input, please retry");
				this.scan.nextLine();
				continue;

			}

		} while (true);

	}

	/**
	 * Method adds two numbers and returns the sum
	 * 
	 * @param num1
	 * @param num2
	 * @return return sum of two numbers, if overflow or underflow situation
	 *         occurs it return 0.0
	 */
	public float addition() {
		float a = this.firstFloat;
		float b = this.secondFloat;
		float sum = a + b;
		// checking overflow or underflow condition
		if (b != sum - a) {
			System.out.println(
					"Error: Overflow or underflow of number encounter: Please try with entering numbers in range  ");
			sum = 0;
		}
		return sum;

	}

	/**
	 * Method subtracts num2 from num1 and returns the result
	 * 
	 * @param num1
	 * @param num2
	 * @return return subtraction of two numbers.
	 */
	public float subtraction() {
		return this.firstFloat - this.secondFloat;

	}

	/**
	 * Method multiply num2 and num1, and returns the result
	 * 
	 * @param num1
	 * @param num2
	 * @return return multiplication of two numbers.if overflow or underflow
	 *         situation occurs it return 0.0
	 */
	public float multiplication() {
		float mul = this.firstFloat * this.secondFloat;
		// checking overflow or underflow condition
		if (this.secondFloat != (mul / this.firstFloat)) {
			System.out.println(
					"Error: Overflow or underflow of number encounter: Please try with entering numbers in range  ");
			mul = 0;
		}
		return mul;

	}

	/**
	 * Method divide num1 from num2 and returns the result
	 * 
	 * @param num1
	 * @param num2
	 * @return return division of two numbers.
	 */
	public float division() {
		float div = this.firstFloat / this.secondFloat;
		return div;

	}

	/**
	 * Method call the respective function for performing operation requested by
	 * the user
	 * 
	 * @param choice
	 * @param readInput
	 * @return
	 */
	public void calculate() {
		if (this.menuChoiceInt == 1) {
			System.out.printf("Result of addition of %.2f and %.2f is %.2f\n", this.firstFloat, this.secondFloat,
					addition());
		} else if (this.menuChoiceInt == 2) {
			System.out.printf("Result of subtraction of %.2f and %.2f is %.2f\n", this.firstFloat, this.secondFloat,
					subtraction());
		} else if (this.menuChoiceInt == 3) {
			System.out.printf("Result of multiplying %.2f and %.2f is %.2f\n", this.firstFloat, this.secondFloat,
					multiplication());
		} else {
			// here checking if divisor is zero or not
			while (true) {
				if (this.secondFloat != 0)
					break;
				System.out.println("Can not divide a number by 0, please retry");
				askTwoValues();
			}
			System.out.printf("Result of division of %.2f and %.2f is %.2f\n", this.firstFloat, this.secondFloat,
					division());
		}
	}

	public void promptEnterKey() {
		System.out.println("Press enter key to continue.....");
		this.scan = new Scanner(System.in);
		scan.nextLine();
	}

	public void displayResults() {
		calculate();
		promptEnterKey();

	}

	public void displayBye() {
		System.out.println("Thank you for using Sweta's Handy Calculator ");
		System.exit(0);

	}

}
