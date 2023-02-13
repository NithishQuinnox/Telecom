package telecomtestpage;

import org.testng.annotations.Test;
import Utilites.CommanUtilites;
import telecomBase.BaseClass;
import telecomlisteners.Listener;
import telecompagefactory.CustomerPageFactory;
import telecompagefactory.PayBillPageFactory;


public class PayBillTest extends BaseClass {

	CustomerPageFactory cus;
	PayBillPageFactory  pay_bill;



	@Test()
	public void addNoBillDetails() {
		pay_bill=new  PayBillPageFactory (driver);
		Listener.setDriver(driver);
		pay_bill .setAlertTimeOut((Integer.parseInt(prop.getProperty("alertTimeOut"))));
		pay_bill.addNoBillPayDetails();
	}


	@Test(dataProvider="getCustomerData",dataProviderClass= CommanUtilites.class)
	public void payBill(String fname,String lname,String email,String address,String phoneno) throws Exception {
		pay_bill=new PayBillPageFactory (driver);
		Listener.setDriver(driver);
		cus=new CustomerPageFactory(driver);
		cus.createValidCustomer(fname, lname, email, address, phoneno);
		pay_bill.payBills(CustomerPageFactory.getNew_Customer_Id());


	}

}
