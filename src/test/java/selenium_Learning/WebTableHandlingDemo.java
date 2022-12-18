package selenium_Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandlingDemo {
	
	//table access - table
	//row access - tr
	//column access - td(th-headers)
	
	static String homepath=System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", homepath+"\\src\\test\\resources\\drivers\\chromedriver6.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://stqatools.com/demo/WebTable.php");
	    
	    WebElement table=driver.findElement(By.tagName("table"));
	    List<WebElement> rows=table.findElements(By.tagName("tr"));
	    System.out.println("Row size is-"+rows.size());
	    for(WebElement row:rows)  {
	    	List<WebElement> headers=row.findElements(By.tagName("th"));
	    	  for(WebElement header:headers)  {
	    		  System.out.println(header.getText());
	    	  }
	    	  List<WebElement> columns=row.findElements(By.tagName("td"));
	    	  System.out.println(columns.size());
	    	  for(WebElement column:columns)  {	    		  
	    	       System.out.println(column.getText());
	    	  }
	    	
	    }
	    
	    
	    
	    // Condition based WebTable handling
	    System.out.println("Row size is-"+rows.size());
	    for(WebElement row:rows)  {
	    	List<WebElement> deletebtns=row.findElements(By.xpath("//button[contains(@class,'delete')]"));
	    	List<WebElement> columns=row.findElements(By.tagName("td"));
	    	for(int i=0;i<columns.size();i++)  {
	    		String value=columns.get(i).getText();
	    		if (value.equalsIgnoreCase("Rahul"))  {
	    			 deletebtns.get(i).click();
	    			 Thread.sleep(2000);
	    			 driver.findElement(By.xpath("//button[@id='del']")).click();
	    			 break;
	    		}
	    			
	    		}
	    	Thread.sleep(2000);
	    	}
	    	
	  	    
	}

}
