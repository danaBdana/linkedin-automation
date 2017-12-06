package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import PageObject.MyNetwork;
import PageObject.homePage;
import PageObject.myPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Base 
{
	
	public static homePage hp;
	public static myPage mp;
	public static MyNetwork mnw;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static commonOps cops;
	protected static AndroidDriver<AndroidElement> driver = null;
	
	public static String timeStamp = new SimpleDateFormat("yyy-MM-dd-HH-mm-ss").format(Calendar.getInstance().getTime());
	
	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File("C:\\Users\\Dana\\Desktop\\Yoni\\myExternalFileMobile.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile); 
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}

	

	public static void  instanceReport() throws ParserConfigurationException, SAXException, IOException
	{
		
		extent = new ExtentReports (getData("ReportFilePath") + getData("ReportFileName") + timeStamp + ".html", true);  
		
	}

	public static void initReportTest(String testName, String testDescription)
	{
		test = extent.startTest(testName, testDescription);		

	}

	public static void finalizeReportTest()
	{
		extent.endTest(test);	

	}
	
	public static void finalizeExtentReport()
	{
		extent.flush();	
		extent.close();

	}

	
	
	public static String takeSS() throws IOException, ParserConfigurationException, SAXException
	{
		String SSPath = getData("SSPath") + "screenshot_" + getRandomNumber() +".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, new File("C:\\Users\\user\\Desktop\\Automation\\ExtentReports\\TakesScreenshot\\screenshot.png")); //update location!!!
		return SSPath;
	}

	
	public static int getRandomNumber()
	{
		Random rand = new Random();
		return rand.nextInt(1000) + 1000;
		
	}
	
	
	
	
	
	
	
	
	
}
