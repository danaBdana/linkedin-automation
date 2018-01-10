package TestCase;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utilities.Base;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;
import org.junit.*;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SanityMobile extends Base
{
	private static String reportDirectory = "reports"; //need to add path where should we save the report
	private static String reportFormat = "xml"; 
	private static String testName = "Untitled"; //name of the file
	
	static DesiredCapabilities dc = new DesiredCapabilities();



	@BeforeClass 
	public static void setUp() throws ParserConfigurationException, SAXException, IOException 
	{
		dc.setCapability("reportDirectory", reportDirectory);
		dc.setCapability("reportFormat", reportFormat);
		dc.setCapability("testName", testName);
		dc.setCapability(MobileCapabilityType.UDID, ("HT6AR0200003")); //getData("MobileName"));
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ("com.linkedin.android"));//getData("ApplicationName"));
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, (".authenticator.LaunchActivity"));//getData("ApplicationPage")); 
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);

		hp = PageFactory.initElements(driver, PageObject.homePage.class); 
		mp =  PageFactory.initElements(driver, PageObject.myPage.class); 
		mnw =  PageFactory.initElements(driver, PageObject.MyNetwork.class);

		instanceReport();
	}

	@Test
	public void Test1_whichKindOfApp()
	{
		initReportTest("Test1", "Test1_whichKindOfApp");
		System.out.println(driver.getContext());
	}

	@Test
	public void Test2_verifyMyName() 
	{
		initReportTest("Test2", "Test2_verifyMyName");
		hp.me_launcher.click();
		mp.isItMyName(); 
	}

	@Test
	public void Test3_addAutomationSkillAndVerify()
	{
		initReportTest("Test3", "Test3_addAutomationSkillAndVerify");
		hp.me_launcher.click();
		cops.swipeDown_skill_edit_btn();
		mp.skill_edit_btn.click();
		mp.add_skill_btn.click();
		mp.search_bar_text.sendKeys("Automation");
		mp.automation_skill.click();
		mp.back_from_skills_btn.click();
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		driver.swipe(1000, 1750, 250, 650, 100);
		mp.verifyElementExists(); 
	}

	@Test 
	public void Test4_addConnections() throws InterruptedException 
	{
		initReportTest("Test4", "Test4_addConnections");
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
		initReportTest("Test5", "Test5_writeAPost");
		hp.write_post_btn.click();
		hp.write_post_txtbox.sendKeys("Hey, this is an Automation test");
		hp.share_post_btn.click();
		hp.isItMyStatus();

	}
	@After
	public void doAfterTest()
	{
		finalizeReportTest();
	}

	@AfterClass
	public static void tearDown() 
	{
		finalizeExtentReport();
		driver.quit();
	}
}
