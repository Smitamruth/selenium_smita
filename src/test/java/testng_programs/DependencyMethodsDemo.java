package testng_programs;

import org.testng.Assert;
import org.testng.annotations.Test;

/*1) Open App
 * 2) Login
 * 3) Search
 * 4) Adv search
 * 5) logout*/


//testng by default executes all methods even if open or login fails. That should not happen.
 	// That is why we use dependencies.

public class DependencyMethodsDemo {

	@Test(priority = 1)
	void openApp() {
		System.out.println("Opening app..");
		Assert.assertTrue(false);
	}
	
	@Test(priority = 2, dependsOnMethods = {"openApp"})
	void login() {
		System.out.println("Login to app..");
		Assert.assertTrue(true);
	}
	
	@Test(priority = 3, dependsOnMethods = {"login"})
	 void search() {
		 System.out.println("This is Search.. ");
		 Assert.assertTrue(true);
	 }
	 
	@Test(priority = 4, dependsOnMethods = {"login", "search"})
	 void advSearch() {
		 System.out.println("This is Advanced Search.. ");
		 Assert.assertTrue(true);
	 }

	@Test(priority = 5, dependsOnMethods = {"login"})
	void logout() {
		System.out.println("Logged out from app..");
		Assert.assertTrue(true);
	}
	
}
