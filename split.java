package javaclass;

	public class split {

		public static void main(String[] args) {
	
		        String[] temp1 = MyString1.split("ab#12#453", "#");
		        for (String s : temp1) {
		            System.out.println(s);
		        }

		        String[] temp2 = MyString1.split("a?b?gf#e", "[?#]");
		        for (String s : temp2) {
		            System.out.println(s);
		        }

		    }
		}