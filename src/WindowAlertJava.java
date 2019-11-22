import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAlertJava {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://demo.guru99.com/test/delete_customer.php");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("312566");
	driver.findElement(By.xpath("//input[@name='submit']")).click();
	driver.switchTo().alert().accept();
	
	String stringalert = driver.switchTo().alert().getText();
	
	System.out.println(stringalert);
	Thread.sleep(2000);
	
	
	driver.switchTo().alert().accept();
	
	//driver.close();
	}

}
