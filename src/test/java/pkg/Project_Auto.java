package pkg;


import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.time.Duration;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Project_Auto {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlload()
	{
		driver.get("https://ayurvivek.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void test1() throws Exception 
	{
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div/div/div[3]/div/button[2]/img")).click();
     driver.findElement(By.xpath("//*[@id=\"reg_email_1\"]")).sendKeys("jishnuvrj@gmail.com");
     driver.findElement(By.xpath("//*[@id=\"reg_password_1\"]")).sendKeys("vatejishnubaby");
     driver.findElement(By.xpath("//*[@id=\"customer_login_1\"]/div[2]/div/form/p[3]/button")).click();
 //    driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div/div/div[3]/div/button[2]/img")).click();
     //data driven
     
     
     File f=new File("C:\\Users\\manju\\Documents\\project_work.xlsx");
     FileInputStream fi=new FileInputStream(f);
	 XSSFWorkbook wb=new XSSFWorkbook(fi);
     XSSFSheet sh=wb.getSheet("Sheet1");
     System.out.println(sh.getLastRowNum());
     
     for(int i=1;i<=sh.getLastRowNum();i++)
     {
    	    String username=sh.getRow(i).getCell(0).getStringCellValue();
    	    System.out.println("username="+username);
    	    String password=sh.getRow(i).getCell(1).getStringCellValue();
    	    System.out.println("password="+password);
			driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
			driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
		
     }
  
 
	}
	@Test
	public void test2() throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[@id=\"mega-menu-item-82484\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div/div/div[3]/div/button[1]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"seachModel\"]/div/div/div[2]/form/div/input")).sendKeys("ointments");
		driver.findElement(By.xpath("//*[@id=\"seachModel\"]/div/div/div[2]/form/div/div/input")).click();
		driver.findElement(By.xpath("//*[@id=\"product-8683\"]/div[2]/form/div/div[2]/button")).click();
		
		//alert handle
		driver.switchTo().alert().accept(); 
		
		//select from drop down
		WebElement chooselement=driver.findElement(By.xpath("//*[@id=\"choose\"]"));
		Select value=new Select(chooselement);
		value.selectByValue("60G");
		driver.findElement(By.xpath("//*[@id=\"product-8683\"]/div[2]/form/div/div[2]/button")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div/div/div[3]/div/button[3]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"offcanvas-cart\"]/div[2]/div/div/div[2]/div/a[1]")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"mega-menu-item-14001\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/ul/li[2]/a")).click();
		driver.navigate().back();
		driver.navigate().back();
		
		//scroll
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,5000)", "");
				
		//response code
	   @SuppressWarnings("deprecation")
		URL ob=new URL("https://ayurvivek.com/");
		HttpURLConnection con=(HttpURLConnection)ob.openConnection();
		con.connect();
		if(con.getResponseCode()==200)
		{
			System.out.println("valid url");
		}
		else
		{
			System.out.println("invalid url");
		}
		
		//screenshot
		WebElement privacy=driver.findElement(By.xpath("//*[@id=\"page\"]/footer/div[2]/div/div/div[2]/div[2]/div/ul/li[3]/a"));
		File scrnshts=privacy.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrnshts, new File("./Screenshot//privacypolicy.png"));
		
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		String exp="Home - Ayur Vivek";
		if(actualtitle.equals(exp))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
		}
		driver.navigate().refresh();
		
		
		//window handles
		String parentWindow=driver.getWindowHandle();
		System.out.println("parent window Title " +driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"page\"]/footer/div[3]/div/div/small/a")).click();
		
		Set<String> allwindowhandles = driver.getWindowHandles();
		
		for(String handle:allwindowhandles)
		{
			System.out.println(handle);
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("//*[@id=\"slider-1-slide-1-layer-2\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"wpcf7-f451-o1\"]/form/div[2]/p[1]/span/input")).sendKeys("minnu");
				driver.findElement(By.xpath("//*[@id=\"wpcf7-f451-o1\"]/form/div[2]/p[2]/span[1]/input")).sendKeys("minnu@gmail.com");
				driver.findElement(By.xpath("//*[@id=\"wpcf7-f451-o1\"]/form/div[2]/p[2]/span[2]/input")).sendKeys("3239263047");
				WebElement selectelement=driver.findElement(By.xpath("//*[@id=\"wpcf7-f451-o1\"]/form/div[2]/p[2]/label/span/select"));
				Select value1=new Select(selectelement);
				value1.selectByValue("Evening");
				driver.findElement(By.xpath("//*[@id=\"wpcf7-f451-o1\"]/form/div[2]/p[2]/span[3]/input")).sendKeys("101020");
				driver.findElement(By.xpath("//*[@id=\"wpcf7-f451-o1\"]/form/div[2]/p[3]/input")).click();
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
		
		driver.findElement(By.xpath("//*[@id=\"page\"]/a/i")).click();
			
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
