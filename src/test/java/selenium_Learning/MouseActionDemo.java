package selenium_Learning;  // for practice site:-//https://demoqa.com/automation-practice-form

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionDemo {

	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\chromedriver6.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://stqatools.com/demo/index.php");
		 driver.manage().window().maximize();
		
		 List<WebElement> mailLinks=driver.findElements(By.id("navbarDropdownPortfolio"));
		 Thread.sleep(2000);
		 System.out.println(mailLinks.size());
		 mailLinks.get(1).click();
		 
		 
		
		 
		 
		 // Click action(Double click)
		 driver.findElement(By.linkText("Double Click")).click();
		 Thread.sleep(2000);
		 WebElement clickbtn=driver.findElement(By.xpath("//button[contains(text(),\"Click Me\")]"));
		 Actions action=new Actions(driver);
		 action.click(clickbtn).perform();
		 Thread.sleep(1000);
		 action.doubleClick(clickbtn).perform();
		 Thread.sleep(1000);
		 action.doubleClick(clickbtn).click(clickbtn).build().perform(); 
		 
		 
		
		 
		 
		 
		 //MouseHover events-dropdown
		 driver.get("https://stqatools.com/demo/MouseHover.php");
		 Thread.sleep(2000);
		 WebElement mouseHoverbtn=driver.findElement(By.className("dropbtn"));
		 action.moveToElement(mouseHoverbtn).perform();
		 List<WebElement> listelements=driver.findElements(By.xpath("//a[@type='button']"));
		 listelements.get(0).click();
		 Thread.sleep(1000);
		 
		 
		
		 
		 		
		 //MouseHover events-tooltip text for Up button
		 driver.navigate().refresh();
		 Thread.sleep(2000);
		 List<WebElement> mailLinks1=driver.findElements(By.id("navbarDropdownPortfolio"));
		 mailLinks1.get(1).click();
		 driver.findElement(By.linkText("Tool Tip")).click();
		 Thread.sleep(2000);
		 WebElement upbtn=driver.findElement(By.xpath("//span[text()=\"Up\"]"));
		 action.moveToElement(upbtn).perform();
		 String tooltip_value=upbtn.getAttribute("tooltip");
		 System.out.println("tooltip text:-"+tooltip_value);
		 
		 
		
		 
		 
		 //MouseHover events-tooltip text for Down button
		 driver.navigate().refresh();
		 Thread.sleep(2000);
		 List<WebElement> mailLinks2=driver.findElements(By.id("navbarDropdownPortfolio"));
		 mailLinks2.get(1).click();
		 driver.findElement(By.linkText("Tool Tip")).click();
		 Thread.sleep(2000);
		 WebElement downbtn=driver.findElement(By.xpath("//span[text()=\"Down\"]"));
		 action.moveToElement(downbtn).perform();
		 String tooltip_value1=downbtn.getAttribute("tooltip");
		 System.out.println("tooltip text:-"+tooltip_value1);
		 
		 
		
		 
		 
		 
		 //MouseHover events-tooltip text for Left button
		 driver.navigate().refresh();
		 Thread.sleep(2000);
		 List<WebElement> mailLinks3=driver.findElements(By.id("navbarDropdownPortfolio"));
		 mailLinks3.get(1).click();
		 driver.findElement(By.linkText("Tool Tip")).click();
		 Thread.sleep(2000);
		 WebElement leftbtn=driver.findElement(By.xpath("//span[text()=\"Left\"]"));
		 action.moveToElement(leftbtn).perform();
		 String tooltip_value2=leftbtn.getAttribute("tooltip");
		 System.out.println("tooltip text:-"+tooltip_value2);
		 
		 
		 
		
		 
		 
		 //MouseHover events-tooltip text for Right button
		 driver.navigate().refresh();
		 Thread.sleep(2000);
		 List<WebElement> mailLinks4=driver.findElements(By.id("navbarDropdownPortfolio"));
		 mailLinks4.get(1).click();
		 driver.findElement(By.linkText("Tool Tip")).click();
		 Thread.sleep(2000);
		 WebElement rightbtn=driver.findElement(By.xpath("//span[text()=\"Right\"]"));
		 action.moveToElement(rightbtn).perform();
		 String tooltip_value3=rightbtn.getAttribute("tooltip");
		 System.out.println("tooltip text:-"+tooltip_value3);
		 
		 
		 
		 
		
		 //Drag and Drop
		 driver.get("https://demoqa.com/droppable");
		 Thread.sleep(2000);
		 Actions action1=new Actions(driver);
		 WebElement dropMe=driver.findElement(By.id("draggable")); 
		 WebElement dropArea=driver.findElement(By.id("droppable"));
		 //action1.clickAndHold(dropMe).moveToElement(dropArea).release(dropArea).build().perform();// alternate to drag and drop method
		 action1.dragAndDrop(dropMe, dropArea).build().perform();
		 System.out.println("dropMe and dropArea actions are performed successfully");
			 
		 
	}

}
