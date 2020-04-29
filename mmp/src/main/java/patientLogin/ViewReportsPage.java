package patientLogin;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewReportsPage {
	WebDriver driver;
	
	public ViewReportsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean viewReports(HashMap<String, String> hMap) {
		driver.findElement(By.xpath("//button[contains(text(),'View Reports')]")).click();
		
		List<WebElement> eleList = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td/a/ul/li/h4"));
		for (WebElement webElement : eleList) {
			if(webElement.getText().equals(hMap.get("reprtName"))) {
				String actual = driver.findElement(By.xpath("//table[@class='table']//h4[text()='"+hMap.get("reprtName")+"']/ancestor::li/div/p")).getText();
				String[] strArr = actual.split(":");
				actual = strArr[1];
				String expected = hMap.get("reprtDesc");
				if(actual.equals(expected)) {
					return true;
				}
			}
		}
		return false;
	}
}