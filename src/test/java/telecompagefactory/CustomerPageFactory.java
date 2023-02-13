package telecompagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilites.CommanUtilites;

import Utilites.ExcelUtilites;

import junit.framework.Assert;
import telecomlisteners.Listener;



public class CustomerPageFactory {

	
	WebDriver driver;
	private int alertTimeOut;
	public static String new_Customer_Id;
	ExtentTest extentTest;
	ExtentReports extentReport;
	
	
	public static String getNew_Customer_Id() {
		return new_Customer_Id;
	}


	public static void setNew_Customer_Id(String new_Customer_Id) {
		CustomerPageFactory.new_Customer_Id = new_Customer_Id;
	}


	public  CustomerPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}
	
	
	public void setAlertTimeOut(int alertTimeOut) {
		this.alertTimeOut = alertTimeOut;
	}
//			
	@FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div/header/h1")
	WebElement cust_Page_Heading;
	
	@FindBy(how=How.XPATH,using="//a[text()='Add Customer']")
	WebElement cust_Link;

	@FindBy(how=How.ID,using="fname")
	WebElement cust_first_Name;


	@FindBy(xpath="//*[@id=\"main\"]/div/div/table/tbody/tr[1]/td[2]/h3")
	WebElement Cust_id;

	@FindBy(xpath="//*[@id=\"main\"]/div/div/ul/li/a")
	WebElement home_Button;
	
	@FindBy(how=How.ID,using="lname")
	WebElement cust_Last_Name;

	@FindBy(how=How.ID,using="email")
	WebElement cust_Email ;

	@FindBy(how=How.XPATH,using="//textarea[@id=\"message\"]")
	WebElement cust_Address;

	@FindBy(how=How.ID,using="telephoneno")
	WebElement cust_Mobile_No;

	@FindBy(how=How.XPATH,using="//input[@name=\"submit\"]")
	WebElement submit;

	@FindBy(how=How.XPATH,using="//label[text()='Done']")
	WebElement radio_Done;
	
	
	

	public void createValidCustomer(String firstName, String lastName, String email, String address, String mobie_No) throws Exception {
				
		cust_Link.click();
		Assert.assertEquals( cust_Page_Heading.getText(), CustomerConstants.addCustomer);
		radio_Done.click();
		cust_first_Name.sendKeys(firstName);
		cust_Last_Name.sendKeys(lastName);
		cust_Email.sendKeys(email);
		cust_Address.sendKeys(address);
		cust_Mobile_No.sendKeys(mobie_No);
		submit.click();
		new_Customer_Id=Cust_id.getText();
		System.out.println(new_Customer_Id);
		ExcelUtilites.writeToExcel();
		home_Button.click();
	}


	
	public void createBlankCustomer() throws Exception {
		cust_Link.click();
		Assert.assertEquals( cust_Page_Heading.getText(), CustomerConstants.addCustomer);
		submit.click();
		String alertText=CommanUtilites.waitAlert(driver,alertTimeOut);
		Assert.assertEquals(alertText, CustomerConstants.addCustomerAlert);
		System.out.println(alertText);
		driver.switchTo().alert().accept();
	}

}
