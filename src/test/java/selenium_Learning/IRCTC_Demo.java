package selenium_Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC_Demo {
	static String homepath=System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", homepath+"\\src\\test\\resources\\drivers\\chromedriver6.exe");
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=CommonFunctions.browserLaunch();
		
		driver.get("https://www.irctc.co.in/nget/train");
		driver.manage().window().maximize();
		//driver.switchTo().frame("test");// NosuchElementException
		
		Thread.sleep(5000);
		
		List<WebElement> ok = driver.findElements(By.cssSelector("button[type='submit']"));
		ok.get(0).click();
		Thread.sleep(2000);
		
		WebElement searchbox=driver.findElement(By.xpath("//*[@id='origin']/span/input"));
		searchbox.click();
		searchbox.sendKeys("Bomb");
		Thread.sleep(1000);
		
		List<WebElement> searchResult= driver.findElements(By.xpath("//li[@role='option']/span"));
		System.out.println(searchResult.size());
		for(WebElement result:searchResult)  {
			if(result.getText().equalsIgnoreCase("BOMBAY SION - SIN"))  {
				result.click();
				break;
				
			}
		}
			
				
		WebElement searchbox1=driver.findElement(By.id("//p-autocomplete[@id='origin']"));
		searchbox1.click();
		searchbox1.sendKeys("PUN");
		Thread.sleep(1000);
				
		//ng-tns-c58-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted
		List<WebElement> searchResult1= driver.findElements(By.xpath("ng-tns-c58-9 ui-autocomplete ui-widget"));
		System.out.println(searchResult1.size());
		for(WebElement result1:searchResult1)  {
			if(result1.getText().equalsIgnoreCase("PUNE JN - PUNE"))  {
				result1.click();
				break;
			}
		}
		
		
		//Calender module handling
		driver.findElement(By.cssSelector("#jDate")).click();
		Thread.sleep(2000);
		
		WebElement monthYear = driver.findElement(By.cssSelector(".ui-datepicker-title ng-tns-c59-10"));
		System.out.println("Month and Year-" + monthYear.getText());
		
		while (!monthYear.getText().equalsIgnoreCase("July2022")) {
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);" , driver.findElement(By.cssSelector(".ui-datepicker-next ui-corner-all ng-tns-c59-10 ng-star-inserted")));
		js.executeScript("arguments[0].click()" , driver.findElement(By.cssSelector(".ui-datepicker-next ui-corner-all ng-tns-c59-10 ng-star-inserted")));
		Thread.sleep(2000);
		System.out.println(monthYear.getText());
	}
	
	WebElement table = driver.findElement(By.cssSelector(".ui-datepicker-calendar ng-tns-c59-10"));
	List<WebElement> date = table.findElements(By.xpath("//tbody[@class='ng-tns-c59-10']/tr/td[not(contains(@class,'other-month'))]"));
	for (WebElement selectdate :date)  {
		if (selectdate.getText().equals("20"))  {
			selectdate.click();
			break;
		}
		

				
	}

  }
}
	
