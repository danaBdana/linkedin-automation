package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.Base;

public class homePage extends Base
{

	@FindBy(how = How.ID, using = "me_launcher")
	public WebElement me_launcher;
	
	@FindBy(how = How.XPATH, using = "//*[@id='home_nav_tab_container' and ./parent::*[@contentDescription='My Network, Tab 2 of 5']]")
	public WebElement connection_tab;
	
	@FindBy(how = How.ID, using = "feed_fab")
	public WebElement write_post_btn;
	
	@FindBy(how = How.ID, using = "sharing_compose_text_input")
	public WebElement write_post_txtbox;
	
	@FindBy(how = How.ID, using = "sharing_compose_post_button")
	public WebElement share_post_btn;
	
	public void isItMyStatus()
	{
		try 
		{
			driver.findElement(By.linkText("Hey, this is an Automation test")).isDisplayed();
			
			System.out.println("Post has been shared! nice job :-)");
		} catch (Exception e) 
		{
			System.out.println("Test to write a new post is failed!" + e);
		}
	}
	
	
}
