package selenium_Learning; // for homework practice-https://demoqa.com/automation-practice-form

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalenderHandlingDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = CommonFunctions.browserLaunch();
		driver.get("https://stqatools.com/demo/Datepicker.php");
		Thread.sleep(2000);
		List<WebElement> inputList = driver.findElements(By.tagName("input"));

		// Approach-1: Handling calendar whether is input tag used
		inputList.get(0).sendKeys(dateFormat(10));
		Thread.sleep(1000);
		inputList.get(1).sendKeys("August 2022");
		Thread.sleep(1000);
		inputList.get(2).sendKeys("2025");

		// Approach-2: Handling Calendar
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.id("dateOfBirthInput")));
		Thread.sleep(1000);

		WebElement monthyear = driver.findElement(By.cssSelector(
				"div[class*='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown']"));
		String monthyearText = monthyear.getText();

		while (!monthyearText.equals("September 2022")) {
			driver.findElement(By.xpath("//button[text()='Next Month']")).click();
			monthyearText = monthyear.getText();
			System.out.println(monthyearText);
		}

		Thread.sleep(1000);
		
		
		List<WebElement> dates = driver
				.findElements(By.cssSelector("div[class*='react-datepicker__day react-datepicker__day']"));
		System.out.println(dates.size());

		for (WebElement date : dates) {
			if (date.getText().equals("15")) {
				date.click();
				break;
			}
		}
	}

	
	public static String dateFormat(int days) {

		SimpleDateFormat dateformat = new SimpleDateFormat("MMMM dd,yyyy");
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, days);
		String datefinal = dateformat.format(calender.getTime());
		System.out.println("formatted date is " + datefinal);
		return datefinal;
	}

}
