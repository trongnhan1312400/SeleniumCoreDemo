package yahoo.pages;

import org.openqa.selenium.By;

import com.logigear.driver.DriverManager;

import page.elements.Icon;
import page.elements.IconOption;

public class HomePage 
{
	//Element
	protected final Icon _iconProFile = new Icon(By.id("uh-avatar"));
	protected final IconOption _optSignout = new IconOption(By.id("uh-signout"));
	
	//Method
	public String getTitle()
	{
		//Get title of the page.
		return DriverManager.getDriver().getTitle();
	}
	
	public void logout()
	{
		//Logout
		this._iconProFile.click();
		this._optSignout.click();
	}
}
