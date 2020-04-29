package patientLogin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PatientRegistration {
	WebDriver driver;
	HashMap<String, String> hMAp = new HashMap<String, String>();
	
	public PatientRegistration(WebDriver driver) {
		this.driver = driver;
	}

	public HashMap<String, String> registerPatient(String userName, String pwd) {
		Random rnd = new Random();
		String tempStrValue = null;
		WebElement tempEleValue =null;
		long tempLongValue;
		
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
		tempStrValue = "FirstNAme" + (char)(65 + rnd.nextInt(26));
		tempEleValue = driver.findElement(By.name("fname"));
		tempEleValue.sendKeys(tempStrValue);
		hMAp.put("fname", tempEleValue.getAttribute("value"));
		
		tempStrValue = "LastNAme" + (char)(65 + rnd.nextInt(26));
		tempEleValue = driver.findElement(By.name("LastName"));
		tempEleValue.sendKeys(tempStrValue);
		hMAp.put("LastName", tempEleValue.getAttribute("value"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		Date date= new Date();
		
		tempEleValue = driver.findElement(By.name("dob"));
		tempEleValue.sendKeys(sdf.format(date));
		hMAp.put("dob", tempEleValue.getAttribute("value"));
		
		tempLongValue =  10000000 + rnd.nextInt(90000000);
		tempEleValue = driver.findElement(By.name("license"));
		//tempEleValue.sendKeys(""+tempLongValue);
		tempEleValue.sendKeys("12345678");
		hMAp.put("license", tempEleValue.getAttribute("value"));
		
		tempLongValue =  100000000 + rnd.nextInt(900000000);
		tempEleValue = driver.findElement(By.name("ssn"));
		tempEleValue.sendKeys(""+tempLongValue);
		hMAp.put("ssn", tempEleValue.getAttribute("value"));
		
		tempEleValue = driver.findElement(By.name("state"));
		tempEleValue.sendKeys("GA");
		hMAp.put("state", tempEleValue.getAttribute("value"));
		
		tempEleValue = driver.findElement(By.name("city"));
		tempEleValue.sendKeys("peachtree city");
		hMAp.put("city", tempEleValue.getAttribute("value"));
		
		tempEleValue = driver.findElement(By.name("address"));
		tempEleValue.sendKeys("234 hollow st");
		hMAp.put("address", tempEleValue.getAttribute("value"));
		
		tempLongValue =  10000 + rnd.nextInt(90000);
		tempEleValue = driver.findElement(By.name("zipcode"));
		tempEleValue.sendKeys(""+tempLongValue);
		hMAp.put("zipcode", tempEleValue.getAttribute("value"));
		
		tempLongValue =  10 + rnd.nextInt(90);
		tempEleValue = driver.findElement(By.name("age"));
		tempEleValue.sendKeys(""+tempLongValue);
		hMAp.put("age", tempEleValue.getAttribute("value"));
		
		tempEleValue = driver.findElement(By.name("height"));
		tempEleValue.sendKeys("5.3");
		hMAp.put("height", tempEleValue.getAttribute("value"));
		
		tempEleValue = driver.findElement(By.name("weight"));
		tempEleValue.sendKeys("53");
		hMAp.put("weight", tempEleValue.getAttribute("value"));
		
		tempEleValue = driver.findElement(By.name("pharmacy"));
		tempEleValue.sendKeys("walmart");
		hMAp.put("pharmacy", tempEleValue.getAttribute("value"));
		
		tempEleValue = driver.findElement(By.name("pharma_adress"));
		tempEleValue.sendKeys("234 hollow st");
		hMAp.put("pharma_adress", tempEleValue.getAttribute("value"));
		
		tempStrValue = "TestEmail" +10 + rnd.nextInt(99) + (char)(65 + rnd.nextInt(26)) + "@gmail.com";
		tempEleValue = driver.findElement(By.name("email"));
		tempEleValue.sendKeys(tempStrValue);
		hMAp.put("email", tempEleValue.getAttribute("value"));
		
		tempEleValue = driver.findElement(By.name("pwd1"));
		tempEleValue.sendKeys(pwd);
		hMAp.put("pwd1", tempEleValue.getAttribute("value"));
		
		tempEleValue = driver.findElement(By.name("pwd2"));
		tempEleValue.sendKeys(pwd);
		hMAp.put("pwd2", tempEleValue.getAttribute("value"));
		
		
		tempEleValue = driver.findElement(By.name("username"));
		tempEleValue.sendKeys(userName);
		hMAp.put("username", tempEleValue.getAttribute("value"));
		
		Select select = new Select(driver.findElement(By.id("security")));
		select.selectByVisibleText("what is your best friend name");
		
		WebElement answerTxtField = driver.findElement(By.id("answer"));
		answerTxtField.sendKeys(userName);
		hMAp.put("answer", answerTxtField.getAttribute("value"));
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Alert alrt = driver.switchTo().alert();
		hMAp.put("alert", alrt.getText());
		alrt.accept();
		
		return hMAp;
	}

}
