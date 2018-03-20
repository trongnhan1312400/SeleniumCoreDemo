package yahoo.pages;

import org.openqa.selenium.By;

import com.logigear.element.common.TextBox;

import io.qameta.allure.Step;
import reuse.elements.ReuseButton;

public class LoginPage 
{
	//Element
	private TextBox _txtUsername = TextBox.id("login-username");
	private TextBox _txtPassword = TextBox.id("login-passwd");
	private ReuseButton _btnSignin = new ReuseButton(By.id("login-signin"));
	
	//Method
	public void enterUsername(String username)
	{
		this._txtUsername.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		this._txtPassword.sendKeys(password);
	}
	
	public void clickSigninButton()
	{
		this._btnSignin.Reload();
		this._btnSignin.click();
	}
	
	@Step("Login to home page with valid account!")
	public HomePage login(String username, String password)
	{
		//Enter username 
		this.enterUsername(username);
		this.clickSigninButton();
		
		//Enter password
		this.enterPassword(password);
		this.clickSigninButton();
		
		//Return HomePage
		return new HomePage();
	}
}
