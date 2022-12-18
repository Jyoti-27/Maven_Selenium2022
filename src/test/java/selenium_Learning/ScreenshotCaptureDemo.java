package selenium_Learning; // using import org.apache.commons.io.*;-//imported it into pom.xml

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenshotCaptureDemo {

	// TakeScreenshot

	// steps wise
	// element wise/specific (selenium-4)
	// on failure

	static String homepath = System.getProperty("user.dir");
	static String folderpath;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://stqatools.com/demo/index.php");
		driver.manage().window().maximize();
		getScreenshot(driver, "test1");
		WebElement heading = driver.findElement(By.xpath("//b[text()='Student Registration Form']"));

		getScreenshot(heading, "header2"); // webelement capture

		JavascriptExecutor js = (JavascriptExecutor) driver; // driver downgrade
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // scroll down to bottom

		getScreenshot(heading, "test2");

	}

	public static void getScreenshot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver; // downcasting
		File src = ts.getScreenshotAs(OutputType.FILE); // to get screenshot
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH_mm");
		String formattedDate = dateformat.format(date);
		System.out.println(formattedDate);
		folderpath = homepath + "\\src\\test\\resources\\Screenshot\\" + formattedDate;
		File target = new File(folderpath + "\\" + screenshotname + ".png");
		// Files.copy(src, target);
		FileUtils.copyFile(src, target);

	}

	public static void getScreenshot(WebElement element, String screenshotname) throws IOException {

		File headerScrn = element.getScreenshotAs(OutputType.FILE); // to get screenshot
		File target = new File(folderpath + "\\" + screenshotname + ".png");
		FileUtils.copyFile(headerScrn, target);
	}

}
