package patient;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import adminLogin.AdminLogin;
import helper.HelperMethods;
import patientLogin.PatientLogin;
import patientLogin.PatientRegistration;

public class PatientRegistrationTest {
	WebDriver driver;
	HashMap<String, String> hMap = new HashMap<String, String>();

	@Test
	public void testRegister() throws InterruptedException{
		driver = HelperMethods.launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		PatientRegistration patReg = new PatientRegistration(driver);
		Random rnd = new Random();
		String userName = "TestUser" + 10 + rnd.nextInt(99);
		String pwd = "TestPwd" + 10 + rnd.nextInt(99);
		System.out.println("username is"+userName);
		System.out.println("pwd is "+pwd);
		hMap = patReg.registerPatient(userName, pwd);
		String actual=hMap.get("alert").trim();
		String expected = "Thank you for registering with MMP.";
		Assert.assertEquals(actual,expected);
		HelperMethods.closeWindow();
		
		driver = HelperMethods.launchBrowser("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		AdminLogin admLgn = new AdminLogin(driver);
		admLgn.adminLogin("Thomas_444","Edison_444");
		HelperMethods.navigateToSubMenu("Users");
		
		expected = "USER has been updated.";
		actual = admLgn.approvePatients(hMap);
		Assert.assertEquals(actual.trim(),expected);
		HelperMethods.closeWindow();
		
		driver = HelperMethods.launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		PatientLogin patLog = new PatientLogin(driver);
		patLog.patientLogin(userName,pwd);
		
		
		actual = patLog.fetchUname().trim();
		expected = userName;
		Assert.assertEquals(actual, expected);
		HelperMethods.closeWindow();
	}
}
