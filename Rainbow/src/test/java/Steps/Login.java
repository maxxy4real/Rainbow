package Steps;

import Helper.testBase;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.SigninPage;

import java.io.IOException;

public class Login extends testBase{
	
	@Before
	public void setup() throws IOException{
		initialize();
	}

    @When("^I enter email \"([^\"]*)\" details$")
    public void i_enter_email_details(String email) throws Throwable {
        SigninPage signinpage = PageFactory.initElements(driver, SigninPage.class);
        signinpage.type_username(email);
    }

    @When("^I enter password \"([^\"]*)\" details$")
    public void i_enter_password_details(String password) throws Throwable {
        SigninPage signinpage = PageFactory.initElements(driver, SigninPage.class);
        signinpage.type_password(password);
    }

    @Then("^I verify that I am logged in$")
    public void i_verify_that_I_am_logged_in() throws Throwable {
        Assert.assertEquals("Mike Smith", driver.findElement(By.cssSelector("span")).getText());
    }

    @Then("^I verify that \"([^\"]*)\" is logged in$")
    public void iVerifyThatIsLoggedIn(String user) throws Throwable {
        Assert.assertEquals(user, driver.findElement(By.cssSelector("span")).getText());
    }

    @When("^I click Signin button$")
    public void i_click_Signin_button() throws Throwable {
        SigninPage signinpage = PageFactory.initElements(driver, SigninPage.class);
        signinpage.click_loginBtn();
    }

	@When("^I log out successfully$")
	public void i_log_out_successfully() throws Throwable {
        driver.findElement(By.linkText("Sign out")).click();
	}

    @Then("^I see an error \"([^\"]*)\" message details$")
    public void i_see_an_error_message_details(String errormessage) throws Throwable {
        Assert.assertEquals(errormessage, driver.findElement(By.cssSelector("ol > li")).getText());
    }



}
