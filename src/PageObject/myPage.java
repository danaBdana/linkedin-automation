package PageObject;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.Base;

public class myPage extends Base 
{
	
	public myPage(AndroidDriver<AndroidElement> driver)
	{
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "profile_view_top_card_full_name")
	public WebElement my_name;
	String myName = my_name.getText();
	
	@FindBy(how = How.ID, using = "profile_view_top_skills_card_edit_bt")
	public WebElement skill_edit_btn;
	
	@FindBy(how = How.ID, using = "profile_view_toolbar_add_button")
	public WebElement add_skill_btn;
	
	@FindBy(how = How.ID, using = "search_bar_text")
	public WebElement search_bar_text;
	
	@FindBy(how = How.XPATH, using = "//*[@text='Automation']")
	public WebElement automation_skill;
	
	@FindBy(how = How.XPATH, using = "//*[@contentDescription='Back']")
	public WebElement back_from_skills_btn;
	
	
	public void verifyElementExists()
	{
		try 
		{
			automation_skill.isDisplayed();
			System.out.println("Automation skill was found");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
	}
	

	public void isItMyName() 
	{
		try 
		{
			assertEquals(myName,"Dana Berebi");
			System.out.println(myName);
		} 
		catch (AssertionError e) 
		{
			System.out.println("Your name is not Dana Berebi" + e);
		}
	}

	
}



