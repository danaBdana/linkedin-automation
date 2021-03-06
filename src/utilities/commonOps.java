package utilities;
import com.relevantcodes.extentreports.LogStatus;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class commonOps extends Base 
{

	public static void verifyElementExists(WebElement elem) throws IOException, ParserConfigurationException, SAXException
	{
		
		try 
		{
			elem.isDisplayed();
			System.out.println("Element Exists!");
			test.log(LogStatus.PASS, "Element Exists!");
		} 
		catch (Exception e) 
		{
			System.out.println("Element NOT Exists!");
			fail("Element NOT Exists!");  
			test.log(LogStatus.FAIL, "Element NOT Exists! See screen shot: " + test.addScreenCapture(takeSS()));
		}
	}
	
	
	public void swipeDown_skill_edit_btn()
	{
		driver.executeScript("client:client.swipeWhileNotFound(\"UP\", 200, 2000, 'NATIVE', \"id=profile_view_top_skills_card_edit_bt\", 0, 1000, 9, true)");
	}
	
	
	
	
	
	
	
	
}
