package selenium_Learning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertHandlingDemo {

	public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://stqatools.com/demo/Alerts.php");
		Thread.sleep(2000);
		
		WebElement basic_Alert=driver.findElement(By.id("jbalert"));
		basic_Alert.click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		WebElement confirm_Alert=driver.findElement(By.id("jcalert"));
		confirm_Alert.click();
		Alert alert1=driver.switchTo().alert();
		Thread.sleep(2000);
		//alert1.accept(); // for Ok switch
		alert1.dismiss(); // for cancel switch
		
		
		WebElement prompt_Alert=driver.findElement(By.id("jpalert"));
		prompt_Alert.click();
		Alert alert2=driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.sendKeys("Automation Tester");
		Thread.sleep(2000);
		alert1.accept(); // for Ok switch
		//alert1.dismiss(); // for cancel switch
		
		
		
		
		
		
		
	}

}
