package Steps;

import Helper.testBase;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;
import pages.SigninPage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Common extends testBase{
	
	
	@Before
	public void setup() throws IOException{
		initialize();
	}

    @Given("^I am on the Homepage$")
    public void i_am_on_the_Homepage() throws Throwable {
        driver.get(CONFIG.getProperty("testSiteName"));
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Given("^I click sigin button$")
    public void i_click_sigin_button() throws Throwable {
        SigninPage signinpage = PageFactory.initElements(driver, SigninPage.class);
        signinpage.click_signin();

    }

    @Given("^I enter email address in the address field$")
    public void i_enter_email_address_in_the_address_field() throws Throwable {
        random = 100 + (int)(Math.random() * ((1000 - 1) + 1));
        RegisterPage registerpage = PageFactory.initElements(driver, RegisterPage.class);
        registerpage.type_email("maxtest" + random + "@gmail.com");
        System.out.println(random);

    }

    @Given("^I click create new account button$")
    public void i_click_create_new_account_button() throws Throwable {
        RegisterPage registerpage = PageFactory.initElements(driver, RegisterPage.class);
        registerpage.iClick_create_account();
        Thread.sleep(4000);
    }

    @Then("^I see mobile container title message$")
    public void i_see_mobile_container_title_message() throws Throwable {
        Assert.assertEquals("AndroidContainerTest1", driver.findElement(By.className("android.widget.TextView")).getText());
    }



}
