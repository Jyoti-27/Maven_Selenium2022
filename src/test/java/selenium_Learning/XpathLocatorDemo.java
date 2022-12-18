package selenium_Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocatorDemo {

	// Xpath- 1) Absolute- from root node
	// 2) Relative- from current node
	// browser plugin or inbuild option for finding xpath

	// a) Basic Xpath- //tagname[@atrribute_name='attributeValue']
	// b) using containts - //tagname[contains(@attribute,constantvalue)]
	// c) using text= //tagname[text()=’Text of the Web Element’]
	// d) Using Start-with = //tagname[starts-with(@attribute,value)]
	// e) using Logical Operators: OR -XPath=//tagname[@attribute1=value1 or
	// @attribute2=value2]
	// AND -XPath=//tagname[@attribute1=value1 and @attribute2=value2]
	// f) XPath using Child-//tagname[@attribute=’value’]//child::tagname
	// g) using Parent- //tagname[@attribute=’value’]/parent::tagname

	// h) Preceding-Sibling-
	// //tagname[@attribute=’value’]//preceding-sibling::tagname
	// i) Follwing-Following-Sibling --
	// //tagname[@attribute=’value’]//following-sibiling::tagname
	// j) chain xpath- //tagname1[@attribute1=value1]//tagname2[@attribute2=value2]

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\chromedriver6.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://stqatools.com/demo/");
		driver.manage().window().maximize();

		// id
		WebElement studentname = driver.findElement(By.xpath("//input[@id='studentname']"));
		studentname.sendKeys("Rahul");

		driver.findElement(By.xpath("//input[contains(@name,'father')]")).sendKeys("Ramesh");

		WebElement demoTestLink = driver.findElement(By.xpath("//a[text()= 'Demo Test']"));
		String text = demoTestLink.getText();
		System.out.println(text);

		WebElement postalAddress = driver.findElement(By.xpath("//input[starts-with(@name,'paddress')]"));
		postalAddress.sendKeys("ABC, XYZ. maha-411065");

		driver.findElement(By.xpath("//input[@name='personaladdress'  or  @id='personaladdress']"))
				.sendKeys("ABC, XYZ. maha-411065");

		driver.findElement(By.xpath("//input[@name='pincode'  and  @id='pincode']")).sendKeys("411065");

		driver.findElement(By.xpath("//td//child::input[@id='emailid']")).sendKeys("test@gamil.com");

		WebElement reset = driver.findElement(By.xpath("//input[@type='reset']/parent::td"));
		reset.click();

		WebElement submit_btn = driver.findElement(By.xpath("//td[@colspan='2']//child::input"));
		submit_btn.click();

	}

}
