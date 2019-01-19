package Steps;

import Helper.testBase;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

    public class Search  extends testBase {

        @Before
        public void setup() throws IOException {
            initialize();
        }

        @When("^I search for \"([^\"]*)\" in the search input box$")
        public void i_search_for_in_the_search_input_box(String value) throws Throwable {
            driver.findElement(By.id("search_query_top")).sendKeys(value);
            driver.findElement(By.name("submit_search")).click();
            Thread.sleep(1000);
        }

        @Then("^I see \"([^\"]*)\" product listing page$")
        public void i_see_product_listing_page(String arg1) throws Throwable {
            Assert.assertEquals("1 result has been found.", driver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter")).getText());
        }


        @Then("^I see search description \"([^\"]*)\" price \"([^\"]*)\" and item \"([^\"]*)\"$")
        public void i_see_search_description_price_and_item(String arg1, String arg2, String arg3) throws Throwable {
            Assert.assertEquals(arg1, driver.findElement(By.cssSelector("div.right-block > h5 > a")).getText());
            Assert.assertEquals(arg2, driver.findElement(By.cssSelector("div.right-block > div.content_price > span")).getText());
            Assert.assertEquals(arg3, driver.findElement(By.cssSelector("div > div.right-block > span > span")).getText());
        }

        @When("^I click Add to cart button$")
        public void i_click_Add_to_cart_button() throws Throwable {
            //to perform Scroll on application using  Selenium

//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.scrollBy(0,-1000)", "");
//            Thread.sleep(3000);

//            WebElement element = driver.findElement(By.cssSelector("div > div.left-block > div > a.product_img_link > img"));
//            //in order to click a non visible element
//            JavascriptExecutor js2 = (JavascriptExecutor)driver;
//            js2.executeScript("arguments[0].click();", element);
            driver.findElement(By.cssSelector("div > div.left-block > div > a.product_img_link > img")).click();
            Thread.sleep(4000);
            driver.switchTo().frame("product");
            driver.findElement(By.cssSelector("button[name=\'Submit\'] > span")).click();

            WebElement element = driver.findElement(By.cssSelector("button[name=\'Submit\'] > span"));
            //in order to click a non visible element
            JavascriptExecutor js3 = (JavascriptExecutor)driver;
            js3.executeScript("arguments[0].click();", element);

        }

        @Then("^I see that Item is added to bag$")
        public void i_see_that_Item_is_added_to_bag() throws Throwable {
            Assert.assertEquals(1, driver.findElement(By.cssSelector("span.ajax_cart_quantity.unvisible")).getText());
        }

 }
