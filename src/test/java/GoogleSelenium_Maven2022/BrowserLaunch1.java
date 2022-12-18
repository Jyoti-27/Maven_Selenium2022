package GoogleSelenium_Maven2022;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

//@SuppressWarnings("unused")
public class BrowserLaunch1 {
	static String homepath = System.getProperty("user.dir");
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// launchBrowser2("chrome");

		System.setProperty("webdriver.chrome.driver", homepath + "\\src\\test\\resources\\drivers\\chromedriver6.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.co.in");
		// driver.navigate().to("https://mail.google.co.in");
		driver.manage().window().maximize();
		System.out.println("Google Browser is launched successfully");

		Thread.sleep(2000);

	

		/*
		 * @FindBy(className = "gb_1 gb_2 gb_8d gb_4 gb_8c") WebElement Signin;
		 * 
		 * @FindBy(xpath="//input[contains(@name,'identifier')]") WebElement email;
		 * 
		 * @FindBy(name = "password") WebElement password;
		 * 
		 * @FindBy(xpath="//input[contains(@class,'gLFyf gsfi')]") WebElement searchox;
		 * 
		 * @FindBy(xpath="//input[contains(@class,'gNO89b')]") WebElement GoogleSearch;
		 */

		
		
		
		// @SuppressWarnings("unchecked")
		WebElement googleappsbtn = driver.findElement(By.className("gb_Ue"));
		googleappsbtn.click();
		
		
		//WebElement dropdown = driver.findElement(By.tagName("a")); 
		//WebElement dropdown = driver.findElement(By.tagName("ul"));
		//WebElement dropdown = driver.findElement(By.className("LVal7b u4RcUd"));
		List<WebElement> dropdown = driver.findElements(By.xpath("//ul[contains(@class,'LVal7b u4RcUd')]"));
		
