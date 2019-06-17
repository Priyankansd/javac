package javaclass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MidtermHintAB {

	public  int getUserChoice(Scanner readInput) {
		int inputInt;
		do {
			System.out.print("Enter your choice between 1 and 5" + " only: ");

			try {

				inputInt = readInput.nextInt();

				if (inputInt >= 1 && inputInt <= 5) {
					break;
				} else {
					System.out.println("You have not entered" + " a number between 1 and 5. Try again.");
					continue;

				}
			} catch (final InputMismatchException e) {
				System.out.println("You have entered an invalid" + " choice. Try again.");
				readInput.nextLine();
			}
		} while (true);
		return inputInt;

	}

	public void getTwoFloats(float[] myFloats, Scanner readInput) {
		do {
			System.out.print("Enter two floats separated by a " + "space: ");

			try {

				myFloats[0] = readInput.nextFloat();
				myFloats[1] = readInput.nextFloat();
				break;

			} catch (final InputMismatchException e) {
				System.out.println("You have entered an invalid " + "input. Try again.");
				readInput.nextLine();

				continue;
			}
		} while (true);
	}

	public static void main(String[] args) {
		
		 Scanner rI = new Scanner(System.in);
		 MidtermHintAB Ab=new MidtermHintAB();
		 
		 int userChoice;
			System.out.println("\nWelcome to Bineet Sharma's calculator program " +
			"program\n\n"); 
			userChoice = Ab.getUserChoice(rI);
			System.out.printf("\nYou entered valid choice %d\n",
			userChoice);
			System.out.println("Thank you for giving your choice"); 
		   
			float [] myFloats = new float[2];
			System.out.println("\nWelcome to bonus get two floats "+
			"program\n\n");
			Ab.getTwoFloats(myFloats, rI); 
			System.out.printf("You entered %5.2f and %5.2f "+
			"successfully!\n", myFloats[0], myFloats[1]);
			System.out.println("Thank you for giving two floats"); rI.close();

	}

}
