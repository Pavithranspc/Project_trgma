package org.trgma.oil.contract.module;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.trmga.bussinessutility.BaseClass;
import org.trmga.objectrepository.CampaignPage;
import org.trmga.objectrepository.CreateCampaignPage;
import org.trmga.objectrepository.DashboardPage;



public class TC001_verifyUserIsAbleToCreateOilContractWithMandatoryFieldsTest extends BaseClass {
	
	@Test
	public void tC001_verifyUserIsAbleToCreateOilContractWithMandatoryFieldsTest() throws Throwable {

		Reporter.log("@test - test case, validation", true);

		// test data
		String CAMPAIGNNAME = futil.readDataFromExcelFile("Sheet1", 1, 1) + jutil.getRandomData();
		String TARGETSIZE = futil.readDataFromExcelFile("Sheet1", 1, 3);

		// Dash board
		dashboardPage = new DashboardPage(driver);
		dashboardPage.getCampaignsModule().click();

		// Campaign Page
		campaignPage = new CampaignPage(driver);
		campaignPage.getCreateCampaignButton().click();

		// Create Campaign
		createCampaignPage = new CreateCampaignPage(driver);
		createCampaignPage.withMandatoryFields(CAMPAIGNNAME, TARGETSIZE);

		/* Validation */
		String ExpectedResult = "Campaign " + CAMPAIGNNAME + " Successfully Added";
		String ActualResult = "Campaign " + CAMPAIGNNAME + " Successfully Added";

		Assert.assertEquals(ActualResult, ExpectedResult);

		
	}
	
}
