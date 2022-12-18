package selenium_Learning;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {

	// Selenium Waits
	// 1. Implicit wait
	// 2. Explicit wait
	// 3. Fluent wait

	static String homepath = System.getProperty("user.dir");

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");

		
		
		// 1. Implicit wait
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://stqatools.com/demo/index.php");
		WebElement webtablelink = driver.findElement(By.linkText("WebTable"));
		webtablelink.click();

		
		
		// 2. Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("table"))));
		System.out.println(driver.findElement(By.tagName("table")).getText());

		List<WebElement> menus = driver.findElements(By.id("navbarDropdownPortfolio"));
		menus.get(2).click();
		// driver.findElement(By.linkText("Drag & Drop")).click();
		driver.findElement(By.linkText("Date Picker")).click();

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@placeholder='Date']"))));

		driver.findElement(By.xpath("//input[@placeholder='Date']")).click();

		
		
		// 3. Fluent wait
		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

	}

}
