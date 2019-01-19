package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
	
	@FindBy(how=How.ID, using="email_create")
	public static WebElement myemail;
	
	@FindBy(how=How.ID, using="SubmitCreate")
	public static WebElement create_an_account;
	
	@FindBy(how=How.ID, using="postcode-input") 
	public static WebElement mypostcode;
	
	@FindBy(how=How.ID, using="submitAccount")
	public static WebElement submit_button;

	
	public void type_email(String email){
		myemail.sendKeys(email);
	}
	
	public void iClick_create_account(){
        create_an_account.click();
	}
	
	public void type_postcode(String postcode){
		mypostcode.sendKeys(postcode);
	}

	
	public void click_submit_button(){
		submit_button.click();
	}

}
