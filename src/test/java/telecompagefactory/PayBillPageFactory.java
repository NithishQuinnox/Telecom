package telecompagefactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import Utilites.CommanUtilites;


public class PayBillPageFactory {

	private int alertTimeOut;
	private WebDriver driver;
	String enter_Cust_Label;

	public  PayBillPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}


	public void setAlertTimeOut(int alertTimeOut) {
		this.alertTimeOut = alertTimeOut;
	}

	@FindBy(xpath="//*[@id=\"main\"]/div/header/h1")
	WebElement billPage_Heading;

	@FindBy(xpath="//*[@id=\"main\"]/div/form/div/div[2]/h3")
	WebElement billPage_Label;


	@FindBy(xpath="//input[@name='customer_id']")
	WebElement cust_id;

	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;


	@FindBy(how=How.XPATH,using="//a[contains(text(),'Pay Billing')]")
	WebElement cust_BillPay_Link;


	public void payBills(String newCustomerId) {
		cust_BillPay_Link.click();
		Assert.assertEquals( billPage_Heading.getText(),  PayBillConstants.payBill_Heading, "Headings do not match!");
		enter_Cust_Label= PayBillConstants.enterBill_CustId_Label;
		Assert.assertTrue(enter_Cust_Label.contains(PayBillConstants.enterBill_CustId_Label), "Label does not match!");
		cust_id.sendKeys(newCustomerId);
		submit.click();
	}


	
	public void addNoBillPayDetails() {
		cust_BillPay_Link.click();
		Assert.assertEquals( billPage_Heading.getText(), PayBillConstants.payBill_Heading , "Headings do not match!");
		submit.click();
		String alertText=	CommanUtilites.waitAlert(driver,alertTimeOut);
		Assert.assertEquals(alertText, PayBillConstants.addNoBill_Alert_Msg);
		System.out.println(alertText);
		driver.switchTo().alert().accept();
	}
}


