
// Facebook Login Page

package selenium_Learning;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Chandana\\\\eclipse-workspace\\\\Maven_Selenium2022\\\\src\\\\test\\\\resources\\\\drivers\\chromedriver6.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com");

		// id
		driver.findElement(By.id("email")).sendKeys("sabaradJyo@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.id("pass")).sendKeys("password");
		Thread.sleep(2000);

		// tagName
		List<WebElement> inputlist = driver.findElements(By.tagName("input type"));
		inputlist.get(3).sendKeys("password");
		Thread.sleep(2000);

		// className
		WebElement demoTestLink = driver.findElement(By.className("inputtext _55r1 _6luy _9npi"));
		System.out.println(demoTestLink.getText());
		Thread.sleep(2000);

		// name
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("pass");
		Thread.sleep(2000);

		// tagName
		List<WebElement> button = driver.findElements(By.tagName("button value"));
		button.get(3).sendKeys("1");
		Thread.sleep(2000);

		// className
		WebElement demoTestLink1 = driver.findElement(By.className("_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy"));
		System.out.println(demoTestLink1.getText());
		Thread.sleep(2000);

		// name
		WebElement name1 = driver.findElement(By.name("name"));
		name1.sendKeys("login");
		Thread.sleep(2000);

		// id
		driver.findElement(By.id("data-testid")).sendKeys("royal_login_button");
		Thread.sleep(2000);

		driver.findElement(By.id("id")).sendKeys("u_0_d_Zh");
		Thread.sleep(2000);

		// type
		// WebElement Submit=driver.findElement(By.cssSelector("
		// td[colspan='2']>input[type='submit']")); //parent and child relationship
		// Submit.click();

		// Thread.sleep(5000);

		// driver.findElement(By.id("u_0_b_DX")).click();
		driver.findElement(By.id("u_0_d_AX")).click();
		Thread.sleep(7000);
	}
}