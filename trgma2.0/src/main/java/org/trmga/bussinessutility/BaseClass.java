package org.trmga.bussinessutility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.trmga.genericutility.FileUtility;
import org.trmga.genericutility.JavaUtility;
import org.trmga.genericutility.WebDriverUtility;
import org.trmga.objectrepository.CampaignPage;
import org.trmga.objectrepository.CreateCampaignPage;
import org.trmga.objectrepository.DashboardPage;
import org.trmga.objectrepository.LoginPage;

public class BaseClass {

	// create object for ChromeDriver class
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	// create object for utility classes
	public WebDriverUtility wutil = new WebDriverUtility();
	public FileUtility futil = new FileUtility();
	public JavaUtility jutil = new JavaUtility();

	// POM class declaration
	public CampaignPage campaignPage;
	public CreateCampaignPage createCampaignPage;
	public DashboardPage dashboardPage;
	public LoginPage loginpage;
	
	
	@BeforeMethod
	public void beforemethod() throws IOException {

		Reporter.log("@beforemethod - login", true);

		String USERNAME = futil.readDataFromPropertiesFile("ninzacrmusername");
		String PASSWORD = futil.readDataFromPropertiesFile("ninzacrmpassword");

		// login
		loginpage = new LoginPage(driver);
		loginpage.loginIntoApplication(USERNAME, PASSWORD);

	}

	@AfterMethod
	public void aftermethod() throws InterruptedException {

		Reporter.log("@aftermethod - logout", true);

		// logout
		dashboardPage = new DashboardPage(driver);
		dashboardPage.logout();

	}

	@BeforeClass
	public void beforeclass() throws IOException {

		Reporter.log("@beforeclass - open browser", true);
		
//		String URL = futil.readDataFromPropertiesFile("ninzacrmurl");
//		String BROWSER = futil.readDataFromPropertiesFile("ninzacrmbrowser");

		
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		
		
		ChromeOptions options = new ChromeOptions();
		
		// This prevents Chrome from showing the 'Save Password' or 'Change Password' popups
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", prefs);

		// create object for ChromeDriver class
		if (BROWSER.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver(options);
			
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		} else {
			
			Reporter.log("Invalid Browser Name",true);
		}
		
		//assign driver = sdriver
		sdriver = driver;
		
		// maximize browser
		wutil.toMaximize(driver);

		// implicit wait
		wutil.toImplicitlyWait(driver, 10);

		// navigate to url
		driver.get(URL);

	}

	@AfterClass
	public void afterclass() {

		Reporter.log("@afterclass - close browser", true);

		driver.quit();
		
	}

	@BeforeTest
	public void beforetest() {

		Reporter.log("@beforetest - create report", true);

	}

	@AfterTest
	public void aftertest() {

		Reporter.log("@aftertest - report backup", true);
	}

	@BeforeSuite
	public void beforesuite() {

		Reporter.log("@beforesuite - connection establishment", true);
	}

	@AfterSuite
	public void aftersuite() {

		Reporter.log("@aftersuite - connection termination", true);
	}

	
	
}
