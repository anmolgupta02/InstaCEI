package randomHandling;

//import java.awt.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptchaHandling {

	WebDriver driver; 
	String baseURL; 
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","B:\\Automation\\sel-jars\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "http://testcxid.xidinfinity.com/#/forgotpassword";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void captchaTest() throws InterruptedException {
		
		driver.get(baseURL);
		
//		Would work if the ids of both fields were different		
//		WebElement email = driver.findElement(By.id("exampleInputEmail1"));
//		email.sendKeys("coporatexidadmin@yopmail.com");
//		String captchaVal = JOptionPane.showInputDialog("Please enter the value of captcha");
//		WebElement captcha = driver.findElement(By.id("exampleInputEmail1"));
//		captcha.sendKeys(captchaVal);
//		WebElement Button = driver.findElement(By.className("btn-xID btn"));
//		Button.click();
//		
		//handling webelement having more than one iD 
		// list<webelement>  listele = driver.findelements(by.id("Img");
		//		syso(listele.size)
		//
		//		listele.get(0).click;
		//		listele.get(1).click;
		
		
		//WebElement sameElements;
		
		java.util.List<WebElement> fields = driver.findElements(By.id("exampleInputEmail1"));
		fields.get(0).sendKeys("cust1@yopmail.com");
		String captchaVal = JOptionPane.showInputDialog("Please enter the value of captcha");
		fields.get(1).sendKeys(captchaVal);
		WebElement Button = driver.findElement(By.xpath("/html/body/app-root/app-forgot-password/div/div/div[2]/form/div[4]/button"));
		Button.click(); 
		Thread.sleep(10000);
		
}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
		
		
		
}
	

