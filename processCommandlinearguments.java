package javaclass;

public class processCommandlinearguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length < 1) {
			System.out.println("usage processcommandlinearguments input filename output file name");
		} else {

			System.out.println("Input will be read from:" + args[0]);
			System.out.println("output will be read from:" + args[1]);
			String str = "priyanka, 39, 894, 399, 300";
			String[] myScr = str.split(", ");
			int i = 0;
			for (String S : myScr) {
				System.out.println("Element " + i++ + " : " + S);
			}

		}
	}
}