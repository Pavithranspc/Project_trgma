package org.trmga.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	//Declaration
	@FindBy (xpath = "//input[@id='username']")
	private WebElement UserNameTextField;
	
	@FindBy (xpath = "//input[@id='inputPassword']")
	private WebElement PasswordTextField;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement SignInButton;
	

	@FindBy (xpath = "//button[@type='submit']")
	private WebElement ForgetPasswordLink;
	
	
	
	//Initialization
	public LoginPage (WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}

	//getters
	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getSignInButton() {
		return SignInButton;
	}

	//create a method
	public void loginIntoApplication(String username,String password) {
		
		UserNameTextField.sendKeys(username);
		PasswordTextField.sendKeys(password);
		SignInButton.click();
		
	}
	

	public void forgetPassword() {
		
		ForgetPasswordLink.click();
		
	}
	

}
