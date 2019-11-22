import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class AnyAut_Application {
	static String[][] xTD;
	static String xlPath;
	static String xlSheet;
	static String xlPath_Res;
	static WebDriver driver;

	@Before
	public void myBefore() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://anyaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Read the Test Data Excel into a 2D array.
		 xlPath = "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\AnyAut.xls";
		 xlSheet = "FirstScenario";
		 xTD = readXL(xlPath, xlSheet );
		 
		 xlPath_Res = "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\AnyAut_Res.xls";
		
		
	}
	
	
	@Test
	public void Video() throws Exception {
	System.out.println("****************** Test 1 Video Start Here ************************");
	 
		driver.findElement(By.xpath("//iframe[@class='embed-responsive-item']")).click();
		 System.out.println(driver.findElement(By.xpath("//iframe[@class='embed-responsive-item']")).isDisplayed());
		 Thread.sleep(3000);
	                                                                                             
	}
	
	@Test
	public void Feature() throws Exception {
		System.out.println("****************** Test 2 Feature Start Here ************************");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='page-scroll']//a[contains(text(),'Features')]")).click();
		int size = driver.findElements(By.xpath("//*[@id='features']/div/div[2]/center/div")).size();
		System.out.println(size);
        JavascriptExecutor js = (JavascriptExecutor) driver;
		//Find element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.xpath("//*[@id='features']/div/div[2]"));
        //This will scroll the page till the element is found		
        System.out.println("Element displayed" + Element.isDisplayed());
        
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(2000);
		highLighterMethod(driver,Element);
		
		String expected = "SELENIUM + JAVA Power of Selenium WebDriver with Java/TestNG helps to launch cross browser + functional tests at ease. It also adds significantly to speed of Testing perfect for regression and functional testing.";
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scrFile, new File("C:\\Users\\Javeria Khaliq\\eclipse-workspace\\EXCEl\\Results\\Screenshot.jpg" ));		
		String actual = Element.getText();
        System.out.println(actual);
        
    if(expected.equalsIgnoreCase(actual)){
        System.out.println("Pass");
            }
        else {
            System.out.println("Fail");
            
            
        }	
	}
	public void highLighterMethod(WebDriver driver, WebElement element){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		 }
	
	
	@Test
	public void pricing() throws Exception {
		System.out.println("****************** Test 3 Pricing Start Here ************************");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Pricing')]")).click();
		WebElement pricing = driver.findElement(By.xpath("//div[@class='container-fluid']"));
		System.out.println(pricing.isDisplayed());
		System.out.println(pricing.getText());
	}
	
	@Test
	public void contact() throws Exception {
		System.out.println("****************** Test 3 Pricing Start Here ************************");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//section[@id='contact']")).click();
		List<WebElement> size = driver.findElements(By.xpath("//form[@id='sentMessage']/div//following-sibling::label"));
		for(WebElement eachChild : size) {
			System.out.println(eachChild.getAttribute("innerHTML"));
			//alm-----------
		}
	}
	
	
	@After
	public void myAfter() throws Exception {
		writeXL(xlPath_Res, "AnyAUT_Test", xTD);
		System.out.println("Driver close Successfully");
		driver.close();	
	}	
	//*********************************** Utility Function**************************
			public static String[][] readXL(String fPath, String fSheet) throws Exception{
				//Input: XL Path and XL Sheet name.
				//output:
				String[][] xData;
				int xRows, xCols;
				DataFormatter dataFormatter = new DataFormatter();
				String cellValue;
				
				//Get the worksheet
				File myxl = new File(fPath);
				FileInputStream myStream = new FileInputStream(myxl);
				HSSFWorkbook myWB = new HSSFWorkbook(myStream);
				HSSFSheet mySheet = myWB.getSheet(fSheet);
				
				//Count rows and Columns. Create empty 2D array.
				xRows = mySheet.getLastRowNum()+1;
				xCols = mySheet.getRow(0).getLastCellNum();
				xData = new String[xRows][xCols];
				System.out.println("rows: " + xRows);
				System.out.println("Column: " + xCols);
				
				System.out.println("~~~~~~~~~~~~~~~~~~~ Test Data Below ~~~~~~~~~~~~~~~~~~~~~~");
				for(int i=0; i<xRows; i++ ) {
					HSSFRow row = mySheet.getRow(i);
					for(int j =0; j<xCols; j++ ){
						cellValue= "-";
						cellValue = dataFormatter.formatCellValue(row.getCell(j));
						if(cellValue!=null) {
							xData[i][j] = cellValue;
						}
						System.out.print(cellValue);
						System.out.print("||||");

						
					}
					System.out.println("");

					
				}
				
				myxl = null;
				return xData;
					
				}
			
			public static void writeXL(String fPath, String fSheet, String[][] xData) throws Exception{
			
				File outFile = new File(fPath);
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet osheet = wb.createSheet(fSheet);
				int xR_TS = xData.length;
				int xC_TS = xData[0].length;
				
				for(int myrow=0; myrow<xR_TS; myrow++ ) {
					HSSFRow row = osheet.createRow(myrow);	
					for(int mycol =0; mycol < xC_TS; mycol++ ){
						HSSFCell cell = row.createCell(mycol);	
						//cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(xData[myrow][mycol]);
						}
					FileOutputStream fOut = new FileOutputStream(outFile);
					wb.write(fOut);
					fOut.flush();
					fOut.close();
						
					}
				wb = null;
				osheet = null;
				}
			}

