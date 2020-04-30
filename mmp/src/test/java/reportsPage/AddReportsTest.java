package reportsPage;

import java.awt.AWTException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import adminLogin.AdminLogin;
import adminLogin.ReportsPage;
import helper.HelperMethods;
import patientLogin.PatientLogin;
import patientLogin.ViewReportsPage;

public class AddReportsTest {

	WebDriver driver;
	HashMap<String, String> hMap = new HashMap<String, String>();
	
	// testing using parameters from testng.xml
	@Parameters({"adminId","adminPwd","adminLoginURL"})
	@Test(priority=1)
	public void testAddReport(String id, String pwd, String adminURL) throws AWTException, InterruptedException {
		// launching the browser
		driver = HelperMethods.launchBrowser(adminURL);
		AdminLogin admLgn = new AdminLogin(driver);
		// login as admin into the site
		admLgn.adminLogin(id, pwd);
		// click on patients menu
		HelperMethods.navigateToSubMenu("Patients");
		// search for a patient with ssn number
		boolean result = admLgn.searchPatient("462379048");
		Assert.assertTrue(result);
		// add report to the patient details
		ReportsPage repPage = new ReportsPage(driver);
		hMap = repPage.addreportDetails();
		// click on logout menu
		HelperMethods.navigateToSubMenu("Logout");
		// close the browser
		HelperMethods.closeWindow();
	}
	
	@Parameters({"id","password","patientLoginURL"})
	@Test(priority=2)
	public void testCheckReportAvailable(String id, String pwd, String patientURL) {
		// launching the browser
		driver = HelperMethods.launchBrowser(patientURL);
		PatientLogin patLgn = new PatientLogin(driver);
		// login as patient to check profile
		patLgn.patientLogin(id,pwd);
		// click on profile menu
		patLgn.navigateToProfilePage();
		//check if the report is displayed
		ViewReportsPage reports = new ViewReportsPage(driver);
		boolean result = reports.viewReports(hMap);
		Assert.assertTrue(result);
		// close the browser
		HelperMethods.closeWindow();
	}
}
