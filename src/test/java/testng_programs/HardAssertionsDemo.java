package testng_programs;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

// Assertions - are validation points.
	//2 types of assertions - 
		// 1) Hard assertions - assertions accessed through Assertion class  
		// 2) Soft Assertions 

public class HardAssertionsDemo {

	String exp_title = "Open Cart";
	String act_title = "Open Shop";

	// Here even though the test method fails, the result shows TEST PASSED coz it
	// wont
	// take the result of the correctness of test method execution, it only takes if
	// the test executed or not.

	@Test
	void testGetTitle1() {
		if (exp_title.equals(act_title)) {
			System.out.println("Test passed");
		} else
			System.out.println("Failed");
	}

	// Assertion - can make failure of test methods according to the correctness of
	// the method execution.
	@Test
	void testGetTitle2() {
		Assert.assertEquals(exp_title, act_title, "Passed");
	}

	@Test
	void testGetTitle3() {
		if (exp_title.equals(act_title)) {
			System.out.println("Test passed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Failed");
			Assert.assertTrue(false);
		}
	}

}
