package selenium_Learning;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;

public class KeyboardActionsDemo {
	static String homepath = System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException, FindFailed, AWTException {
		System.setProperty("webdriver.chrome.driver", homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//cite[text()='https://www.selenium.dev']")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_K);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_K);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

	}

}
