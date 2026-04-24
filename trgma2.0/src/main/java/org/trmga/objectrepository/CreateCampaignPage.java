package org.trmga.objectrepository;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateCampaignPage {

	// Declaration
	@FindBy(xpath = "//input[@name='campaignName']")
	private WebElement CampaignNameTextField;

	@FindBy(xpath = "//input[@name='campaignStatus']")
	private WebElement CampaignStatusTextField;

	@FindBy(xpath = "//input[@name='targetSize']")
	private WebElement TargetSizeTextField;

	@FindBy(xpath = "//input[@name='expectedCloseDate']")
	private WebElement ExpectedCloseDateTextField;

	@FindBy(xpath = "//input[@name='targetAudience']")
	private WebElement TargetAudienceTextField;

	@FindBy(xpath = "//input[@name='description']")
	private WebElement DescriptionTextArea;

	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement CreateCampaignButton;

	// Initialization
	public CreateCampaignPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	// getters
	public WebElement getCampaignNameTextField() {
		return CampaignNameTextField;
	}

	public WebElement getCampaignStatusTextField() {
		return CampaignStatusTextField;
	}

	public WebElement getTargetSizeTextField() {
		return TargetSizeTextField;
	}

	public WebElement getExpectedCloseDateTextField() {
		return ExpectedCloseDateTextField;
	}

	public WebElement getTargetAudienceTextField() {
		return TargetAudienceTextField;
	}

	public WebElement getDescriptionTextArea() {
		return DescriptionTextArea;
	}

	public WebElement getCreateCampaignButton() {
		return CreateCampaignButton;
	}

	// method to create Contract with only mandatory fields
	public void withMandatoryFields(String CONTRACTNAME, String TARGETSIZE) throws FileNotFoundException, IOException, InterruptedException {

		CampaignNameTextField.sendKeys(CONTRACTNAME);
		Thread.sleep(2000);
		TargetSizeTextField.sendKeys(TARGETSIZE);
		CreateCampaignButton.submit();

	}

	// method to create Contract with all fields
	public void withAllFields(String CONTRACTNAME, String TARGETSIZE, String CONTRACTSTATUS, String EXPECTEDCLOSINGDATE,
			String TARGETAUDIENCE, String DESCRIPTION) throws FileNotFoundException, IOException {

		CampaignNameTextField.sendKeys(CONTRACTNAME);
		CampaignStatusTextField.sendKeys(CONTRACTSTATUS);
		TargetSizeTextField.sendKeys(TARGETSIZE);
		ExpectedCloseDateTextField.sendKeys(EXPECTEDCLOSINGDATE);
		TargetAudienceTextField.sendKeys(TARGETAUDIENCE);
		DescriptionTextArea.sendKeys(DESCRIPTION);
		CreateCampaignButton.submit();

	}

}
