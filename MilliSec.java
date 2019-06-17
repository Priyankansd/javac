package javaclass;

import java.util.Scanner;

public class MilliSec {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in); 			
			System.out.print("Enter milliseconds: ");
			long millis = scan.nextLong();

			
			System.out.println("hours-minuties-second "+ convertMillis(millis));
		}

		
		public static String convertMillis(long millis) {
						millis /= 1000;

			
			String currentMinuteAndSecond = "";
			for (int i = 0; i < 2; i++) {
				currentMinuteAndSecond = ":" + millis % 60 + currentMinuteAndSecond;
				millis /= 60;
			}
			return millis + currentMinuteAndSecond;
		}
	}
	
