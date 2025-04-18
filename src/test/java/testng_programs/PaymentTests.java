package testng_programs;

import org.testng.annotations.Test;

/*Login -- under Sanity.
Signup -- under Regression.
Payment -- under Sanity, Regression(Functional).*/

public class PaymentTests {
	@Test(priority = 1, groups = {"sanity", "regression","functional"})
	void payByCard() {
	System.out.println("pay By Card");	
	}
	
	@Test(priority = 2, groups = {"sanity", "regression","functional"})
	void payByCOD() {
	System.out.println("pay By COD");	
	}
	
	@Test(priority = 3, groups = {"sanity", "regression","functional"})
	void payByUPI() {
	System.out.println("pay By UPI");	
	}
	
}
