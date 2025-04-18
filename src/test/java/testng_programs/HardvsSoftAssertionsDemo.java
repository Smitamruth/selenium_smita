package testng_programs;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardvsSoftAssertionsDemo {

	@Test
	void test_hard_assertion() {
		System.out.println("Testing..");
		System.out.println("Testing..");
		
		Assert.assertEquals(1, 1); 		// If assertion passes, next stmts will execute. Otherwise No.
		Assert.assertEquals(1, 2);
		
		System.out.println("Testing..");
		System.out.println("Testing..");
		
	}
	
	
	@Test
	void test_soft_assertion() {
		System.out.println("Testing..");
		System.out.println("Testing..");
		
		SoftAssert sa = new SoftAssert(); // Hard Assert class can be directly accessed as its static 
											//but Soft Assert class cannot be accessed directly. 
		
		sa.assertEquals(1, 2); 		// Soft Assertions always pass by default. For that you have to put AssertAll method.
		
		
		System.out.println("Testing..");
		System.out.println("Testing..");
		
		sa.assertAll();   //using this, right validation is done. 
	}
	
}
