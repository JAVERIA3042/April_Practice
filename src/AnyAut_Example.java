import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnyAut_Example {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://anyaut.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	
	int size = driver.findElements(By.tagName("iframe")).size();
	System.out.println(size);
	 driver.findElement(By.xpath("//iframe[@class='embed-responsive-item']")).click();
	//System.out.println(Text);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Javeria Khaliq\\eclipse-workspace\\EXCEl\\Results\\Screenshot.jpg" ));

}

}