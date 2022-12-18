package selenium_Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo {

	// findelement - to locate single/first webelemnt
	// findelements- to locate multiple Webelments (List Of Weblement)
	// Locators- way of locating/finding webelments
	// 1) id
	// 2) name
	// 3) className
	// 4) tagName
	// 5) linkText
	// 6) partialLinkText
	// 7) CSSSelector
	// a) id attribute - tagname#Idvalue or #idvalue (# is for id)
	// b) Class attribute - tagname.classvalue or .classValue (. is for class)
	// c) By Attribute- tagname[attribute_name='attribute value']
	// d) multiple Attiribute - tagname[attribute_name='attribute
	// value'][[attribute_name1='attribute value1']]
	// e) Attribute Starts with (^=) -tagname[attribute_name^='attribute start
	// value']
	// f) Attribute containts (*=) -tagname[attribute_name*='attribute value']
	// e) Parent-child Hierarchy- Parent_locator > child_locator
	// (td[colspan='2']>input[type='submit'])

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\chromedriver6.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://stqatools.com/demo/");
		driver.manage().window().maximize();

		// id
		WebElement nameElement = driver.findElement(By.id("studentname"));
		nameElement.sendKeys("Sachin");
		Thread.sleep(2000); // wait (hard)

		// id
		WebElement fatherName = driver.findElement(By.id("fathername"));
		fatherName.sendKeys("Ramesh");

		// name
		WebElement postaladdress = driver.findElement(By.name("paddress"));
		postaladdress.sendKeys("ABC chowk, xyz-411026");

		// tagName
		List<WebElement> inputlist = driver.findElements(By.tagName("input"));
		inputlist.get(3).sendKeys("Hinjewadi, Pune-411052");

		// className
		WebElement demoTestLink = driver.findElement(By.className("navbar-brand"));
		System.out.println(demoTestLink.getText());

		// linkText
		WebElement link = driver.findElement(By.linkText("Demo Test"));
		System.out.println("link====" + link.getText());

		// partialLinkText
		WebElement partiallink = driver.findElement(By.partialLinkText("Demo"));
		System.out.println("Partial====" + partiallink.getText());

		// CSSSelector - id attribute
		WebElement pincode = driver.findElement(By.cssSelector("input#pincode"));
		pincode.sendKeys("000123");

		// CSSSelector - class attribute
		WebElement cssDemoTestLink = driver.findElement(By.cssSelector(".navbar-brand"));
		System.out.println("====CSS Class atribute" + cssDemoTestLink.getText());

		// CSSSelector - By attribute
		WebElement emailid = driver.findElement(By.cssSelector("input[name='emailid']"));
		emailid.sendKeys("ABC@gmail.com");
		Thread.sleep(2000);

		// CSSSelector - Multiple attribute
		WebElement emailid_multipleattribute = driver.findElement(By.cssSelector("input[type='text'][name='emailid']"));
		emailid_multipleattribute.clear();

		// CSSSelector - Attribute starts with
		WebElement emailid_startvalue = driver.findElement(By.cssSelector("input[name^='email']"));
		emailid_startvalue.sendKeys("XYZ@gmail.com");
		Thread.sleep(2000);

		// CSSSelector - Attribute ends with
		WebElement emailid_endvalue = driver.findElement(By.cssSelector("input[name$='id']"));
		emailid_endvalue.clear();

		// CSSSelector - Attribute containts with
		WebElement emailid_containtvalue = driver.findElement(By.cssSelector("input[name*='mail']"));
		emailid_containtvalue.sendKeys("PQR@gmail.com");

		WebElement Submitform = driver.findElement(By.cssSelector("      td[colspan='2']>input[type='submit']")); // parent
																													// and
																													// child
																													// relationship
		Submitform.click();

		/*
		 * driver.get("https//www.google.com/"); webelement
		 * gmailLink=driver.findElement(By.linkText("Gmail")); gmailLink.click();
		 * 
		 * WebElement workForce1Link=driver.findElement(By.partialLinkText("work"));
		 * workfForce1Link.click();
		 */

		// demoTestLink.click();
		// driver.close()

	}

}
