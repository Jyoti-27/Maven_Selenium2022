package GoogleSelenium_Maven2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GoogleSearchOperation {
	static String homepath = System.getProperty("user.dir");
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		System.out.println("Google Browser is launched successfully");

		Thread.sleep(1000);

		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Amitabh Bachchan");
		
		Thread.sleep(1000);

		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'UUbT9')]"));
		//List<WebElement> list = driver.findElements(By.className("UUbT9"));
		System.out.println(list.size());

		for (int i = 0; i<list.size(); i++) {
			String listitem = list.get(i).getText();
			if (listitem.contains("amitabh bachchan birthday"))    
			{
				list.get(i).click();
				break;
			}     

		}    
		
		                                             
		
		
		
		
		
/*	
		WebElement element1 = driver.findElement(By.name("q"));      //UUbT9
		//WebElement element1 = driver.findElement(By.className("gLFyf gsfi"));
		element1.sendKeys("Abdul Kalam");
		
		Thread.sleep(1000);

		List<WebElement> list1 = driver.findElements(By.xpath("//div[contains(@class,'aajZCb')]"));
		System.out.println(list1.size());

		for (int i = 0; i<list1.size(); i++) {
			String listitem1 = list1.get(i).getText();
			if (listitem1.contains("Abdul Kalam"))    
			{
				list1.get(i).click();
				break;
			}     

		}        */        
		
		
  } 

}




/*
 * driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
 * driver.findElement(By.name("btnK")).click();
 * driver.manage().window().maximize();
 * 
 * 
 * 
 * @FindBy(xpath="//input[contains(@class,'gNO89b')]") WebElement GoogleSearch;
 * UUbT9
 * 
 * 
 * 
 * static String homepath = System.getProperty("user.dir"); static WebDriver
 * driver;
 * 
 * public static void main(String[] args) throws InterruptedException { //
 * launchBrowser2("chrome");
 * 
 * System.setProperty("webdriver.chrome.driver", homepath +
 * "\\src\\test\\resources\\drivers\\chromedriver.exe"); WebDriver driver = new
 * ChromeDriver();
 * 
 * driver.get("https://www.google.co.in"); //
 * driver.navigate().to("https://mail.google.co.in");
 * driver.manage().window().maximize();
 * System.out.println("Google Browser is launched successfully");
 * 
 * Thread.sleep(2000);
 * 
 * 
 * 
 * System.setProperty("webdriver.chrome.driver",
 * "C:\\selenium-java-2.35.0\\chromedriver_win32_2.2\\chromedriver.exe");
 * 
 * WebDriver driver = new ChromeDriver(); driver.get("http://www.google.com");
 * WebElement element = driver.findElement(By.name("q"));
 * element.sendKeys("Cheese!"); element.submit();
 * 
 * 
 * 
 * 
 */