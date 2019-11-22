import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		driver.manage().window().maximize();
		driver.getTitle();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@value = 'Milk']")).click;
		driver.findElement(By.xpath("//input[@value = 'Milk']")).click();
		int count = driver.findElements(By.xpath("//input[@name = 'group1']")).size(); 
		
		for(int i=0; i<count; i++) {
			//driver.findElements(By.xpath("//input[@name = 'group1']")).get(i).click();
			//System.out.println(driver.findElements(By.xpath("//input[@name = 'group1']")).get(i).getAttribute("value"));
		String text = driver.findElements(By.xpath("//input[@name = 'group1']")).get(i).getAttribute("value");
		if(text.equals("Cheese")){
			driver.findElements(By.xpath("//input[@name = 'group1']")).get(i).click();
			System.out.println(" Successfully run ");
		}
		}

	}

}