		//WebElement dropdown = driver.findElement(By.tagName("a"));
		((WebElement) dropdown).click();  // error
		Select select = new Select((WebElement) dropdown);// create object for Select class
		// select.selectByIndex(0);
		// select.selectByValue("Meet");               
		select.selectByValue("News");
		
		

// tag ul    class LVal7b u4RcUd    "//a[contains(@class,'j1ei8c')]"));
		
		

	
		
		
		/* p- div id - SIvCob     c-a tag            /html/body/div[1]/div[4]/div/div/a[1]
		 * / WebElement youtube=driver.findElement(By.xpath(
		 * "/html/body/div/c-wiz/div/div/c-wiz/div/div/ul[1]/li[4]/a"));
		 * youtube.click(); WebElement myaccount =driver.findElement(By.xpath(
		 * "/html/body/div/c-wiz/div/div/c-wiz/div/div/ul[1]/li[1]/a"));
		 * myaccount.click(); WebElement map =driver.findElement(By.xpath(
		 * "/html/body/div/c-wiz/div/div/c-wiz/div/div/ul[1]/li[3]/a")); map.click();
		 * 
		 * List<WebElement> googleapps =
		 * driver.findElements(By.xpath("//span[@class='MrEfLc']//div[@class='CgwTDb']")
		 * ); List<WebElement> googleapps =
		 * driver.findElements(By.xpath("//span[@class='MrEfLc' and
		 * 
		 * @style='background-position: 0 -759px;']")); List<WebElement> googleapps =
		 * driver.findElements(By.xpath("//span[@class='MrEfLc']/parent::div"));
		 * List<WebElement> googleapps =
		 * driver.findElements(By.xpath("//span[@class='MrEfLc']//child::div"));
		 * List<WebElement> googleapps =
		 * driver.findElements(By.cssSelector("li[class='tX9u1b']")); List<WebElement>
		 * googleapps =
		 * driver.findElements(By.xpath("//a[@class='tX9u1b']//span[@class='Rq5Gcb']"));
		 * List<WebElement> googleapps =
		 * driver.findElements(By.xpath("//a[contains(@class,'j1ei8c')]"));
		 * List<WebElement> googleapps = driver.findElements(By.className("MrEfLc"));
		 * 
		 */

		
		
		
		

		
		
		
		/*
		 * WebElement dropdown = driver.findElement(By.className("CgwTDb")); WebElement
		 * dropdown = driver.findElement(By.xpath(
		 * "/html/body/div/c-wiz/div/div/c-wiz/div/div/ul[1]/li[7]/a"));
		 * 
		 * WebElement dropdown =
		 * driver.findElement(By.xpath("//a[contains(@class,'j1ei8c')]"));
		 * dropdown.click(); WebElement dropdown = driver.findElement(By.xpath("//span[@class='MrEfLc' and @style='background-position: 0 -759px;']"))
		 * ; dropdown.click(); WebElement dropdown =
		 * driver.findElement(By.cssSelector("li[class='tX9u1b']")); dropdown.click();
		 * WebElement dropdown =
		 * driver.findElement(By.xpath("//a[@class='tX9u1b']//li[@class='j1ei8c']"));
		 * dropdown.click(); WebElement dropdown =
		 * driver.findElement(By.xpath("//span[@class='MrEfLc']//div[@class='CgwTDb']"))
		 * ; dropdown.click(); WebElement dropdown =
		 * driver.findElement(By.xpath("//a[contains(@class,'j1ei8c')]"));
		 * dropdown.click(); WebElement dropdown =
		 * driver.findElement(By.className("MrEfLc")); dropdown.click();
		 * Thread.sleep(10);
		 */

		
		

	}
}



		
		//--------------------------------------------------------------------------------------------
		//@SuppressWarnings("unused")
		//List<WebElement> googleapps = driver.findElements(By.xpath("//span[contains(@class,'MrEfLc')]"));
		//((WebElement) googleapps).click();  j1ei8c  li      a tX9u1b
		//List<WebElement> googleapps = driver.findElements(By.xpath("//li[@class,' j1ei8c']/parent::span"));
		//((WebElement) googleapps).click(); 
		
		//WebElement account = driver.findElement(By.xpath("//a[contains(@class,'j1ei8c')]"));
		//((WebDriver) account).get("href=https://myaccount.google.com/?utm_source=OGB&amp;utm_medium=app");
		//WebElement account = driver.findElement(By.xpath("//*[@class,'tX9u1b']//a[contains(@href,'webhp']"));
		//account.click();
		//WebElement account = driver.findElement(By.className("MrEfLc"));
		//account.click();  Rq5Gcb"//a[@class='gb_z gb_rc'
		//("//td[@colspan='2']//child::input"));
		
		//List<WebElement> Googleapps = driver.findElements(By.xpath("//a[@class='tX9u1b']//span[@class='Rq5Gcb']"));
		//((WebElement) Googleapps).click();
		//List<WebElement> account = driver.findElements(By.cssSelector("li[class='tX9u1b']"));
		//account.sendKeys("Account");
		//((List<WebElement>) googleappsbtn).get(0).click(); tX9u1b   a class
		
		
		//List<WebElement> Googleapps = driver.findElements(By.className("MrEfLc"));
		//List<WebElement> Googleapps = driver.findElements(By.cssSelector("li[class='tX9u1b']"));
		//List<WebElement> Googleapps = driver.findElements(By.xpath("//a[@class='tX9u1b']//span[@class='Rq5Gcb']"));
		//List<WebElement> Googleapps = driver.findElements(By.xpath("//a[contains(@class,'j1ei8c')]"));
		
		
		

		
		// DropDown  c-span  Rq5Gcb, MrEfLc    p-div CgwTDb
		//List<WebElement> googleapps = driver.findElements(By.className("MrEfLc"));
		//((WebElement) googleapps).click();
		//List<WebElement> googleapps = driver.findElements(By.tagName("span"));
		//((WebElement) googleapps).click();
				//List<WebElement> googleapps = driver.findElements(By.cssSelector("li[class='tX9u1b']"));
				//((WebElement) googleapps).click();
				//List<WebElement> googleapps = driver.findElements(By.xpath("//a[@class='tX9u1b']//span[@class='Rq5Gcb']"));
				//((WebElement) googleapps).click();
				//List<WebElement> googleapps = driver.findElements(By.xpath("//a[contains(@class,'j1ei8c')]"));
				//((WebElement) googleapps).click();  */


				//Select googleapps1 = new Select((WebElement) googleapps1);// create object for Select class
				//googleapps1.selectByIndex(0);
				// select.selectByValue("audi");
				// select.selectByVisibleText("Opel");*/
				

	


	

