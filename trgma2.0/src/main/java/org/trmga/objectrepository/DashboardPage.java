package org.trmga.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	
	//Declaration
	@FindBy (xpath = "//a[text()='Dashboard']")
	private WebElement DashboardModule;

	@FindBy (xpath = "//a[text()='Campaigns']")
	private WebElement CampaignsModule;

	@FindBy (xpath = "//a[text()='Contacts']")
	private WebElement ContactsModule;

	@FindBy (xpath = "//a[text()='Leads']")
	private WebElement LeadsModule;

	@FindBy (xpath = "//a[text()='Opportunities']")
	private WebElement OpportunitiesModule;

	@FindBy (xpath = "//a[text()='Products']")
	private WebElement ProductsModule;

	@FindBy (xpath = "//a[text()='Quotes']")
	private WebElement QuotesModule;

	@FindBy (xpath = "//a[text()='Purchase Order']")
	private WebElement PurchaseOrderModule;

	@FindBy (xpath = "//a[text()='Sales Order']")
	private WebElement SalesOrderModule;

	@FindBy (xpath = "//a[text()='Invoice']")
	private WebElement InvoiceModule;

	@FindBy (xpath = "//*[name()='svg' and @data-icon='user']")
	private WebElement UserIconSvg;
	
	@FindBy (xpath = "//div[text()='Logout ']")
	private WebElement LogoutButton;
	
	@FindBy (xpath = "//div[@role='alert']")
	private WebElement ToastMessageText;
	
	@FindBy (xpath = "//button[text()='✖︎']")
	private WebElement ToastMessageCloseButton;
	
	
	//Initialization
	public DashboardPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	//getters
	public WebElement getDashboardModule() {
		return DashboardModule;
	}

	public WebElement getCampaignsModule() {
		return CampaignsModule;
	}

	public WebElement getContactsModule() {
		return ContactsModule;
	}

	public WebElement getLeadsModule() {
		return LeadsModule;
	}

	public WebElement getOpportunitiesModule() {
		return OpportunitiesModule;
	}

	public WebElement getProductsModule() {
		return ProductsModule;
	}

	public WebElement getQuotesModule() {
		return QuotesModule;
	}

	public WebElement getPurchaseOrderModule() {
		return PurchaseOrderModule;
	}

	public WebElement getSalesOrderModule() {
		return SalesOrderModule;
	}

	public WebElement getInvoiceModule() {
		return InvoiceModule;
	}

	public WebElement getUserIconSvg() {
		return UserIconSvg;
	}

	public WebElement getLogoutButton() {
		return LogoutButton;
	}

	public WebElement getToastMessageText() {
		return ToastMessageText;
	}
	
	public WebElement getToastMessageCloseButton() {
		return ToastMessageCloseButton;
	}

	public void logout() throws InterruptedException {
		
		Thread.sleep(500);
		ToastMessageCloseButton.click();
		UserIconSvg.click();
		LogoutButton.click();
		
	}
	
	
}
