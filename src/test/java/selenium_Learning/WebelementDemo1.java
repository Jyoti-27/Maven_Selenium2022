package selenium_Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebelementDemo1 {

	// Locators Approach:1) id-fastest 2) name 3) CSS 4) Xpath

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\chromedriver6.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hp.com/demo/");
		driver.manage().window().maximize();

		// id
		WebElement nameElement = driver.findElement(By.id("student name"));
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

	}
}

//imp-//https://www.youtube.com/watch?v=Lprc1M-mxF0
// login process in chrome-https://www.browserstack.com/guide/login-automation-using-selenium-webdriver
// login page of facebook-https://www.linkedin.com/pulse/selenium-testing-login-form-facebook-margarita-velcheva

/*
 * Facebook login alternate method public static void main(String[] args) throws
 * InterruptedException { // TODO Auto-generated method stub
 * 
 * System.setProperty("webdriver.chrome.driver",
 * "C:\\sruthi-selenium\\chromedriver.exe"); WebDriver driver = new
 * ChromeDriver();
 * 
 * driver.get("https://www.facebook.com/"); driver.manage().window().maximize();
 * 
 * //text fields driver.findElement(By.id("u_0_j")).sendKeys("sruthi");
 * driver.findElement(By.name("lastname")).sendKeys("karpuram");
 * driver.findElement(By.name("reg_email__")).sendKeys("84521636866");
 * driver.findElement(By.name("reg_passwd__")).sendKeys("il9HNJ1234");
 * 
 * //static drop down Select s = new Select(driver.findElement(By.id("day")));
 * Thread.sleep(1000); s.selectByVisibleText("12");
 * 
 * Select s1 = new Select(driver.findElement(By.id("month")));
 * Thread.sleep(1000); s1.selectByValue("5");
 * 
 * Select s2 = new Select(driver.findElement(By.id("year")));
 * Thread.sleep(1000); s2.selectByValue("1993"); //radio button
 * driver.findElement(By.xpath("//input[@value='2']")).click();//for selecting
 * male
 * 
 * driver.findElement(By.name("websubmit")).click();
 * 
 * driver.close();
 * 
 * 
 * 
 * }
 */

/*
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import org.openqa.selenium.*;
 * 
 * public class Form { public static void main(String[] args) {
 * 
 * // declaration and instantiation of objects/variables
 * System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
 * WebDriver driver = new ChromeDriver();
 * 
 * driver.get("http://demo.guru99.com/test/radio.html"); WebElement radio1 =
 * driver.findElement(By.id("vfb-7-1")); WebElement radio2 =
 * driver.findElement(By.id("vfb-7-2"));
 * 
 * //Radio Button1 is selected radio1.click();
 * System.out.println("Radio Button Option 1 Selected");
 * 
 * //Radio Button1 is de-selected and Radio Button2 is selected radio2.click();
 * System.out.println("Radio Button Option 2 Selected");
 * 
 * // Selecting CheckBox WebElement option1 =
 * driver.findElement(By.id("vfb-6-0"));
 * 
 * // This will Toggle the Check box option1.click();
 * 
 * // Check whether the Check box is toggled on if (option1.isSelected()) {
 * System.out.println("Checkbox is Toggled On");
 * 
 * } else { System.out.println("Checkbox is Toggled Off"); }
 * 
 * 
 * 
 * //Selecting Checkbox and using isSelected Method
 * driver.get("http://demo.guru99.com/test/facebook.html"); WebElement
 * chkFBPersist = driver.findElement(By.id("persist_box")); for (int i=0; i<2;
 * i++) { chkFBPersist.click ();
 * System.out.println("Facebook Persists Checkbox Status is -  "+chkFBPersist.
 * isSelected()); } //driver.close();
 * 
 * } }
 */