package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// helper class
public class HelperMethods {

	static WebDriver driver ;
	public static WebDriver launchBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void closeWindow() {
		driver.quit();
	}
	
	public static void navigateToSubMenu(String subMenuText)
	{
		driver.findElement(By.xpath("//ul/li[@class='submenu']/a/span[contains(text(),'"+subMenuText+"')]")).click();
	}
}
