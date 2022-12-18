package testNG_Learning;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDemo {
	// @test= denotes test(test case) as Denoted for test case for a test
	// @BefoeMethod = It run before every test
	// @AfterMethod = It run after every test
	// @BefoeTest = It will run before test tag from testing.xml
	// @AfterTest = It will run after test tag from testing.xml
	// @BefoeClass = It will run once per class and before test
	// @AfterClass = It will run once per class and after test
	// @BeforeSuite = Once per suite execution and will run at start
	// @AfterSuite = Once per suite execution and will run at end

	@BeforeSuite // suit level
	public void beforeSuite() {
		System.out.println("I am in Before Suite");
	}

	@AfterSuite // suit level
	public void afterSuite() {
		System.out.println("I am in After Suite");
	}

	@BeforeTest // suit level
	public void beforeTest() {
		System.out.println("I am in Before Test");
	}

	@BeforeClass // class level
	public void beforeClass() {
		System.out.println("I am in Before Class");
	}

	@AfterTest // suit level
	public void afterTest() {
		System.out.println("I am in After Test");
	}

	@BeforeMethod
	public void befoeMethod() {
		System.out.println("I am in Before Method");
	}

	@Test(priority = 1, enabled = true)

	public void test1() {
		System.out.println("I am in test1");

	}

	@Test(priority = 0)
	@Parameters({ "userid", "password" })

	public void test2(String user, String pass) {
		System.out.println("I am in test2");
		System.out.println("userid is - " + user);
		System.out.println("password is - " + pass);

	}

	@Test(priority = 0) // if there is on same priority then output comes on alphabetical order

	public void test4() {
		System.out.println("I am in test4");

	}

	@Test(priority = 2, enabled = true, dependsOnMethods = { "test1", "test4" })

	public void test3() {
		System.out.println("I am in test3");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am in After Method");
	}

	@AfterClass // class level
	public void afterClass() {
		System.out.println("I am in After Class");
	}

}
