package selenium_Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {
	static WebDriver driver;

	public static void main(String[] args) {
		launchBrowser("chrome");
	}
		
	public static void launchBrowser(String browser) {
		
		if (browser.equalsIgnoreCase("chrome"))    {
			
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\chromedriver6.exe");
		//WebDriver driver=new ChromeDriver();
		//ChromeDriver driver1=new ChromeDriver();
		
		driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        
		}   else if (browser.equalsIgnoreCase("edge"))    {
        
    	System.setProperty("webdriver.edge.driver", "C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\msedgedriver.exe");
		//WebDriver driver=new EdgeDriver();
    	//EdgeDriver driver2=new EdgeDriver();
    	 
    	 driver=new EdgeDriver();
    	 driver.get("https://www.google.com/");
    	 
		}   else if (browser.equalsIgnoreCase("Firefox"))    {
        
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
       //FirefoxDriver driver3=new FirefoxDriver();
        
        driver=new FirefoxDriver();
        driver.get("https://www.google.com/");
        
		}
		driver.close();
        

	}

}
