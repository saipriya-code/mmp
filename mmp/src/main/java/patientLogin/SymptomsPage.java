package patientLogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SymptomsPage {
	
	WebDriver driver;
	
	public SymptomsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean checkTitleMessage() {
		String actual = driver.findElement(By.xpath("//div[@class='panel-heading']/h3")).getText();
		String expected = "Search Symptoms";
		if(actual.equals(expected)) {
			return true;
		}
		return false;
	}
	
	public boolean checkQuestion() {
		String actual = driver.findElement(By.xpath("(//p[@align='center'])[1]")).getText();
		String expected = "What Symptoms are you experiencing?";
		if(actual.equals(expected)) {
			return true;
		}
		return false;
	}

	public boolean searchSymptom(String symptom) throws InterruptedException {
		List<WebElement> eleList;
		driver.findElement(By.name("search")).clear();;
		driver.findElement(By.name("search")).sendKeys(symptom);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(4000);
		eleList = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td"));
		if(eleList.size() != 0){
			if(eleList.get(0).getText().toUpperCase().equals(symptom.toUpperCase())) {
				eleList.clear();
				return true;
			}
		}
		return false;
	}
	
}
