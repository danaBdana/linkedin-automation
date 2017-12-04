package TestCase;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utilities.Base;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import static org.junit.Assert.*;

import java.io.IOException;
//import java.net.MalformedURLException;
//import PageObject.homePage;
//import PageObject.myPage;
//import PageObject.MyNetwork;



public class SanityMobile extends Base
{
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";
	protected AndroidDriver<AndroidElement> driver = null;
	DesiredCapabilities dc = new DesiredCapabilities();
	


	@Before
	public void setUp() throws ParserConfigurationException, SAXException, IOException {
		dc.setCapability("reportDirectory", reportDirectory);
		dc.setCapability("reportFormat", reportFormat);
		dc.setCapability("testName", testName);
		dc.setCapability(MobileCapabilityType.UDID, getData("MobileName"));
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("ApplicationName"));
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("ApplicationPage"));
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
	}

	@Test
	public void Test1_whichKindOfApp()
	{
		System.out.println(driver.getContext());
	}
	
	@Test
	public void Test2_verifyMyName() 
	{
		hp.me_launcher.click();
		mp.isItMyName(); \\Y????
	}

	@Test
	public void Test3_addAutomationSkillAndVerify()
	{
		hp.me_launcher.click();
		driver.swipe(1000, 1750, 250, 650, 100); //how to move them to commonOps???
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		mp.skill_edit_btn.click();
		mp.add_skill_btn.click();
		mp.search_bar_text.sendKeys("Automation");
		mp.automation_skill.click();
		mp.back_from_skills_btn.click();
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		mp.verifyElementExists(); // Y it's unused?
	}

	@Test 
	public void Test4_addConnections() throws InterruptedException 
	{
		hp.connection_tab.click();
		mnw.add_connection_btn.click();
		Thread.sleep(1000);
		mnw.add_connection_btn.click();
		Thread.sleep(1000);
		mnw.add_connection_btn.click();
		Thread.sleep(1000);
		mnw.add_connection_btn.click();
	}

	@Test
	public void Test5_writeAPost()
	{
		hp.write_post_btn.click();
		hp.write_post_txtbox.sendKeys("Hey, this is an Automation test");
		hp.share_post_btn.click();
		hp.isItMyStatus();
		
	}
	
	
	
	
	
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
