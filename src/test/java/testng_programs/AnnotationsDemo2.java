package testng_programs;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//write a Test case to 

	// 1) login -- @BeforeClass -- login executed only once.
	// 2) Search -- @Test
	// 3) Adv Search  -- @Test
	// 4) Logout -- @AfterClass -- logout executed only once.


public class AnnotationsDemo2 {

	@BeforeClass
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
	 
	@AfterClass
	 void logout() {
		 System.out.println("This is Logout.. ");
	 }

	
	
}
