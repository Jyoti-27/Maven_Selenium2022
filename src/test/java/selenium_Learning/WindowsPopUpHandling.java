package selenium_Learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class WindowsPopUpHandling {
	static String homepath = System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException, FindFailed {
		System.setProperty("webdriver.chrome.driver", homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");

		// 1. Implicit wait
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		/*
		 * driver.get("https://stqatools.com/demo/index.php");
		 * 
		 * List<WebElement> menus=driver.findElements(By.id("navbarDropdownPortfolio"));
		 * Thread.sleep(2000); JavascriptExecutor js=(JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", menus.get(3));
		 * 
		 * 
		 * WebElement fileUpload=driver.findElement(By.linkText("fileUpload"));
		 * fileUpload.click(); WebElement
		 * Choosefile=driver.findElement(By.id("fileUpload")); Choosefile.sendKeys();
		 */

		driver.get("https://www.zamzar.com/");
		driver.findElement(By.cssSelector("button[class='btn btn-lg btn-block px-2']")).click();

		Screen screen = new Screen();
		Pattern pattern = new Pattern(homepath + "\\src\\test\\SikuliObject\\FileUpload.png");
		screen.type(pattern, homepath + "\\src\\test\\resources\\Screenshot\\screenshot1.png");
		

		Pattern pattern1 = new Pattern(homepath + "\\src\\test\\SikuliObject\\open.png");
		screen.click(pattern1);
	}

}
