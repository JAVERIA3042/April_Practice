import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDown {
	WebDriver driver;
	@Before
	public void myBefore() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.navigate().to("https://book.spicejet.com");	
	driver.manage().window().maximize();
	System.out.println(driver.getTitle());
	}
	
	@Test
	public void myTest() throws Exception {
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i=1; i<5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		}
		Thread.sleep(2000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		
	}
	
	@After
	public void myAfter() {
	driver.close();
		
	}

}
