package selenium_Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutocompleteSearchDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=CommonFunctions.browserLaunch();
		driver.get("https://www.irctc.co.in/nget/train");
		driver.manage().window().maximize();
		
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
		
		
		
	}

}
