package yahoo.testcases;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.logigear.driver.*;
import com.logigear.constant.*;

public class TestBase implements SauceOnDemandSessionIdProvider
{
	private DriverProperties _driverProperties = new DriverProperties();
	protected ThreadLocal<String> _sessionId = new ThreadLocal<String>();
	
	@Override
	public String getSessionId() 
	{
		return this._sessionId.get();
	}
	
	 @BeforeMethod
	 @Parameters({"AUT"})
	 public void beforeMethod(@Optional("https://login.yahoo.com") String AUT, Method method) 
	    		throws UnexpectedException, MalformedURLException 
	 {
	 	//Let DriverManager create a WebDriver by DriverProperties
		this._driverProperties.setMethodName(method.getName());
		 
		DriverManager.createWebDriver(this._driverProperties);
		 
	   	DriverManager.getDriver().get(AUT);
	   	
	   	String session_id = ((RemoteWebDriver) DriverManager.getDriver().getWebDriver()).getSessionId().toString();
	   	this._sessionId.set(session_id);
	 }
	
    @BeforeSuite
    public void beforeSuite() throws UnexpectedException, MalformedURLException 
    {
    	this._driverProperties.setBrowserName(Constants.Browser.CHROME);
    	this._driverProperties.setBrowserVersion("59.0");
    	this._driverProperties.setDeviceName("");
    	this._driverProperties.setMethodName("");
    	this._driverProperties.setPlatform(Constants.Platform.WINDOWS);
    	this._driverProperties.setPlatformVersion("7");
    	this._driverProperties.setRemoteURL("");
    	this._driverProperties.setExecutablePath("C:\\chromedriver.exe");
    	this._driverProperties.setElementWaitTimeOut(10);
    }

    @AfterMethod
    public void afterMethod() 
    {
    	DriverManager.getDriver().quit();
    }
  
}
