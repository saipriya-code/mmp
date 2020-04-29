package patientLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientLogin {
	WebDriver driver;

	public PatientLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void patientLogin(String username,String password)
	{
		//Login Method
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();

	}
	
	public String fetchUname()
	{
		String unameValue = driver.findElement(By.tagName("h3")).getText();
		return unameValue;
	}

	public void navigateToProfilePage() {
		driver.findElement(By.xpath("//ul/li/a/span[contains(text(),'Profile')]")).click();		
	}

}
