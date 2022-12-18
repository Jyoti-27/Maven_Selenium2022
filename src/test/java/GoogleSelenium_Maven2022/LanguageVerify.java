package GoogleSelenium_Maven2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.lowagie.text.List;

public class LanguageVerify{
	static String homepath = System.getProperty("user.dir");
	static WebDriver driver;
		
		
		public static void main(String[] args) throws InterruptedException {
			// launchBrowser2("chrome");

			System.setProperty("webdriver.chrome.driver", homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");
			WebDriver driver = new ChromeDriver();

			driver.get("https://www.google.co.in");
			// driver.navigate().to("https://mail.google.co.in");
			driver.manage().window().maximize();
			System.out.println("Google Browser is launched successfully");

			Thread.sleep(2000);

		//WebElement dropdown = driver.findElement(By.id("SIvCob"));
		//WebElement dropdown= driver.findElement(By.cssSelector("div[id='SIvCob']"));
		
			
	    WebElement dropdown1 = driver.findElement(By.xpath("//div[contains(@id,'SIvCob')]"));
		dropdown1.click();
		Select select1 = new Select(dropdown1);// create object for Select class
		select1.selectByIndex(7);
		
		WebElement dropdown2 = driver.findElement(By.xpath("//div[contains(@id,'SIvCob')]"));
		dropdown2.click();
		Select select2 = new Select(dropdown2);// create object for Select class
		select2.selectByValue("English");  
		
		
	/*	select.selectByIndex(1);
		select.selectByIndex(1);/html/body/div[1]/div[4]/div/div/a[1]
		select.selectByIndex(2);/html/body/div[1]/div[4]/div/div/a[6]
		select.selectByIndex(3);
		select.selectByIndex(4);
		select.selectByIndex(5);
		select.selectByIndex(6);
		select.selectByIndex(7);
		select.selectByIndex(8);
		select.selectByIndex(9);    */
		//select.selectByValue("English");
		
	}

}
