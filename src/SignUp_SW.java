import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUp_SW {
	WebDriver driver;
	@Before
	public void myBefore() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://swiggy.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void myTest() {
		driver.findElement(By.linkText("Sign up")).click();
		driver.findElement(By.id("mobile")).sendKeys("1243123150");
		driver.findElement(By.id("name")).sendKeys("Waqar");
		driver.findElement(By.id("email")).sendKeys("everjaveria@hotmail.com");
		driver.findElement(By.id("password")).sendKeys("dagFFDGDAHG");
		driver.findElement(By.linkText("CONTINUE")).submit();
		
	}
	@After
	public void myAfter() {
		//driver.close();
		
	}
}
