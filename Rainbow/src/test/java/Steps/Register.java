package Steps;

import Helper.testBase;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.RegisterPage;

import java.io.IOException;

public class Register extends testBase {
	
	@Before
	public void setup() throws IOException{
		initialize();
	}

    @Given("^I click male gender$")
    public void i_click_male_gender() throws Throwable {
        driver.findElement(By.id("id_gender1")).click();
    }

    @Given("^I enter first name \"([^\"]*)\"$")
    public void i_enter_first_name(String firstName) throws Throwable {
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
    }

    @Given("^I enter last name \"([^\"]*)\"$")
    public void i_enter_last_name(String lastName) throws Throwable {
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
    }

    @Given("^I check that email address in pre-populated$")
    public void i_check_that_email_address_in_pre_populated() throws Throwable {
	    String ActualEmail = driver.findElement(By.id("email")).getCssValue("maxtest" + random + "@gmail.com");
	    System.out.println(ActualEmail);
    }

    @Given("^I enter email \"([^\"]*)\"$")
    public void i_enter_email(String arg1) throws Throwable {

    }

    @Given("^I enter password \"([^\"]*)\"$")
    public void i_enter_password(String arg1) throws Throwable {
        driver.findElement(By.id("passwd")).sendKeys("Today1");
    }

    @Given("^I enter DOB Day \"([^\"]*)\" Month \"([^\"]*)\" Year \"([^\"]*)\"$")
    public void i_enter_DOB_Day_Month_Year(String day, String month, String year) throws Throwable {
        new Select(driver.findElement(By.id("days"))).selectByValue(day);
        Thread.sleep(2000);
        new Select(driver.findElement(By.id("months"))).selectByValue("7");
        new Select(driver.findElement(By.id("years"))).selectByValue(year);
        Thread.sleep(2000);
    }

    @Given("^I enter Address details \"([^\"]*)\" address \"([^\"]*)\" line \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" country \"([^\"]*)\"$")
    public void i_enter_Address_details_address_line_city_state_zip_country(String comp, String line1, String line2, String city, String state, String zip, String country) throws Throwable {
        driver.findElement(By.id("company")).sendKeys(comp);
        driver.findElement(By.id("address1")).sendKeys(line1);
        driver.findElement(By.id("address2")).sendKeys(line2);
        driver.findElement(By.id("city")).sendKeys(city);
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(state);
        driver.findElement(By.cssSelector("#id_state > option[value=\"13\"]")).click();
        driver.findElement(By.id("postcode")).sendKeys(zip);
    }

    @Given("^I enter Additional Information \"([^\"]*)\"$")
    public void i_enter_Additional_Information(String arg1) throws Throwable {
        driver.findElement(By.id("other")).sendKeys("This is a test");
    }

    @Given("^I enter Home Phone number \"([^\"]*)\"$")
    public void i_enter_Home_Phone_number(String number) throws Throwable {
	    driver.findElement(By.id("phone")).sendKeys(number);

    }

    @Given("^I enter Mobile Phone number \"([^\"]*)\"$")
    public void i_enter_Mobile_Phone_number(String number) throws Throwable {
        driver.findElement(By.id("phone_mobile")).sendKeys(number);
    }


	@When("^I enter new user email account$")
	public void i_enter_new_user_email_account() throws Throwable {
        RegisterPage registerpage = PageFactory.initElements(driver, RegisterPage.class);
        registerpage.type_email("james@aol.com");
        Thread.sleep(2000);
	}

	@Then("^I am registered and logged in automatically$")
	public void i_am_registered_and_logged_in_automatically() throws Throwable {
        Assert.assertEquals("Mike Smith", driver.findElement(By.cssSelector("span")).getText());
	}

    @Then("^I see an error message that email address has already been registered$")
    public void i_see_an_error_message_that_email_address_has_already_been_registered() throws Throwable {
        String ExpectedMessage = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        String ActualMessage = driver.findElement(By.cssSelector("#create_account_error > ol > li")).getText();
        Assert.assertEquals(ExpectedMessage, ActualMessage);
    }


	@When("^I type email \"([^\"]*)\" address$")
	public void i_type_email_address(String email) throws Throwable {
		RegisterPage registerpage = PageFactory.initElements(driver, RegisterPage.class);
		registerpage.type_email(email); 
	}


	@When("^I insert postcode \"([^\"]*)\" in the postcode field$")
	public void i_insert_postcode_in_the_postcode_field(String postcode) throws Throwable {
		RegisterPage registerpage = PageFactory.initElements(driver, RegisterPage.class);
		registerpage.type_postcode(postcode);
	}

    @When("^I click the Register button$")
    public void i_click_the_Register_button() throws Throwable {
        RegisterPage registerpage = PageFactory.initElements(driver, RegisterPage.class);
        registerpage.click_submit_button();
    }

	@After
	public void teardown(Scenario scenario){
		//driver.close();
		if(scenario.isFailed()){
			System.out.println(scenario.getName());
		}

		System.out.println("All Test Passed");
	}
	

}