/*	// condition based selection

		String checkboxinput = "bike";

		if (checkboxinput.equalsIgnoreCase("bike)")) {
			checkbox_list.get(0).click();
		} else {
			checkbox_list.get(1).click();
		}*/

		
		



		//WebElement account = driver.findElement(By.cssSelector("div[className='CgwTDb']"));
		//account.sendKeys("Account");
		//account.click();
		
		//Select select=new Select(account);
		//select.selectByVisibleText("Account");
	    
		//WebElement account =  driver.findElement(By.className("j1ei8c"));  //MrEfLc   CgwTDb
		//account.click();
		//WebElement account = driver.findElement(By.cssSelector("li[className='j1ei8c']"));
		//account.sendKeys("Account");
		//account.click();
		
		//WebElement account = driver.findElement(By.xpath("//a[contains(@class,'j1ei8c')]"));
		//account.click();
		//WebElement GoogleSe
       // Select googleappsbtn=new Select(account);// create object for Select class
       // googleappsbtn.selectByValue("Account");
        
		

	/*	List<WebElement> googleappsbtn = driver.findElements(By.className("gb_Ue"));

		// selecting all checkbox
		for (WebElement element : googleappsbtn) {
			element.click();
		}
		String checkboxinput = "Account";

		if (checkboxinput.equalsIgnoreCase("Account)")) {
			googleappsbtn.get(0).click();
		} else {
			googleappsbtn.get(1).click();
		}*/

		
        
        //Rq5Gcb
       // select.selectByValue("My Account");  
		
		/*WebElement account =  driver.findElement(By.className("MrEfLc"));
		account.click();
		WebElement emailid = driver.findElement(By.cssSelector("input[name='emailid']"));
		emailid.sendKeys("ABC@gmail.com");
		
		WebElement searchox = driver.findElement(By.xpath("//input[contains(@class,'gLFyf gsfi')]"));
		searchox.click();
		WebElement GoogleSearch = driver.findElement(By.xpath("//input[contains(@class,'gNO89b')]"));
		GoogleSearch.click();
		WebElement signin = driver.findElement(By.className("gb_1 gb_2 gb_8d gb_4 gb_8c"));
		signin.click();
		WebElement email = driver.findElement(By.xpath("//input[contains(@name,'identifier')]"));
		email.click();
		WebElement password = driver.findElement(By.name("password"));
		password.click();     */
		
	
			    
	   // Select select=new Select(googleappsbtn);// create object for Select class
	   // select.selectByValue("Maps");
	  //  select.selectByValue("My Account");    
	    
	
	  // }		
	//}
	



	  /*//name locator demo
package selenium.locators.examples;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class nameLocatorDemo {

 public static void main(String[] args) {
  
  WebDriver driver;
  
  System.setProperty("webdriver.chrome.driver", "D:\\006_trainings\\chromedriver.exe");
  System.setProperty("webdriver.chrome.silentOutput", "true");
  
  driver = new ChromeDriver();
  driver.navigate().to("https://mail.google.com/");
  
  driver.manage().window().maximize();
  
  // locate "Email or Phone" text input with "name" locator and enter email say --> java.selenium2021@gmail.com

  driver.findElement(By.name("identifier")).sendKeys("java.selenium2021@gmail.com");
  
  // click on "Next" button - This is an xpath example that will be covered in later sessions
  driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
  
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  //locate "Enter your password" text input with "password" locator and enter password say --> JavaSelenium2021
  WebElement elePassword=driver.findElement(By.name("password"));
  elePassword.sendKeys("JavaSelenium2021");
  
  elePassword.sendKeys(Keys.TAB); 
  elePassword.sendKeys(Keys.TAB); 
   
  // click on "Next" button - This is again an xpath example. 
  driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
  
  //close the driver
  //driver.close();
 }
}*/	

	
		 
 

		