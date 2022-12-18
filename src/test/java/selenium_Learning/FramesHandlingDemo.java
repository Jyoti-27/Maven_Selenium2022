package selenium_Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandlingDemo {
	static String homepath = System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");

		// Single Frame
		driver.switchTo().frame("frame1");
		List<WebElement> headers = driver.findElements(By.id("sampleHeading"));
		System.out.println(headers.size());
		System.out.println(headers.get(0).getText());

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement mainheader = driver.findElement(By.className("main-header"));
		System.out.println(mainheader.getText());

		driver.switchTo().frame("frame2");
		Thread.sleep(2000);
		WebElement header2 = driver.findElement(By.id("sampleHeading"));
		System.out.println(header2.getText());

		driver.switchTo().defaultContent();

		// Nested Frames
		Thread.sleep(2000);
		driver.get("https://demoqa.com/nestedframes");

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Frame size is-" + frames.size());

		WebElement frame1 = driver.findElement(By.xpath("//div[@id='frame1Wrapper']/iframe"));

		driver.switchTo().frame(frame1);
		Thread.sleep(2000);
		WebElement parentframeText = driver.findElement(By.xpath("//body[text()='Parent frame']"));
		System.out.println("Parent frame text-" + parentframeText.getText());

		WebElement frame2 = driver.findElement(By.xpath("//body[text()='Parent frame']/iframe"));
		driver.switchTo().frame(frame2);
		Thread.sleep(2000);
		WebElement childframe = driver.findElement(By.xpath("//body/p"));
		System.out.println("ChildParent frame text-" + childframe.getText());

		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		System.out.println("Parent frame text-" + parentframeText.getText());

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.quit();

	}

}
