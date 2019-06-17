package javaclass;

import java.util.Scanner;

public class HomeWork {
	
	public static void randomNo() {
		int[] counts = new int[10]; // Array of ten integers

			for (int i = 1; i <= 100; i++) {
			counts[(int) (Math.random() * 10)]++;
		}

		System.out.println("Count for each number between 0 and 9:");
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + "s: " + counts[i]);
		}

	}

	public static int indexOfSmallestElement(double[] array) {
		if (array.length <= 1)
			return 0;

		double min = array[0];
		int minimumIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				minimumIndex = i;
			}
		}
		return minimumIndex;
	}

	public static void reverse(int[] list) {
		int temp;
		for (int i = 0, j = list.length - 1; i < list.length / 2; i++, j--) {
			temp = list[i];
			list[i] = list[j];
			list[j] = temp;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] number = new double[10]; // Create an array of length ten
         randomNo();
		// Prompt the user to enter ten numbers
		System.out.println("Enter ten numbers: ");
		for (int i = 0; i < number.length; i++)
			number[i] = input.nextDouble();

		// Display the smallest value
		System.out.println("The minimum number is " + number[indexOfSmallestElement(number)] + " index "
				+ indexOfSmallestElement(number));
		//Scanner input = new Scanner(System.in); // Create a Scanner
		int[] numbers = new int[10]; // Create an array of length ten

		// Prompt the user to enter ten numbers
		System.out.println("Enter ten numbers: ");
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = input.nextInt();

		// Invoke the method to reverse the numbers
		reverse(numbers);

		// Display the numbers
		for (int no : numbers) {
			System.out.println(no + " ");
		}
		
	}

}