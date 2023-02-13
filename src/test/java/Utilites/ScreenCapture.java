package Utilites;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCapture {

	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("./Images/" + System.currentTimeMillis() + ".png");
		String errssflpath = Dest.getAbsolutePath();



		Files.copy(scrFile.toPath(), Dest.toPath());
		return errssflpath;
		}

}
