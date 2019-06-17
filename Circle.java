package javaclass;

public class Circle {
		
		public static void main(String[] args) {
			
			Stock stock = new Stock("ORCL", "Oracle Corporation");
			stock.previousClosingPrice = 34.5;
			stock.currentPrice = 36.56;

			System.out.println("\nStock name : " + stock.previousClosingPrice);
			System.out.println("Stock symbol : " + stock.currentPrice);
			System.out.printf("Price-change percentage : %.2f%%", 
				stock.getChangePercent());
		}

}
