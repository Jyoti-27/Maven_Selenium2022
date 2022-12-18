package testNG_Learning;

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

public class ParallelTestDemo {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static String homepath = System.getProperty("user.dir");

	public static WebDriver getDriver() {

		return driver.get();
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");
		driver.set(new ChromeDriver());
		getDriver().get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test(enabled = true)
//@Parameters({"userid" , "password"})
	public void Login() {
		System.out.println("Login" + Thread.currentThread().getId());
		System.out.println("Login" + Thread.currentThread().getName());
		WebElement userid = getDriver().findElement(By.id("txtUsername"));
		WebElement password = getDriver().findElement(By.id("txtPassword"));
		userid.sendKeys("Admin");
		password.sendKeys("admin123");
		WebElement login_btn = getDriver().findElement(By.id("btnLogin"));
		login_btn.click();
		WebElement dashboard_menu = getDriver().findElement(By.id("menu_dashboard_index"));
		Assert.assertEquals(dashboard_menu.getText(), "Dashboard"); // here passed condition
		// Assert.assertTrue(dashboard_menu.getText().equalsIgnoreCase
		// ("Dashboard2"));// if want to check by boolean...here condition failed
		// Assert.assertTrue(dashboard_menu.getText().equalsIgnoreCase ("Dashboard2"),
		// "Text mismatch");
		System.out.println("Test is executed");

	}

// Assign Leave
	@Test(enabled = true)
	public void assignLeave() throws InterruptedException {
		System.out.println("AssignLeave" + Thread.currentThread().getId());
		System.out.println("AssignLeave" + Thread.currentThread().getName());
		WebElement userid = getDriver().findElement(By.id("txtUsername"));
		WebElement password = getDriver().findElement(By.id("txtPassword"));
		userid.sendKeys("Admin");
		password.sendKeys("admin123");
		WebElement login_btn = getDriver().findElement(By.id("btnLogin"));
		login_btn.click();
		WebElement dashboard_menu = getDriver().findElement(By.id("menu_dashboard_index"));
		// Assert.assertEquals(dashboard_menu.getText(), "Dashboard2");
		Assert.assertTrue(dashboard_menu.getText().equalsIgnoreCase("Dashboard"), " text mismatch");
		Thread.sleep(2000);
		WebElement assign_leave = getDriver().findElement(By.className("quickLaunge"));
		assign_leave.click();
		Thread.sleep(1000);
		
		// Employee Name
		WebElement emp_name = getDriver().findElement(By.id("assignleave_txtEmployee_empName"));
		emp_name.sendKeys("Or");
		Thread.sleep(1000);
		List<WebElement> result_list = getDriver().findElements(By.xpath("//div[@class='ac_results'][2]/ul/li"));
		for (WebElement result : result_list) {
			if (result.getText().equalsIgnoreCase("Orange Test")) {
				result.click();
				break;
			}
		}
		
		// Leave Type
		WebElement dropdown_leavetype = getDriver().findElement(By.id("assignleave_txtLeaveType"));
		dropdown_leavetype.click();
		Select select = new Select(dropdown_leavetype);
		select.selectByVisibleText("US - Vacation");
		;
		Thread.sleep(2000);
		
		// Duration
		WebElement balance = getDriver().findElement(By.id("assignleave_leaveBalance"));
		System.out.println("Leave balance is" + balance.getText());
		
		// From Date
		WebElement fromDate = getDriver().findElement(By.id("assignleave_txtFromDate"));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", fromDate);
		fromDate.clear();
		fromDate.sendKeys("2022-07-19");
		Thread.sleep(1000);
		
		// To date
		WebElement toDate = getDriver().findElement(By.id("assignleave_txtToDate"));
		js.executeScript("arguments[0].click();", toDate);
		toDate.clear();
		toDate.sendKeys("2022-07-20");
		Thread.sleep(1000);
		
		// Comment
		WebElement comment = getDriver().findElement(By.id("assignleave_txtComment"));
		comment.sendKeys("planned leave");
		System.out.println(comment.getText());
		Thread.sleep(1000);

		WebElement assign_btn = getDriver().findElement(By.id("assignBtn"));
		js.executeScript("arguments[0].click();", assign_btn);
		
		// assign_btn.click();
		Thread.sleep(1000);
		WebElement popup = getDriver().findElement(By.id("leaveBalanceConfirm"));
		Assert.assertTrue(popup.isDisplayed(), "Pop is not displayed");
		WebElement ok_btn = getDriver().findElement(By.id("confirmOkButton"));
		ok_btn.click();

	}

	@AfterMethod
	public void afterTest() {
		getDriver().quit();
		driver.remove();
	}

}
