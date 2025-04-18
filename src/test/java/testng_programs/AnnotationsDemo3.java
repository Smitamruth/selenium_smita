package testng_programs;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo3 {

	@BeforeSuite
	 void bs() {
		 System.out.println("This is Before Suite.. ");
	 }
	
	@BeforeTest
	 void bt() {
		 System.out.println("This is Before Test.. ");
	 }
	
	@BeforeClass
	 void bc() {
		 System.out.println("This is Before Class.. ");
	 }
	 
	@BeforeMethod
	 void bm() {
		 System.out.println("This is Before Method.. ");
	 }
	 
	@Test(priority = 1)
	 void tm1() {
		 System.out.println("This is method 1.. ");
	 }
	
	@Test(priority = 2)
	 void tm2() {
		 System.out.println("This is method 2.. ");
	 }
	
	
	@AfterMethod
	 void am() {
		 System.out.println("This is After Method.. ");
	 }
	 
	@AfterClass
	 void ac() {
		 System.out.println("This is AFter class.. ");  
	 }
	
	@AfterTest
	 void at() {
		 System.out.println("This is After test.. ");  
	 }
	
	@AfterSuite
	 void as() {
		 System.out.println("This is After suite.. ");  
	 }

}
