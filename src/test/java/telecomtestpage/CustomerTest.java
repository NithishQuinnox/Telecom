package telecomtestpage;


import org.testng.annotations.Test;
import Utilites.CommanUtilites;
import telecomBase.BaseClass;
import telecomlisteners.Listener;
import telecompagefactory.CustomerPageFactory;




public class CustomerTest extends BaseClass {
	 CustomerPageFactory cus;
	
	


	@Test()
	public void addNocustomerDetails() throws Exception {
		cus=new CustomerPageFactory(driver);
		Listener.setDriver(driver);
		cus.setAlertTimeOut((Integer.parseInt(prop.getProperty("alertTimeOut"))));
		cus.createBlankCustomer();
	}


	@Test(dataProvider="getCustomerData",dataProviderClass= CommanUtilites.class)
	public void addCustomerDetails(String fname,String lname,String email,String address,String phoneno) throws Exception {
		cus=new  CustomerPageFactory(driver);
		Listener.setDriver(driver);
		cus.createValidCustomer(fname, lname, email, address, phoneno);

	}



}
