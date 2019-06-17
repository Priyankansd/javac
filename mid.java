package javaclass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class mid {

	public static int getUserChoice(Scanner readInput) {

		int choice;
		System.out.println("Welcome to Priyanka's Handy Calculator");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Exit");
		System.out.println("What would you like to do? ");
		do {
			try {
				choice = readInput.nextInt();

				if (choice >= 1 && choice <= 5) {
					readInput.nextLine();
					break; // Got it, done
				} else {
					System.out.println("you have entered a invalid Choice,please re-enter your choice:");
					readInput.nextLine();
					continue;
				}
			} catch (final InputMismatchException e) {
				System.out.println("You have entered an invalid" + " choice. Try again.");
				readInput.nextLine();
				continue;
			}

		} while (true);
		return choice;
	}

	public static void getTwoFloats(float [] myFloats, Scanner
			readInput,Scanner choiceName){
			do {System.out.print("Enter two floats separated by a " +
			"space: "+choiceName);
			 
			try {
			myFloats[0] = readInput.nextFloat();
			myFloats[1] = readInput.nextFloat();
			readInput.nextLine();
			break;
			 

			} catch (final InputMismatchException e) { System.out.println("You have entered an invalid "+
			"input. Try again."); readInput.nextLine();
			continue;
					}
			} while (true);
			}
}
