package testng_programs;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class FirstTestNgProgram {

		// Advantages:
			// 1) Test cases and test suites.
			// 2) Grouping of test cases.
			// 3) Prioritize.
			// 4) Parameterization.
			// 5) Parallel Testing.
			// 6) Reports.
		
		//TestNG configuration - Testng can be installed via Eclipse Marketplace or via pom.xml dependency.
		//Add TestNG Library via Java Build Path.
		
	// @Test is the replacement for main method.
	//If many methods have @Test annotation, then TestNG executes tests in alphabetical order.
	//If priority is given as @Test(priority = num)  like (priority = 1/2/3) 
		//then tests are executed in that order given irrespective of the order of the methods.
	//Priority numbers can be anything, not necessarily consecutive like 10, 25, 400.
	//If a test as no specified priority, then the default priority is 0.
	// If two methods have same priority, then it will consider alphabetical order.

	//If the -ve numbers are given as priority, then it takes in tis order -2, -1, 0, 1, 2 etc etc.
	// If @Test annotation is removed for one method, then the particular method is not run.
	// TestNG will execute the methods only if it has annotation.
	// Class cannot be run or executed if there is no associated TestNG annotations.
	
	// Can execute the test cases using xml file. ==> Able to run multiple test cases ++ Can see the test report generated automatically inside test-output folder.
	// Can be generated automatically by right click on test class(for single test case) or Right click on package(for multiple test cases)
		// or be generated manually by creating testng xml file.
	
	//Can install XML plug-in called Eclipse XML Editors and Tools -- via eclipse marketplace.
	
	//XML file is also called Suite.
	// In manual testing, we have Test Suites ==> Test cases ==> Test steps.
	// Likewise in testNG, we have XML File ==> Classes ==> Test methods.
	
	// Example;
	// Open app ==> Login ==> Logout.
	@Test
	void openApp() {
		System.out.println("Opening app..");
	}
	
	@Test
	void login() {
		System.out.println("Login to app..");
	}

	@Test
	void logout() {
		System.out.println("Logged out from app..");
	}
	
}
