package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class signUp {
	
	//Method1
	@FindBy(how=How.XPATH,using="/html/body/app-root/app-theme/div/div/div[1]/app-header/div[1]/nav/div/ul/li[9]/a/button") 
	@CacheLookup
	WebElement signUpTrigger;
	
	//Method2
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[2]/input")
	WebElement firstName;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[3]/input")
	WebElement lastName;
	

	@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[4]/input")
	WebElement companyName;
	

	@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[5]/input")
	WebElement email;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[6]/input")
	WebElement pass;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[7]/input")
	WebElement cpass;
	
	@FindBy (xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[8]/button")
	WebElement signUpButton;
	
	WebDriver driver;
	
	public signUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
		
	}

	public void trigerSignUp() {
		signUpTrigger.click();
	}
	public void enterData(String name, String lname, String ucomp, String uemail, String upass, String ucpass)  {
		firstName.sendKeys(name);
		lastName.sendKeys(lname);
		companyName.sendKeys(ucomp);
		email.sendKeys(uemail);
		pass.sendKeys(upass);
		cpass.sendKeys(ucpass);
	}	
	
	public void submit() {
		signUpButton.click();
	}
	
}
