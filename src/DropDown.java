import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	WebDriver driver;
	@Before
	public void myBefore() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://book.spicejet.com");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
	}
		
		@Test
		public void myTest() throws Exception {
		Select selectDropdown = new Select(driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency")));
		selectDropdown.selectByValue("INR");
		Thread.sleep(2000);
		selectDropdown.selectByValue("AED");
		Thread.sleep(2000);
		selectDropdown.selectByVisibleText("USD");
		Thread.sleep(2000);
		}
		@After
		public void myAfter() {
		//driver.close();
	}

}