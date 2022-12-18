package selenium_Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\chromedriver6.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://stqatools.com/demo/index.php");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement webtablelink = driver.findElement(By.linkText("WebTable"));
		webtablelink.click();

		WebElement switchToLink = driver.findElement(By.cssSelector("#navbarDropdownPortfolio"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", switchToLink); // driver downgrade

		Thread.sleep(2000);

		driver.findElement(By.linkText("Demo Test")).click();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // scroll down to bottom
		Thread.sleep(2000);

		js.executeScript("window.scrollTo(0,-3000)"); // scroll up by pixel
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.id("emailid"));
		js.executeScript("arguments[0].scrollIntoView();", element); // scroll referring to WebElement
		Thread.sleep(2000);

		// js.executeScript("window.scrollTo(0,50)"); // scroll down by pixel
		Thread.sleep(2000);

		js.executeScript("history.go(0)"); // refreshing page

		System.out.println(js.executeScript("return document.title;").toString());
	}

}
