import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



//***********************************Dynamic DropDown ***********************************
public class DropDown_1 {
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
		driver.findElement(By.xpath("//*[@value='BLR']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("(//*[@value='MAA'])[2]")).click();
		
		//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTNR']

		driver.findElement(By.xpath("//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTNR'] //a[@value='MAA']")).click();
		
	}
	
	@After
	public void myAfter() {
		//driver.close();
		
	}

}
