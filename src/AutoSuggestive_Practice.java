import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive_Practice {

	public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	
	
	driver.findElement(By.xpath("//input[@id='fromCity']")).click();
	WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));
	Thread.sleep(2000);
	source.click();
	
	Thread.sleep(2000);
	source.sendKeys("MUM");
	Thread.sleep(2000);
	
	source.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	source.sendKeys(Keys.ENTER);
	source = driver.findElement(By.xpath("//input[@placeholder='To']"));
	Thread.sleep(2000);
	source.sendKeys("DEH");
	Thread.sleep(2000);

	//for(int i=1; i<6; i++) {
		source.sendKeys(Keys.ARROW_DOWN);
	//}
	source.sendKeys(Keys.ENTER);
	
	
	}

}
