package testCases;

import java.sql.Driver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.signUp;

public class InstaSignUp {

	WebDriver driver;
	signUp su;
	
	public String emailgenerate() {
		Random rand = new Random();
		int n= rand.nextInt(200); 
		String num = Integer.toString(n);
		String finalString= "anmol"+num+"@yopmail.com";
		return finalString;
	}
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "B:\\Automation\\sel-jars\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseURL = "http://instacei.com/home";
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void test() throws InterruptedException {
		String email = emailgenerate();
		su = new signUp(driver);
		su.trigerSignUp();
		su.enterData("Anmol", "Gupta", "AV", email, "12345678", "12345678");
		su.submit();
		Thread.sleep(10000);
		
		Alert alertclose = driver.switchTo().alert();
		alertclose.accept();
	}
	
	@AfterTest
	public void shutdown() {
		driver.close();
	}
	
}
