package selenium_Learning;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC_Demo2 {

	static String homepath = System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.irctc.co.in/nget/train");
		driver.manage().window().maximize();

		Thread.sleep(2000);

		try {
			driver.switchTo().alert().accept();

		} // try
		catch (NoAlertPresentException Ex) {
			System.out.println("No alert present");
		}

		List<WebElement> ok = driver.findElements(By.cssSelector("button[type='submit']"));
		ok.get(0).click();
		Thread.sleep(2000);

		
		
		// Automcomplete search handle

		WebElement searchbox = driver.findElement(By.xpath("//*[@id='origin']/span/input"));
		searchbox.click();
		searchbox.sendKeys("Bomb");
		Thread.sleep(1000);

		List<WebElement> searchResult = driver.findElements(By.xpath("//li[@role='option']/span"));
		System.out.println(searchResult.size());
		for (WebElement result : searchResult) {
			if (result.getText().equalsIgnoreCase("BOMBAY SION - SIN")) {
				result.click();
				break;
			}
		}

		
		
		// calender module handling
		
		driver.findElement(By.cssSelector("#jDate")).click();
		Thread.sleep(2000);

		WebElement monthYear = driver.findElement(By.cssSelector(".ui-datepicker-title.ng-tns-c59-10"));
		System.out.println("Month and Year-" + monthYear.getText());

		while (!monthYear.getText().equalsIgnoreCase("July2022")) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",driver.findElement(By.cssSelector(".ui-datepicker-next-icon pi pi-chevron-right ng-tns-c59-10")));
			System.out.println(monthYear.getText());
		}

		
		
		WebElement table = driver.findElement(By.cssSelector(".ui-datepicker-calendar.ng-tns-c59-10"));
		List<WebElement> date = table.findElements(By.xpath("//tbody[@class='ng-tns-c59-10']/tr/td[not(contains(@class,'other-month'))]"));
		for (WebElement selectdate : date) {
			if (selectdate.getText().equals("20")) {
				selectdate.click();
				break;
			}
		}

		
		
		WebElement to = driver.findElement(By.xpath("//*[@id='destination']/span/input"));
		to.click();
		to.sendKeys("KAL");
		Thread.sleep(2000);
		
		
		List<WebElement> searchresult1 = driver.findElements(By.xpath("//li[@role='option']/span"));
		for (WebElement element : searchresult1) {
			if (element.getText().equalsIgnoreCase("KALYAN JN - KYN")) {
				element.click();
				break;
			}
		}

		
		WebElement general = driver.findElement(By.cssSelector("span[class*='ng-tns-c66-12']"));
		general.click();
		Thread.sleep(2000);
		selectfromResult(driver, "LADIES");

		
		WebElement allclasses = driver.findElement(By.cssSelector(".ng-tns-c66-11.ui-dropdown-label.ui-inputtext.ui-corner-all.ng-star-inserted"));
		allclasses.click();
		Thread.sleep(2000);
		selectfromResult(driver, "AC 2 Tier (2A)");

		
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']//following-sibling::label"));
		for (WebElement element : checkbox) {
			element.click();
			
			
		List<WebElement> confirmation = driver.findElements(By.xpath("//div[contains(@class,'ui-dialog-titlebar')]"));
			if (confirmation.size() > 0) {
				driver.findElement(By.xpath("//span[text()='OK']")).click();
			}
		}

		
		WebElement searchbtn = driver.findElement(By.cssSelector("button[type='submit']"));
		searchbtn.click();
		Thread.sleep(4000);
		driver.quit();

	}

	
	public static void selectfromResult(WebDriver driver, String string) {
		List<WebElement> searchresult1 = driver.findElements(By.xpath("//li[@role='option']/span"));
		for (WebElement element : searchresult1) {
			if (element.getText().equalsIgnoreCase(string)) {
				element.click();
				break;
			}
		}

	}

}