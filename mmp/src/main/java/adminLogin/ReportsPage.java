package adminLogin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportsPage {
	WebDriver driver;
	
	public ReportsPage(WebDriver driver) {
		this.driver = driver;
	}

	public HashMap<String, String> addreportDetails() throws AWTException, InterruptedException {
		HashMap<String, String> hMap = new HashMap<String, String>();
		driver.findElement(By.xpath("//input[@value='Reports']")).click();
		new Select(driver.findElement(By.id("app_date"))).selectByVisibleText("06/20/2019");
		hMap.put("apptDate", "06/20/2019");
		driver.findElement(By.name("report_name")).sendKeys("check report");
		hMap.put("reprtName", "check report");
		driver.findElement(By.name("report_desc")).sendKeys("checking for report addition");
		hMap.put("reprtDesc", "checking for report addition");
		// upload using direct path way
		//driver.findElement(By.id("file")).sendKeys("C:\\temp-folder\\cat.jpg");
		// upload using robot class
		uploadFile("C:\\temp-folder\\cat.jpg");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		return hMap;
	}
// change code
	private void uploadFile(String path) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("file")));
		//driver.findElement(By.xpath("//input[@id='file']")).click();
		driver.findElement(By.xpath("//form[1]/div[4]")).click();
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		 
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		robot.delay(300);
		//robot.keyPress(KeyEvent.VK_ENTER);
	    //robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(500);
        //robot.keyRelease(KeyEvent.VK_V);
        //robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(500);
        //robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(500);
		Thread.sleep(500);
			
		
	}
}
