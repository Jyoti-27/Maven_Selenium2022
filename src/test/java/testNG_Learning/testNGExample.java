package testNG_Learning;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNGExample {

	WebDriver driver;

	@BeforeMethod
	public void testSetUp() {
		driver = CommonFunctions.browserLaunch("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@Test(enabled = true)
	@Parameters({ "userid", "password" })
	public void Login(String user, String pass) {
		WebElement userid = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		userid.sendKeys(user);
		password.sendKeys(pass);
		WebElement login_btn = driver.findElement(By.id("btnLogin"));
		login_btn.click();
		WebElement dashboard_menu = driver.findElement(By.id("menu_dashboard_index"));
		Assert.assertEquals(dashboard_menu.getText(), "Dashboard"); // here passed condition
		// Assert.assertTrue(dashboard_menu.getText().equalsIgnoreCase
		// ("Dashboard2"));// if want to check by boolean...here condition failed
		// Assert.assertTrue(dashboard_menu.getText().equalsIgnoreCase ("Dashboard2"),
		// "Text mismatch");
		System.out.println("Test is executed");

	}

	
	// Login
	//@Test(enabled = false)
	@Test(enabled = true)

	public void Login1() {
		WebElement userid = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		userid.sendKeys("Admin");
		password.sendKeys("admin123");
		WebElement login_btn = driver.findElement(By.id("btnLogin"));
		login_btn.click();
		WebElement dashboard_menu = driver.findElement(By.id("menu_dashboard_index"));
		Assert.assertEquals(dashboard_menu.getText(), "Dashboard"); // here passed condition
		// Assert.assertTrue(dashboard_menu.getText().equalsIgnoreCase
		// ("Dashboard2"));// if want to check by boolean...here condition failed
		// Assert.assertTrue(dashboard_menu.getText().equalsIgnoreCase ("Dashboard2"),
		// "Text mismatch");
		System.out.println("Test is executed");

	}

	
	// Assign Leave
	//@Test(enabled = false)
	@Test(enabled = true)

	public void assignLeave() throws InterruptedException {
		WebElement userid = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		userid.sendKeys("Admin");
		password.sendKeys("admin123");
		WebElement login_btn = driver.findElement(By.id("btnLogin"));
		login_btn.click();
		WebElement dashboard_menu = driver.findElement(By.id("menu_dashboard_index"));
		// Assert.assertEquals(dashboard_menu.getText(), "Dashboard2");
		Assert.assertTrue(dashboard_menu.getText().equalsIgnoreCase("Dashboard"), " text mismatch");
		Thread.sleep(2000);
		WebElement assign_leave = driver.findElement(By.className("quickLaunge"));
		assign_leave.click();
		Thread.sleep(1000);
		
		// Employee Name
		WebElement emp_name = driver.findElement(By.id("assignleave_txtEmployee_empName"));
		emp_name.sendKeys("Or");
		Thread.sleep(1000);
		List<WebElement> result_list = driver.findElements(By.xpath("//div[@class='ac_results'][2]/ul/li"));
		for (WebElement result : result_list) {
			if (result.getText().equalsIgnoreCase("Orange Test")) {
				result.click();
				break;
			}
		}
		
		// Leave Type
		WebElement dropdown_leavetype = driver.findElement(By.id("assignleave_txtLeaveType"));
		dropdown_leavetype.click();
		Select select = new Select(dropdown_leavetype);
		select.selectByVisibleText("US - Vacation");
		Thread.sleep(2000);
		
		// Duration
		WebElement balance = driver.findElement(By.id("assignleave_leaveBalance"));
		System.out.println("Leave balance is" + balance.getText());
		
		// From Date
		WebElement fromDate = driver.findElement(By.id("assignleave_txtFromDate"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", fromDate);
		fromDate.clear();
		fromDate.sendKeys("2022-07-19");
		Thread.sleep(1000);
		
		// To date
		WebElement toDate = driver.findElement(By.id("assignleave_txtToDate"));
		js.executeScript("arguments[0].click();", toDate);
		toDate.clear();
		toDate.sendKeys("2022-07-20");
		Thread.sleep(1000);
		
		// Comment
		WebElement comment = driver.findElement(By.id("assignleave_txtComment"));
		comment.sendKeys("planned leave");
		System.out.println(comment.getText());
		Thread.sleep(1000);

		WebElement assign_btn = driver.findElement(By.id("assignBtn"));
		js.executeScript("arguments[0].click();", assign_btn);
		// assign_btn.click();
		Thread.sleep(1000);
		
		WebElement popup = driver.findElement(By.id("leaveBalanceConfirm"));
		Assert.assertTrue(popup.isDisplayed(), "Pop is not displayed");
		WebElement ok_btn = driver.findElement(By.id("confirmOkButton"));
		ok_btn.click();

	}

	@AfterMethod
	public void testDown() {
		// driver.quit();
	}

}
