package org.trmga.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	//Declaration
	@FindBy (xpath = "//i[text()='']")
	private WebElement CreateCampaignButton;
	
	@FindBy (xpath = "//input[@placeholder='Search by Campaign Name']")
	private WebElement SearchtextField;
	
	@FindBy (xpath = "//select[@class='form-control']")
	private WebElement SearchDropdown;

	@FindBy (xpath = "//tr[@class='tr']")
	private WebElement TableRow;
	
	
	//Initialization
	public CampaignPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	
	}
	
	/**
	 * This method is used to call edit button.
	 * Pass the CampaignName as parameter.
	 * @param TableRow
	 * @param Value
	 * @return
	 */
	public WebElement getEditButton(WebElement TableRow,String Value) {
		
		WebElement element = TableRow.findElement(By.xpath("//td[text()='"+Value+"']/..//i[@title='Edit']"));
		
		return element;
		
	}
	
	/**
	 * This method is used call delete button.
	 * Pass the CampaignName as parameter.
	 * @param TableRow
	 * @param Value
	 * @return
	 */
	public WebElement getDeleteButton(WebElement TableRow,String Value) {
		
		
		return TableRow.findElement(By.xpath("//td[text()='"+Value+"']/..//i[@title='Delete']"));
		
	}
	
	//getters
	public WebElement getCreateCampaignButton() {
		return CreateCampaignButton;
	}

	public WebElement getSearchtextField() {
		return SearchtextField;
	}

	public WebElement getSearchDropdown() {
		return SearchDropdown;
	}

	public WebElement getTableRow() {
		return TableRow;
	}
	
	

	
	
}
