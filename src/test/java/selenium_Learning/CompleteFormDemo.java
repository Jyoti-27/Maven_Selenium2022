package selenium_Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CompleteFormDemo {

	public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\chromedriver6.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://stqatools.com/demo/");
		driver.manage().window().maximize();
		
		
		//id
		WebElement nameElement=driver.findElement(By.id("studentname"));
		nameElement.sendKeys("Sachin");
		Thread.sleep(2000);   //wait (hard)
		
		
		//id
		WebElement fatherName=driver.findElement(By.id("fathername"));
		fatherName.sendKeys("Ramesh");
		
		
		//name
		WebElement postaladdress=driver.findElement(By.name("paddress"));
		postaladdress.sendKeys("ABC chowk, xyz-411026");
		
		
		
		//tagName
		List<WebElement> inputlist=driver.findElements(By.tagName("input"));
		inputlist.get(3).sendKeys("Hinjewadi, Pune-411052");
		
		
		
		//className
		WebElement demoTestLink=driver.findElement(By.className("navbar-brand"));
		System.out.println(demoTestLink.getText());
		
		//CSSSelector - By attribute
		WebElement emailid=driver.findElement(By.cssSelector("input[name='emailid']"));
		emailid.sendKeys("ABC@gmail.com");
		Thread.sleep(2000);
				
		//xpath		
		driver.findElement(By.xpath("//input[@name='pincode'  and  @id='pincode']")).sendKeys("411065");
				

		String gender = "";
				
		List<WebElement> radio_list = driver.findElements(By.name("sex"));
				
		if (gender.equalsIgnoreCase("Male"))  {
			radio_list.get(0).click();
			} else   {
			radio_list.get(1).click();
			
			}
				 
				
		//tagname as dropdown
		WebElement dropdowncity = driver.findElement(By.name("City"));
		dropdowncity.click();
			    
	    Select select=new Select(dropdowncity);// create object for Select class
	    select.selectByIndex(2);
	    //select.selectByValue("MUMBAI");
	   //select.selectByVisibleText("NEWDELHI");
	    
			    
	    WebElement dropdowncourse = driver.findElement(By.name("Course"));
	    dropdowncourse.click();
			    
	    Select select1=new Select(dropdowncourse);// create object for Select class
		//select1.selectByIndex(1);
		select1.selectByValue("MCA");
	    //select1.selectByVisibleText("BCA");
			    
			    
	    WebElement dropdowndistrict = driver.findElement(By.name("District"));
		dropdowndistrict.click();
			    
		Select select2=new Select(dropdowndistrict);// create object for Select class
	    //select2.selectByIndex(2);
	    select2.selectByValue("Goa");
	    //select2.selectByVisibleText("UP");
			    
			    
	    WebElement dropdownstate = driver.findElement(By.name("State"));
	    dropdownstate.click();
			    
		Select select3=new Select(dropdownstate);// create object for Select class
		select3.selectByIndex(1);
		//select3.selectByValue("GOA");
	    //select3.selectByVisibleText("BIHAR");
		
			    
							
	    /* WebElement male_gender=driver.findElement(By.cssSelector("input[value='male']"));
				 male_gender.click(); 
				 Thread.sleep(2000);
				  
				 WebElement female_gender=driver.findElement(By.cssSelector("input[value='Female']"));
				 female_gender.click(); 
				 Thread.sleep(2000); */
				
		/*
				 * WebElement
				 * reset=driver.findElement(By.xpath("//input[@type='reset']/parent::td"));
				 * reset.click();
		*/
		
					
				
		
		 WebElement submit_btn=driver.findElement(By.xpath("//td[@colspan='2']//child::input"));
		 submit_btn.click();	
					
				 
	}

}
