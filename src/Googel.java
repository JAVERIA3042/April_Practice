import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googel {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
	  driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
	  if( driver.findElement(By.xpath("//input[@title='Search']")).isDisplayed()) {
		 System.out.println("Search Element found Successfully");
	  }
	  else {
		  System.out.println("Search Element not found on page");
	  }
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@class='LC20lb']")).click();

		
		//driver.close();
	  	//drive.quite();
	
	  
		
		
	}

}
