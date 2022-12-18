package testNG_Learning;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonFunctions {
	public static WebDriver driver;
	public static String homepath = System.getProperty("user.dir");

	public static WebDriver browserLaunch(String browsername) {

		switch (browsername) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");
			driver = new ChromeDriver();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", homepath + "\\src\\test\\resources\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		case "Firefox":
			System.setProperty("webdriver.gecko.driver", homepath + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver",
					homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");
			driver = new ChromeDriver();
			break;

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

}
