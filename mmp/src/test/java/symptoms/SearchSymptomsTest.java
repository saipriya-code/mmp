package symptoms;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.HelperMethods;
import patientLogin.PatientLogin;
import patientLogin.SymptomsPage;

public class SearchSymptomsTest {

	WebDriver driver;
	
	@Parameters({"id","password","patientLoginURL"})
	@Test
	public void testSymptoms(String id,String pwd, String patientUrl) throws InterruptedException {
		// launching the browser
		driver = HelperMethods.launchBrowser(patientUrl);
		PatientLogin patLgn = new PatientLogin(driver);
		// login as patient to check symptoms
		patLgn.patientLogin(id, pwd);
		// click on search symptoms menu
		HelperMethods.navigateToSubMenu("Search Symptoms");
		SymptomsPage symPage = new SymptomsPage(driver);
		// check for title message
		Assert.assertTrue(symPage.checkTitleMessage());
		//check for displayed question
		Assert.assertTrue(symPage.checkQuestion());
		//check for valid test case
		Assert.assertTrue(symPage.searchSymptom("Fever"));
		Assert.assertTrue(symPage.searchSymptom("Pain"));
		//check for invalid test case
		Assert.assertFalse(symPage.searchSymptom("abcde"));
		// close the browser
		HelperMethods.closeWindow();
	}
}
