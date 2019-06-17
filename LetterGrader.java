package javaclass;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LetterGrader {
	private String inputFileName;
	private String outputFileName;
	private ArrayList <String> studentName;
	private ArrayList <Double> quiz1;
	private ArrayList <Double> quiz2;
	private ArrayList <Double> quiz3;
	private ArrayList <Double> quiz4;
	private ArrayList <Double> midterm1;
	private ArrayList <Double> midterm2;
	private ArrayList <Double> finalExam;
	private ArrayList <String> grade;
	
	//2 command line arguments: first argument is the input (student names and scores), second argument is output of disk file
	//program will grab input/out
	
	LetterGrader(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
		//creating objects with ArrayList		
		studentName = new ArrayList<String>();
		quiz1 = new ArrayList<Double>();
		quiz2 = new ArrayList<Double>();
		quiz3 = new ArrayList<Double>();
		quiz4 = new ArrayList<Double>();
		midterm1 = new ArrayList<Double>();
		midterm2 = new ArrayList<Double>();
		finalExam = new ArrayList<Double>();
		grade = new ArrayList<String>();
	}
	
	//read scores and stores the data in member variables
	public void readScore() {
		//call method to process command line arguments
		File inputFile = new File(inputFileName);
		if (!inputFile.exists()) {
			System.out.println("Input File " + inputFileName + " does not exist.");
			System.exit(2);
		}
		try {
			//create input files
			Scanner input = new Scanner(inputFile);
			//while loop to go through all student in input file and storing data in member variables
			while (input.hasNextLine()) {
				String line = input.nextLine();
				
				String[] studentInfo = line.split(",");
				
				//storing data for one student in member variables
				studentName.add(studentInfo[0]);
				quiz1.add(Double.parseDouble(studentInfo[1]));
				quiz2.add(Double.parseDouble(studentInfo[2]));
				quiz3.add(Double.parseDouble(studentInfo[3]));
				quiz4.add(Double.parseDouble(studentInfo[4]));
				midterm1.add(Double.parseDouble(studentInfo[5]));
				midterm2.add(Double.parseDouble(studentInfo[6]));
				finalExam.add(Double.parseDouble(studentInfo[7]));
			}//one student done
			input.close(); //done with them, close it
		}
		//Error Handling
		catch (IOException e) {
			System.out.println("Error reading from input file: " + e);
		}
	} 
	
	//calculation, determining letter grade and storing information
	public void calcLetterGrade() {
		int i;
		double totalScore;
		//for loop to go through even students scores and calculate them accordingly
		for (i = 0; i < studentName.size(); i ++) {
			totalScore = quiz1.get(i) * 0.10 + quiz2.get(i) * 0.10 + quiz3.get(i) * 0.10 + quiz4.get(i) * 0.10 + midterm1.get(i) * 0.20 + midterm2.get(i) * 0.15 + finalExam.get(i) * 0.25;
			
			//If condition to categorize totalScores into letter grades
			if (totalScore >= 90) {
				grade.add("A");
			}
			else if (totalScore >= 80) {
				grade.add("B");
			}
			else if (totalScore >= 70) {
				grade.add("C");
			}
			else if (totalScore >= 60) {
				grade.add("D");
			}
			else if (totalScore >= 50) {
				grade.add("F");
			}
		}
	}
	
	//sort students by Name
	private void sortByName() {
		int i;
		int j;
		for (i = 0; i < studentName.size(); i ++) {
			for (j = i + 1; j < studentName.size(); j ++) {
				if (studentName.get(i).compareTo(studentName.get(j)) > 0) {
					String temp = studentName.get(i);
					studentName.set(i, studentName.get(j));
					studentName.set(j,  temp);
					
					temp = grade.get(i);
					grade.set(i, grade.get(j));
					grade.set(j, temp);
				}	
			}
		}
	}
	
	//method writes the grade in output file will have grade information of all students from read file
	public void printGrade() {
		sortByName();
		File outputFile = new File(outputFileName);
		try {
			//Create output file
			PrintWriter output = new PrintWriter(outputFile);
			//Write the data in output file
			output.printf("Letter grade for %d student given in '%s' file is: ", studentName.size(), inputFileName);
			output.println(""); //one student done
			
			for (int i = 0; i < studentName.size(); i ++) {
				output.println(studentName.get(i) + ":\t" + grade.get(i));
			}
			output.close(); //done with it, close it
		}
		catch (IOException e) {
			System.out.println("Error writing on outputfile" + e);
		}
	}
	
	//calculate the averages
	private double[] calcListStatistics(ArrayList<Double> list) {
		double sum = 0;
		double minimum = list.get(0);
		double maximum = list.get(0);
		double [] response = new double[3];
		
		
		for (int i = 0; i < list.size(); i ++) {
			//find average
			sum += list.get(i);
			
			//find minimum
			if (list.get(i) < minimum) {
				minimum = list.get(i);
			}
			
			//find maximum
			if (list.get(i) > maximum) {
				maximum = list.get(i);
			}
		}
		double average = sum/list.size();
		

		
		//return average, minimum, maximum
		response[0] = average;
		response[1] = minimum;
		response[2] = maximum;
		
		return response;		
	}
	
	//display the average in console
	public void displayAverages() {
		double[] quiz1Stats = calcListStatistics(quiz1);
		double[] quiz2Stats = calcListStatistics(quiz2);
		double[] quiz3Stats = calcListStatistics(quiz3);
		double[] quiz4Stats = calcListStatistics(quiz4);
		double[] midterm1Stats = calcListStatistics(midterm1);
		double[] midterm2Stats = calcListStatistics(midterm2);
		double[] finalExamStats = calcListStatistics(finalExam);
		

		
		System.out.println("\nLetter grade has been calculated for students listed in" + " input file " + inputFileName + " and written to output file " + outputFileName);
		System.out.println("\nHere is the class averages: ");
		System.out.println("\n\t Q1\t\t Q2\t\t Q33\t\t Q4\t\t mid1\t\t mid2\t\t final\n");
		
		//Line up the data with the chart titles, do extra work with formatting
		
		System.out.printf("Average: " + "%.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f", quiz1Stats[0], quiz2Stats[0], quiz3Stats[0], quiz4Stats[0], midterm1Stats[0], midterm2Stats[0],finalExamStats[0]);
		System.out.printf("\n\n");
		System.out.printf("Minimum: " + "%.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f", quiz1Stats[1], quiz2Stats[1], quiz3Stats[1], quiz4Stats[1], midterm1Stats[1], midterm2Stats[1],finalExamStats[1]);
		System.out.printf("\n\n");
		System.out.printf("Maximum: " + "%.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f\t\t %.2f", quiz1Stats[2], quiz2Stats[2], quiz3Stats[2], quiz4Stats[2], midterm1Stats[2], midterm2Stats[2],finalExamStats[2]);
		System.out.printf("\n\n");
		
		//Bottom chunk of code does not line up the data as it could be different length
		/*System.out.println("Average: "+quiz1Stats[0]+"\t"+quiz2Stats[0]+"\t"+quiz3Stats[0]+"\t"+quiz4Stats[0]+
				"\t"+midterm1Stats[0]+"\t"+midterm2Stats[0]+"\t"+finalExamStats[0]);*/
		
		/*System.out.println("Minimum: "+quiz1Stats[1]+"\t"+quiz2Stats[1]+"\t"+quiz3Stats[1]+"\t"+quiz4Stats[1]+
				"\t"+midterm1Stats[1]+"\t"+midterm2Stats[1]+"\t"+finalExamStats[1]);*/
		
		/*System.out.println("Maximum: "+quiz1Stats[2]+"\t"+quiz2Stats[2]+"\t"+quiz3Stats[2]+"\t"+quiz4Stats[2]+
				"\t"+midterm1Stats[2]+"\t"+midterm2Stats[2]+"\t"+finalExamStats[2]);*/
	}
	
	//close files and other resources
	public void doCleanUp() {
		//Exiting after enter key is pressed + exception handling in respective functions
		Scanner input = new Scanner(System.in);
		System.out.println("\nPress enter key to continue...");
		input.nextLine();
		input.close();
	}
	
}

