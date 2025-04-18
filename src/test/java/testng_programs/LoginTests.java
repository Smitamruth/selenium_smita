package testng_programs;

import org.testng.annotations.Test;

// Grouping helps to categorize tests into different classes.
	// sanity - basic functionality tests like login, sign-in etc
	// regression - retesting or reexecuting of test cases in every build
	// functional - all tests - sanity & regression etc.

// Grouping is possible only through xml.

/*Login -- under Sanity.
Signup -- under Regression.
Payment -- under Sanity, Regression(Functional).*/

	
public class LoginTests {

	@Test(priority = 1, groups = {"sanity"})
	void loginByEmail() {
	System.out.println("Login by email");	
	}
	
	@Test(priority = 2, groups = {"sanity"})
	void loginByOTP() {
	System.out.println("Login by otp");	
	}
	
	@Test(priority = 3, groups = {"sanity"})
	void loginByFacebook() {
	System.out.println("Login by fb");	
	}
	
}
