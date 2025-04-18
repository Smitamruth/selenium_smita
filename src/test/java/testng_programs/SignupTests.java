package testng_programs;

import org.testng.annotations.Test;

/*Login -- under Sanity.
Signup -- under Regression.
Payment -- under Sanity, Regression(Functional).*/

public class SignupTests {

	@Test(priority = 1, groups = {"regression"})
	void signUpByEmail() {
	System.out.println("signUp by email");	
	}
	
	@Test(priority = 2, groups = {"regression"})
	void signUpByOTP() {
	System.out.println("signUp by otp");	
	}
	
	@Test(priority = 3, groups = {"regression"})
	void signUpByFacebook() {
	System.out.println("signUp by fb");	
	}
	
}
