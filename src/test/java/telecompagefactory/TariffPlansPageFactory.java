package telecompagefactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilites.CommanUtilites;


public class TariffPlansPageFactory {


	WebDriver driver;
	private int alertTimeOut;
	private String  TariffPageText;
	String enterCust_Id_Label;

	public  TariffPlansPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}
	
	public void setAlertTimeOut(int alertTimeOut) {
		this.alertTimeOut = alertTimeOut;
	}

	@FindBy(xpath="//input[@id='customer_id']")
	WebElement cust_id;

	@FindBy(how=How.XPATH,using="//a[text()='Add Tariff Plan']")
	WebElement Tariff_Link;

	@FindBy(how=How.ID,using="rental1")
	WebElement rental;

	@FindBy(how=How.ID,using="local_minutes")
	WebElement local_Minutes;

	@FindBy(how=How.ID,using="inter_minutes")
	WebElement inter_Minutes;

	@FindBy(how=How.ID,using="sms_pack")
	WebElement sms_Pack;

	@FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div/header/h1")
	WebElement tariff_Page_Heading;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div/header/h1")
	WebElement tariffToNew_Page_Heading;

	@FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div/h2")
	WebElement onSubbmission_Msg;


	@FindBy(how=How.ID,using="minutes_charges")
	WebElement minutes_Charges;

	@FindBy(how=How.ID,using="inter_charges")
	WebElement inter_Charges;

	@FindBy(how=How.ID,using="sms_charges")
	WebElement sms_Charges;

	@FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div/ul/li/a")
	WebElement home;

	@FindBy(how=How.XPATH,using="//input[@value='submit']")
	WebElement submit;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Add Tariff Plan to Customer')]")
	WebElement add_Triff_Plan_Cust;

	@FindBy(how=How.XPATH,using="//input[@value='Add Tariff Plan to Customer']")
	WebElement add_Plans_To_Cust;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Home')]")
	WebElement home_Button;

	@FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div/h2")
	WebElement tariff_Page_Text;




	public void AddTariff(String ren, String localMinutes, String interMinutes, String smsPack, String minuteCharges,String interCharges,String smsCharges) throws Exception {
		Tariff_Link.click();
		Assert.assertEquals(tariff_Page_Heading.getText(), TariffConstants.addTariffHeading, "Heading do not match!");
		rental.sendKeys(ren);
		local_Minutes.sendKeys(localMinutes);
		inter_Minutes.sendKeys(interMinutes);
		sms_Pack.sendKeys(smsPack);
		minutes_Charges.sendKeys(minuteCharges);
		inter_Charges.sendKeys(interCharges);
		sms_Charges.sendKeys(smsCharges);
		submit.click();
		Assert.assertEquals(onSubbmission_Msg.getText(),  TariffConstants.addTariffOn_sub_Msg);
		home.click();
	}

	
	public void AddBlankTariff() {
		Tariff_Link.click();
		Assert.assertEquals(tariff_Page_Heading.getText(), TariffConstants.addTariffHeading);
		submit.click();
		String alertText=CommanUtilites.waitAlert(driver,alertTimeOut);
		Assert.assertEquals(alertText, TariffConstants.addNoTariffAlert_Msg);
		System.out.println(alertText);
		driver.switchTo().alert().accept();
	}

	

	public void addValidTariffToNewCustomer(String newCustomerId) {
		add_Triff_Plan_Cust.click();
		Assert.assertEquals(tariffToNew_Page_Heading.getText(),  TariffConstants.addTariffToNewCust_Heading,"Heading do not match!");
		enterCust_Id_Label= TariffConstants.enterTariff_CustId_Label;
		Assert.assertTrue(enterCust_Id_Label.contains(TariffConstants.enterTariff_CustId_Label), "Text  do not match!");
		cust_id.sendKeys (newCustomerId);
		submit.click();
		add_Plans_To_Cust.click();
		Assert.assertEquals( tariff_Page_Text.getText(), TariffConstants.addTariffNewCustOn_Sub_Msg);
		home_Button.click();

	}


	public void AddBlankTariffToNewCustomer() {
		add_Triff_Plan_Cust.click();
		Assert.assertEquals(tariffToNew_Page_Heading.getText(), TariffConstants.addTariffToNewCust_Heading,"Heading do not match!");
		submit.click();
		String alertText=CommanUtilites.waitAlert(driver,alertTimeOut);
		Assert.assertEquals(alertText, TariffConstants.addNoTariffNewCust_Alert_Msg);
		System.out.println(alertText);
		driver.switchTo().alert().accept();
	}

}
