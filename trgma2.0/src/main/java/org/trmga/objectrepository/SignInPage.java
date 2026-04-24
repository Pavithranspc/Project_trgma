package org.trmga.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	@FindBy (id = "userName")
	private WebElement UserNameTextField;
	
	@FindBy (id = "pwd")
	private WebElement PasswordTextField;
	
	@FindBy(xpath = "//button[@type='submit' and text()='Sign in']")
	private WebElement SignInButton;
	
	public SignInPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}

	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getSignInButton() {
		return SignInButton;
	}
	
	public void signIn(String username,String password) {
		
		UserNameTextField.sendKeys(username);
		PasswordTextField.sendKeys(password);
		SignInButton.submit();
		
	}
	
}
