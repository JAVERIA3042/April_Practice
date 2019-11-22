import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_SW {
	WebDriver driver;
@Before
public void myBefore() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("https://swiggy.com/");
	
}
	
@Test
public void myTest() throws Exception {
	System.out.println("Test # 1");
	driver.findElement(By.linkText("Login")).click();
	driver.findElement(By.id("mobile")).sendKeys("123456789");
	Thread.sleep(2000);
	
}


@Test
public void myTest1() throws Exception {
	System.out.println("Test # 2");
	driver.findElement(By.linkText("Login")).click();
	driver.findElement(By.name("mobile")).sendKeys("1234568791");
	Thread.sleep(2000);
}

@After
public void myAfter() {
	driver.close();
	
}

}
