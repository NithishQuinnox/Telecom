package telecomtestpage;

import org.testng.annotations.Test;
import Utilites.CommanUtilites;
import telecomBase.BaseClass;
import telecomlisteners.Listener;
import telecompagefactory.CustomerPageFactory;
import telecompagefactory.TariffPlansPageFactory;

public class TraiffTest extends BaseClass{

	CustomerPageFactory cus;
	TariffPlansPageFactory   Tariff1;
	public static String cust_id;


	@Test(description="adding no tariff details")
	public void addNoTariffPlan() {
		Tariff1 =new TariffPlansPageFactory(driver);
		Listener.setDriver(driver);
		Tariff1.setAlertTimeOut((Integer.parseInt(prop.getProperty("alertTimeOut"))));
		Tariff1.AddBlankTariff();
	}



	@Test(dataProvider="getTariff",dataProviderClass=CommanUtilites.class)
	public void addTraiffPlan(String rental,String localmins,String intermins,String smspacks,
			String mincharges,String intercharges,String smscharges) throws Exception {
		Tariff1 =new TariffPlansPageFactory(driver);
		Listener.setDriver(driver);
		Tariff1.AddTariff(rental, localmins, intermins, smspacks, mincharges, intercharges, smscharges);
	}




	@Test(dataProvider="getCustomerData",dataProviderClass= CommanUtilites.class)
	public void addTariffToNewCustomer(String fname,String lname,String email,String address,String phoneno) throws Exception {
		cus=new CustomerPageFactory(driver);
		cus.createValidCustomer(fname, lname, email, address, phoneno);
		TariffPlansPageFactory tariff=new TariffPlansPageFactory(driver);
		tariff.addValidTariffToNewCustomer(CustomerPageFactory.getNew_Customer_Id());
	}



	@Test(dataProvider="getCustomerData",dataProviderClass= CommanUtilites.class)
	public void addNoTariffToNewCustomer(String fname,String lname,String email,String address,String phoneno) throws Exception {
		cus=new CustomerPageFactory(driver);
		cus.createValidCustomer(fname, lname, email, address, phoneno);
		TariffPlansPageFactory tariff=new TariffPlansPageFactory(driver);
		tariff.setAlertTimeOut((Integer.parseInt(prop.getProperty("alertTimeOut"))));
		tariff.AddBlankTariffToNewCustomer();

	}


}
