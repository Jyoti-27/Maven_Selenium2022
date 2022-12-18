package GoogleSelenium_Maven2022;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserOpenClose {
	static String homepath=System.getProperty("user.dir");
	static WebDriver driver;
	
	public static void main(String[] args)  {
		launchBrowser1("chrome");
		
	}
	
	
	public static void launchBrowser1(String browser) {
	
		switch (browser) {
		
				
		
        case "chrome":
			
			System.setProperty("webdriver.chrome.driver", homepath+"\\src\\test\\resources\\drivers\\chromedriver6.exe");
			
			driver=new ChromeDriver();
			//System.out.println(driver.getTitle());
						
			break;
			
			
	    
	    case "edge":
			
	    	System.setProperty("webdriver.edge.driver", homepath+"\\src\\test\\resources\\drivers\\msedgedriver.exe");
		    
			driver = new EdgeDriver();
			
			break;
		
	
		case "Firefox":
			
			System.setProperty("webdriver.gecko.driver", homepath+"\\src\\test\\resources\\drivers\\geckodriver.exe");
		    
			 driver=new FirefoxDriver();
	    	 
			 break;
			 
			 
		}
			 
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		//driver.close();
		driver.quit();
		    
		    
			
		}
	    
	   
	}



