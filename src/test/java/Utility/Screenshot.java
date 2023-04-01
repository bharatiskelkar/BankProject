package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static void sc(WebDriver driver ,int TestID ) throws IOException {
		 DateTimeFormatter date= DateTimeFormatter.ofPattern("yyyy-MM-dd HH mm ss");
		 LocalDateTime xyz=LocalDateTime.now();
		 String newdate = date.format(xyz);
		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File destination = new File("Screenshot//Test-"+TestID+" "+ date.format(xyz)+".jpeg");
		 FileHandler.copy(source, destination);
	}

}
