package org.frames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\eclipse-workspace\\Frames\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("cucumber junit 4.2.0", Keys.ENTER);
		moveToPage('5');
	}

	public static void goToPage(String pageNo) {
		List<WebElement> page = driver.findElements(By.xpath("//tr/td"));
		for (int i = 0; i < page.size(); i++) {
			String name = page.get(i).getText();
			if (name.equals(pageNo)) {
				page.get(i).findElement(By.tagName("a")).click();
				break;
			}

		}

	}

	public static void moveToPage(char PageNo) {
		String Locator = "//a[@aria-label='Page 8']";
		Locator.replace('$', PageNo);
		driver.findElement(By.xpath(Locator)).click();

	}
}
