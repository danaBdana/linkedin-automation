package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.Base;

public class MyNetwork extends Base 
{
	public MyNetwork(AndroidDriver<AndroidElement> driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "mynetwork_pymk_connect")
	public WebElement add_connection_btn;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
