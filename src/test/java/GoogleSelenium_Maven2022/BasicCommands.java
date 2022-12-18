package GoogleSelenium_Maven2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicCommands {

	public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\chromedriver6.exe");
		WebDriver driver=new ChromeDriver();
		
		
		
		// Browser
		driver.manage().window().maximize();
		
		driver.get("https://stqatools.com/demo/");
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getPageSource());
		
		//driver.quit();
		
		
		// Navigation
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		
		
		driver.navigate().to("https://www.google.com/");
		
		
		// WebElement
		
		WebElement search=driver.findElement(By.name("q"));
		System.out.println(search.getLocation());
		System.out.println(search.getSize());
		System.out.println(search.isDisplayed());
		search.sendKeys("Samsung");
		search.submit();	
		
	}

}
