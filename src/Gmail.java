import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {
	static String[][] xTD;
	static String xlPath;
	static String xlSheet;
	static String xlPath_Res;
	static WebDriver driver;
	int xlRows;
	
	String login_user;
	String Password;
		
	@Before
		public void myBefore() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		//Read the Test Data Excel into a 2D array.
		 xlPath = "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\GmailDDF.xls";
		 xlSheet = "Gmail";
		 xTD = readXL(xlPath, xlSheet );
		 
		 xlPath_Res = "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\GmailDDF_Res.xls";
		 
		 
		
			driver.get("https://mail.google.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				
			}
	 @Ignore	
	 public void myTest1() throws Exception {
		for(int i=1; i<xlRows; i++) {
			
			//check Execute flag
			login_user = xTD[i][3];
			/*
				if(login_user.equalsIgnoreCase("Y")) {
					
					System.out.println("Running the TDID:" + xTD[i][1]);
					//Get the TD into local variable
					Password = xTD[i][4];
					
					myInput();
					
				}
				else {
					System.out.println("Skipping the TDID:" +xTD[i][1]);
				}*/
				
			}
		
	}
	
	public void myInput() throws Exception {
		driver.findElement(By.id("identifierId")).sendKeys(login_user);
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(Password);		
		driver.findElement(By.id("passwordNext")).click();
			
	 System.out.println("Test Pass Successfully");
		
	}
	 @Test
		public void myTest() throws Exception {
		 	System.out.println("******************Test Start Here*************");
			driver.findElement(By.id("identifierId")).sendKeys("javeria.khaliq95@gmail.com");
			System.out.println(driver.findElement(By.id("identifierId")).isDisplayed());
			driver.findElement(By.id("identifierNext")).click();
			driver.findElement(By.cssSelector("input[name='password']")).sendKeys("22802280Javeria");		
			driver.findElement(By.id("passwordNext")).click();
				
		 System.out.println("Test Pass Successfully");

		}
	 
	 
	 @After
		public void myafter() throws Exception {
			writeXL(xlPath_Res, "Gmail_Test", xTD);
			System.out.println(" Closing the browser..........");
			driver.quit();
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


