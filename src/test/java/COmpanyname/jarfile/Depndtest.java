package COmpanyname.jarfile;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Depndtest {

	@Test
	public void Sum() {
		System.out.println("Sum");
		int a=10;
		int b=20;
		assertEquals(30, a+b);
	}


}
