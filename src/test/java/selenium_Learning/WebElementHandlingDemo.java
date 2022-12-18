package selenium_Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementHandlingDemo {
	// 1. radio button
	// 2. checkBox
	// 3. DropDown

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandana\\eclipse-workspace\\Maven_Selenium2022\\src\\test\\resources\\drivers\\chromedriver6.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://ultimateqa.com/automation/");
		driver.manage().window().maximize();

		WebElement link = driver.findElement(By.linkText("Interactions with simple elements"));
		link.click();
		Thread.sleep(2000);

		/*
		 * WebElement
		 * male_gender=driver.findelement(By.cssSelector("input[value='male']"));
		 * male_gender.click(); Thread.sleep(2000);
		 * 
		 * WebElement
		 * female_gender=driver.findelement(By.cssSelector("input[value='female']"));
		 * female_gender.click(); Thread.sleep(2000);
		 */

		String gender = "";

		List<WebElement> radio_list = driver.findElements(By.name("gender"));

		if (gender.equalsIgnoreCase("Male")) {
			radio_list.get(0).click();
		} else if (gender.equalsIgnoreCase("Female")) {
			radio_list.get(1).click();
		} else {
			radio_list.get(2).click();
		}

		// Check Boxes

		/*
		 * WebElement bike_checkBox =
		 * driver.findElement(By.cssSelector("input[value='Bike']"));
		 * bike_checkBox.click();
		 * 
		 * WebElement car_checkBox =
		 * driver.findElement(By.cssSelector("input[value='Car']"));
		 * car_checkBox.click();
		 */

		List<WebElement> checkbox_list = driver.findElements(By.name("vehicle"));

		// selecting all checkbox
		for (WebElement element : checkbox_list) {
			element.click();
		}

		// condition based selection

		String checkboxinput = "bike";

		if (checkboxinput.equalsIgnoreCase("bike)")) {
			checkbox_list.get(0).click();
		} else {
			checkbox_list.get(1).click();
		}

		// DropDown

		WebElement dropdown = driver.findElement(By.tagName("select"));
		dropdown.click();

		Select select = new Select(dropdown);// create object for Select class
		select.selectByIndex(0);
		// select.selectByValue("audi");
		// select.selectByVisibleText("Opel");

		// Deselect
		driver.get("https://www.softwaretestingmaterial.com/sample-webpage-to-automate/");
		Thread.sleep(2000);
		driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();
		WebElement mySelectElement = driver.findElement(By.name("multipleselect[]"));
		Select dropdown1 = new Select(mySelectElement);
		dropdown1.selectByIndex(2);
		Thread.sleep(4000);
		dropdown1.deselectByIndex(2);

	}

}
