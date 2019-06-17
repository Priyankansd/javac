package javaclass;

public class TestLetterGrader {
			
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//test if there are two valid arguments, create the object
			//if not give right message and exit
			if (args.length < 2) {
				System.out.println("USAGE: java TestLetterGrader <input_file_name> <output_file_name>");
				System.exit(1);
			}
			
			LetterGrader letterGrader = new LetterGrader(args[0], args[1]); //LetterGrader is the main class
			//args[0] has input file name
			//args[1] has output file name
			
			letterGrader.readScore(); //reads score and stores the data in member variables
			letterGrader.calcLetterGrade(); //determines letter grade and stores information
			letterGrader.printGrade(); //writes the grade in output file
			letterGrader.displayAverages(); //displays the average in console
			letterGrader.doCleanUp(); //use it to close files and other resources
			
		}

	}

