package Utilites;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class CommanUtilites {

	public static String waitAlert(WebDriver driver,int alertTimeOut) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds( alertTimeOut));
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText =driver.switchTo().alert().getText();
		return alertText;
	}
	
	
	@DataProvider
	public Object[][] getCustomerData() {
		Object data[][]= ExcelUtilites.getTestData("customerInfo");
		return data;
	}
	
	@DataProvider
	public Object[][] getTariff() {
		Object data[][]=ExcelUtilites.getTestData("traiffplans");
		return data;
	}

}
