package selenium_Learning;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\chromedriver6.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stqatools.com/demo/Windows.php");

		String originalWindow = driver.getWindowHandle();
		WebElement newTab = driver.findElement(By.xpath("//a[@target=\"_blank\"]//child::button"));
		newTab.click();
		Set<String> windowslist = driver.getWindowHandles();

		for (String currentwindow : windowslist) {
			if (!currentwindow.equals(originalWindow)) {
				driver.switchTo().window(currentwindow);
				Thread.sleep(2000);
				driver.close();
			}
		}

		System.out.println("New window is closed");
		driver.switchTo().window(originalWindow);
		Thread.sleep(2000);

		WebElement newWindow = driver.findElement(By.xpath("//button[text()=' Click to open new Window ']"));
		newWindow.click();
		Set<String> windowslist_1 = driver.getWindowHandles();
		for (String currentwdw : windowslist_1) {
			if (!currentwdw.equals(originalWindow)) {
				driver.switchTo().window(currentwdw);
				System.out.println("In child window");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//button[text()=' New Message Window ']")).click();
				Set<String> windowslist_2 = driver.getWindowHandles();
				for (String ongoingwdw : windowslist_2) { // Three windows as original,child,grandchild
					if (!ongoingwdw.equals(currentwdw) && !ongoingwdw.equals(originalWindow)) {
						driver.switchTo().window(ongoingwdw);
						Thread.sleep(2000);
						System.out.println("In inner window");
						driver.close();

					}
				}

				driver.switchTo().window(currentwdw);
				System.out.println("Switched back to child window");
				Thread.sleep(2000);
				driver.close();
			}
		}

		driver.switchTo().window(originalWindow);
		System.out.println("Switched to original window");

	}

}
