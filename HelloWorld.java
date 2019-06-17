package javaclass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloWorld {
	

	public static int getusercode(Scanner r1) {
		System.out.println("\n\nWelcome to sorting program\n\n\t1. Title\n\t2. Rank\n\t3. Date\n\t4. Stars\n\t5 .Likes\n\n");
		System.out.println("Enter your choice between 1 and 5 only");
		int userChoice;
		do {
			try{
			 userChoice = r1.nextInt();
				if(userChoice>=1 && userChoice<=5) {
					break;
				}else
				{
					System.out.println("you have entered a invalid no Try again with proper choice");
					continue;
				}
					
			} catch (final InputMismatchException e) {
				System.out.println("you have entered a invalid choice Try again");
				r1.nextLine();
			continue;
			}
		} while (true);
		

		System.out.println("you entered volid choice " +userChoice );
		return userChoice;


	}

public static void main(String[] args) {
Scanner r1 = new Scanner(System.in);
int userChoice ;
userChoice=getusercode(r1);
System.out.println(userChoice);
System.out.println("thank you for giving your choice");
r1.close();
}
}