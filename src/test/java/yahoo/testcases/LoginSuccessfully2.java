package yahoo.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import yahoo.pages.*;

public class LoginSuccessfully2 extends TestBase
{
	@Test(description="Failed test")
	public void loginSuccessfully()
	{
		//Create a LoginPage
		LoginPage login_page = new LoginPage();
		
		//Step 1: Navigate to Yahoo Login page. (already do in TestBase).
		
		//Step 2: Enter valid Username (ex: test240895).
		//Step 3: Click on �Next� button.
		//Step 4: Enter valid Password (ex: ASDzxc1472).
		//Step 5: Click on �Sign in� button.
		HomePage home_page = login_page.login("test240895", "ASDzxc1472");
		Assert.assertEquals(1, 2);
		
		//VP: Verify that Yahoo Home Page appears. (Expected result: Yahoo Home Page appears).
		boolean is_on_home_page = home_page.getTitle().equals("Yahoo");
		Assert.assertTrue(is_on_home_page);
		
		//Logout.
		if (is_on_home_page)
		{
			home_page.logout();
		}
	}
}
