package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SigninPage {


    @FindBy(how=How.LINK_TEXT, using="Sign in")
    public static WebElement signin;

    @FindBy(how=How.ID, using="email")
	public static WebElement myemail;
	
	@FindBy(how=How.ID, using="passwd")
	public static WebElement mypassword;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	public static WebElement login_button;


    public void click_signin(){
        signin.click();
    }

    public void type_username(String username){
        myemail.sendKeys(username);
	}
	
	public void type_password(String password){
		mypassword.sendKeys(password);
	}
	
	public void click_loginBtn(){
        login_button.click();
	}

}
