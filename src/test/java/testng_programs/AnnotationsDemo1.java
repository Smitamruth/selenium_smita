package testng_programs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// @Test -- makes a method as a Test Method. || Only Test methods are actual tests that needs validation. || 
			// Others will not be considered tests. They are just executed, but not displayed. 
			// Results will only be displayed by test methods.


// According to the XML file, Test is a collection of classes.

/*<suite name="mySuite">
	<test name="mytests">
		<classes>
			<class name="testng_programs.OrangeHRM"></class>
			<class name="testng_programs.FirstTestNgProgram"></class>
		</classes>
	</test>
	
	<test name="mytests2">
		<classes>
			<class name="testng_programs.ABC"></class>
			<class name="testng_programs.XYZ"></class>
		</classes>
	</test>
</suite>*/

// @BeforeMethod -- 
// @AfterMethod --

// @BeforeClass -- 
// @AfterClass --

// @BeforeTest -- 
// @AfterTest -- 

// @BeforeSuite -- 
// @AfterSuite -- 

// write a Test case to 

	// 1) login -- Repeat login multiple times before every test method i.e., executing search -- @BeforeMethod
	// 2) Search -- @Test
	// 3) Logout -- Repeat login multiple times after every test method i.e., executing search -- @AfterMethod
	// 4) Login
	// 5) Adv Search  -- @Test
	// 6) Logout

public class AnnotationsDemo1 {
	
	@BeforeMethod
	 void login() {
		 System.out.println("This is Login.. ");
	 }
	 
	@Test(priority = 1)
	 void search() {
		 System.out.println("This is Search.. ");
	 }
	 
	@Test(priority = 2)
	 void advSearch() {
		 System.out.println("This is Advanced Search.. ");
	 }
	 
	@AfterMethod
	 void logout() {
		 System.out.println("This is Logout.. ");
	 }

}
