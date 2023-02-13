package telecomBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utilites.BrowserSelector;
import Utilites.BrowserType;
import Utilites.WindowHandle;
import telecomlisteners.Listener;



public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	static WindowHandle handler;

	@BeforeMethod
	public void loadConfig() throws FileNotFoundException, IOException {
		prop=new Properties();
		prop.load(new FileInputStream("./Resource/config.properties"));
		System.out.println("launching the browser");
		driver= BrowserSelector.getDriver(BrowserType.Chrome);
		Listener.setDriver(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		handler=new WindowHandle(driver);
		handler.windowHandler();
	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
