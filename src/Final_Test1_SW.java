import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Final_Test1_SW {
	WebDriver myD;
@Before
public void myBefore() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
	myD = new ChromeDriver();
	myD.navigate().to("https://swiggy.com/");
	myD.manage().window().maximize();

}

@Test
public void myTest() {
	myD.findElement(By.linkText("Login")).click();
	myD.findElement(By.name("mobile")).sendKeys("123343412356");
	System.out.println(" My Test pass successfully");
	
}

@Test
public void myTest1() {
	myD.findElement(By.linkText("Login")).click();
	myD.findElement(By.id("mobile")).sendKeys("2134214251");
	System.out.println("My Test 2 pass Successfull");
}

@After
public void myAfter() {
	myD.quit();
	
}


}
