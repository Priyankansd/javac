package javaclass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SOL1 {

	public static int getUserChoice(Scanner readInput){
		int inputInt;
		do { 
			System.out.print("Enter your choice between 1 and 5"+
		" only: ");
		 
		try {
		 

		inputInt = readInput.nextInt();
		// waits for user input
		if (inputInt >= 1 && inputInt <= 5) {
		break; // Got it, done
		} else {
		System.out.println("You have not entered"+
		" a number between 1 and 5. Try again.");
		continue;
		// continue looping as it is wrong number
		 
		}
		} catch (final InputMismatchException e) { System.out.println("You have entered an invalid"+
		" choice. Try again."); readInput.nextLine(); // discard non-int input continue;
		// keep looping until you found right onee
		}
		} while (true);
		return inputInt;
		//if you are here you got the correct choice
		}

		public static void main(String[] args) {
		Scanner rI = new Scanner(System.in);
		int userChoice;
		System.out.println("\nWelcome to get user choice " +
		"program\n\n"); userChoice = getUserChoice(rI);
		System.out.printf("\nYou entered valid choice %d\n",
		userChoice); System.out.println("Thank you for giving your choice"); rI.close();
		}
		}
		 

