package Utilites;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;



public class BrowserSelector {
	public static WebDriver driver;
	public static ChromeOptions options;

	public static WebDriver getDriver(BrowserType browser ){
		switch(browser) {
		case  Chrome:

			System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
			options =new ChromeOptions();
			options.addExtensions(new File(".//Resource//AdGuard//AdGuard.crx"));
			driver=new ChromeDriver( options);
			break;
			
		case Edge:
			System.setProperty("webdriver.edge.driver", "D:\\EdgeDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		default:
			System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
			options =new ChromeOptions();
			options.addExtensions(new File(".//Resource//AdGuard//AdGuard.crx"));
			driver=new ChromeDriver( options);
			break;

		}
		return driver;

	}
}
