package adminLogin;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

// login as admin
public class AdminLogin {
	WebDriver driver;

	public AdminLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void adminLogin(String username, String pwd) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.name("admin")).click();
	}

	public String approvePatients(HashMap<String, String> hMap) {
		Select patientStatus = new Select(driver.findElement(By.id("search")));
		patientStatus.selectByVisibleText("Pending");
		driver.findElement(By.xpath("//a[contains(text(),'"+hMap.get("fname")+"')]")).click();
		new Select(driver.findElement(By.id("sapproval"))).selectByVisibleText("Accepted");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		alrt.accept();
		return actual;
	}
	public boolean searchPatient(String ssn) {
		driver.findElement(By.id("search")).sendKeys(ssn);
		driver.findElement(By.xpath("//input[@class='tfbutton']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> eleList = driver.findElements(By.xpath("//div[@id='show']/table/tbody/tr/td"));
		if(eleList.size()!=0) {
			driver.findElement(By.linkText(eleList.get(0).getText())).click();
			return true;
		}
		return false;
	}
	
}
