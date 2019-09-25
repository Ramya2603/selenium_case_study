package testMeApp;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testMeApp.utility.Drivers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class onlineShopping {
	 WebDriver driver=Drivers.gerDriver("chrome");
	 ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\Training_B6b.01.16\\Desktop\\onlineShopping.html");
	  ExtentReports extent=new ExtentReports();
	  ExtentTest logger=extent.createTest("TestMeApp");
  @Test(priority=3)
  public void testCart() {
	  driver.findElement(By.linkText("All Categories")).click();
	  driver.findElement(By.linkText("Electronics")).click();
	  driver.findElement(By.linkText("Head Phone")).click();
	  driver.findElement(By.linkText("Add to cart")).click();
	  driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
	  driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
	  //driver.findElement(By.name("ShippingAdd")).sendKeys("AECS Layout E block Bangalore");
	  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
  }
  @Test(priority=2)
  public void testLogin() {
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.name("userName")).sendKeys("Lalitha");
	  driver.findElement(By.name("password")).sendKeys("Password123");
	  driver.findElement(By.name("Login")).click();
  }
  @Test(priority=4)
  public void testPayment() {
	  WebElement radio2=driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div"));
	  radio2.click();
	  driver.findElement(By.xpath("//a[@onclick='radioValue()']")).click();
	  driver.findElement(By.name("username")).sendKeys("123457");
	  driver.findElement(By.name("password")).sendKeys("Pass@457");
	  driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	  driver.findElement(By.name("transpwd")).click();
	  driver.findElement(By.name("transpwd")).sendKeys("Trans@457");
	  driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	  driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
	  
	  
  }
  @Test(priority=1)
  public void testRegistration() {
	  driver.findElement(By.linkText("SignUp")).click();
	  driver.findElement(By.name("userName")).sendKeys("abcd123");
	  driver.findElement(By.name("firstName")).sendKeys("Ramya");
	  driver.findElement(By.name("lastName")).sendKeys("Kasireddy");
	  driver.findElement(By.name("password")).sendKeys("ramya123");
	  driver.findElement(By.name("confirmPassword")).sendKeys("ramya123");
	  WebElement radio1=driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[6]/div/div/label/input[2]"));
	  radio1.click();
	  driver.findElement(By.name("emailAddress")).sendKeys("ramyakasireddy.3@gmail.com");
	  driver.findElement(By.name("mobileNumber")).sendKeys("9480184819");
	  driver.findElement(By.name("dob")).sendKeys("26/03/1997");
	  driver.findElement(By.name("address")).sendKeys(" AECS E block kundanahalli Bangaore");
	  Select sq=new Select(driver.findElement(By.name("securityQuestion")));
	  sq.selectByIndex(0);
	  driver.findElement(By.name("answer")).sendKeys("Gadhag");
	  driver.findElement(By.name("Submit")).click();
	  driver.findElement(By.linkText("Home")).click();
  }
  @AfterMethod
  public void getResultAfterMethod(ITestResult result) throws IOException {
	 
	  extent.attachReporter(reporter);
	  
	  if(result.getStatus()==ITestResult.SUCCESS)
	  {
		  logger.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"-Test Case Passed", ExtentColor.GREEN));
		  TakesScreenshot snapshot=(TakesScreenshot)driver;
		  File src=snapshot.getScreenshotAs(OutputType.FILE);
		  String path=System.getProperty("user.dir")+"/extent-reports/snapshots/"+result.getName()+".png";
		  FileUtils.copyFile(src, new File(path));
		  logger.addScreenCaptureFromPath(path,result.getName());
		  //logger.log(Status.PASS, MarkupHelper.createLabel(result.getThrowable()+"-Test case Passed", ExtentColor.GREEN));	  
	  }
	  else if(result.getStatus()==ITestResult.SKIP)
	  {
		  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"-Test case Skipped", ExtentColor.ORANGE));
	  }
	  extent.flush();
	  
  }

  @BeforeTest
  public void startReportBeforeTest() {
	  String url="http://10.232.237.143:443/TestMeApp/fetchcat.htm";
	  driver.navigate().to(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }

  @AfterTest
  public void endReportAfterTest() {
	  driver.close();
  }

}
