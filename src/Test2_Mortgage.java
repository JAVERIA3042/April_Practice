import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2_Mortgage {
	WebDriver driver;
	String myMonthlyPayment ;
	String expectedMonthlyPament = "$1,392.19";
	
	
@Before
public void myBefore() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.navigate().to("https://www.mortgagecalculator.org/");
	driver.manage().window().maximize();
}
@Test
public void myTest() {
	System.out.println("Test 1 is begin");
	driver.findElement(By.id("homeval")).clear();
	driver.findElement(By.id("homeval")).sendKeys("400000");
	
	driver.findElement(By.id("downpayment")).clear();
	driver.findElement(By.id("downpayment")).sendKeys("112000");
	
	driver.findElement(By.id("loanamt")).clear();
	driver.findElement(By.id("loanamt")).sendKeys("300000");
	
	driver.findElement(By.id("intrstsrate")).clear();
	driver.findElement(By.id("intrstsrate")).sendKeys("2");
	driver.findElement(By.name("cal")).click();
		
	
	comapareResult();
}

public void comapareResult() {
	myMonthlyPayment = driver.findElement(By.xpath("(//h3)[2]")).getText();
	
	System.out.println("My Monthly payment is " + myMonthlyPayment);
	System.out.println("My Expected monthly payment is " + expectedMonthlyPament);
	
	
	if(myMonthlyPayment.equals(expectedMonthlyPament)) {
		System.out.println(" Test Pass");
	}else {
		System.out.println(" Test Failed ");
	}
}
@After
public void myAfter() {
	driver.close();
	
}
}
