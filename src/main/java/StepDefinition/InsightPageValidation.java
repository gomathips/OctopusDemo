package StepDefinition;

import DriverManagement.DriverManagement;
import PageObjects.InsightsPageObjects;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InsightPageValidation extends InsightsPageObjects {
    @Before
    public void start() throws Exception {
        driver.get(DriverManagement.getURL());
        driver.manage().window().maximize();
        try {
            WebElement popup = driver.findElement(By.id("ccc-notify-accept"));
            if(popup.isDisplayed()) {
                popup.click();

            }
        } catch (Exception e) {
            System.out.println("No popup");
        }

    }

    @Given("^Launch the URL$")
    public void launch_the_URL() throws Throwable {
        driver.get(DriverManagement.getURL());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Then("^Verify the expected message \"([^\"]*)\" in the landing page$")
    public void verify_the_expected_message_in_the_landing_page(String arg1) throws Throwable {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("hero-wrapper")));
        assertEquals(getLandingPageTextMessage().getText(), arg1);
    }

    @And("^Also verify Insight message \"([^\"]*)\"$")
    public void also_verify_Insight_message(String arg1) throws Throwable {
      assertEquals(getInsightMessage().getText(), arg1);
    }

    @When("^Top navigation bar exist in the page$")
    public void top_navigation_bar_exist_in_the_page() throws Throwable  {
        assertTrue(getTopNavigationBar().isDisplayed());
    }

    @When("^Click on octopus and verify the page is displayed \"([^\"]*)\" and navigate back to insight page$")
    public void click_on_octopus_and_verify_the_page_is_displayed_and_navigate_back_to_insight_page(
            String welcomemessage) throws Throwable {
        WebElement mapObject = getOctopusLogo();
        Actions builder = new Actions(driver);
        builder.click(mapObject).perform();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        assertEquals(getOctopusWelcomeMessage().getText(), welcomemessage);
        driver.navigate().back();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        assertEquals(getLandingPageTextMessage().getText(),"Insights");
    }

    @Then("^Verify all menu items \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" are displayed correctly$")
    public void verify_all_menu_items_are_displayed_correctly(
            String menuitem1, String menuitem2, String menuitem3,
            String menuitem4, String menuitem5) throws Throwable {
        assertEquals(getMenuitemAbout().getText(),menuitem1);
        assertEquals(getMenuitemBusinesses().getText(),menuitem2);
        assertEquals(getMenuitemInsights().getText(),menuitem3);
        assertEquals(getMenuitemCareers().getText(),menuitem4);
        assertEquals(getMenuitemContact().getText(),menuitem5);
    }

    @When("^Click the search button at the top right corner$")
    public void click_the_search_button_at_the_top_right_corner() throws Throwable{
        getTopSearchIcon().click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Then("^Enter the text \"([^\"]*)\" in the search textbox and verify the result$")
    public void enter_the_text_in_the_search_textbox_and_verify_the_result(String arg1) throws Throwable {
        getTopSearchTextBox().sendKeys(arg1);
        WebElement pagewait = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id=\"search-modal-top\"]/section/div/div/div[2]/h3")));
        System.out.println(pagewait.getText());
        assertEquals(pagewait.getText(),"Search results for 'Energy'");
    }


    @And("^Close the window by clicking on close button$")
    public void close_the_window_by_clicking_on_close_button() throws Throwable {
        getTopCloseIcon().click();
        assertEquals(getLandingPageTextMessage().getText(),"Insights");
    }

    @Given("^Enter the search text \"([^\"]*)\" and filter by Business type \"([^\"]*)\"$")
    public void enter_the_search_text_and_filter_by_Business_type(
            String searchtext,  String filterselection) throws Throwable {
        getSearchTextBox().sendKeys(searchtext);
        Select filter = new Select(getFilterDropdown());
        filter.selectByVisibleText(filterselection);
    }

    @And("^Verify the search result and filter by business type displays correctly$")
    public void verify_the_search_result_and_filter_by_business_type_displays_correctly() throws Throwable {
        assertEquals(getSerchResulText().getText(),"Search results");
        assertEquals(getResult().getText(),"Octopus Energy");

    }

    @And("^Click on read more on the search result item and verify the page navigates correctly$")
    public void click_on_read_more_on_the_search_result_item_and_verify_the_page_navigates_correctly() throws Throwable {
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.DOWN);
        WebElement readmoreButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div[2]/div[1]/section/main/section[3]/div/div[1]/div[1]/article/div/div[2]/a")));
        String resultitem = getResultItemText().getText();
        readmoreButton.click();
        WebElement pagewait = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"main\"]/section[2]/div/div/h1")));
        assertEquals(resultitem,pagewait.getText());
        driver.navigate().back();
    }

    @Then("^Clear the filter criteria and verify the default page is displayed$")
    public void clear_the_filter_criteria_and_verify_the_default_page_is_displayed() throws Throwable {
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.DOWN);
        WebElement pageWaitSearch = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"main\"]/section[2]/div/form/div[1]/input")));
        pageWaitSearch.clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.className("select-clear"))).click();
        WebElement pageWaitDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.className("card-itemTitle")));
        assertEquals(pageWaitDropDown.getText(),"Make a difference differently: How singing can help vulnerable people");
    }

    @Given("^Select filter by Business type as invalid \"([^\"]*)\" filter$")
    public void select_filter_by_Business_type_as_invalid_filter(String arg1) throws Throwable {
        Select filter = new Select(getFilterDropdown());
        filter.selectByVisibleText(arg1);
    }

    @When("^Click on the link from the result page$")
    public void click_on_the_link_from_the_result_page() throws Throwable {
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.DOWN);
        driver.findElement(By.linkText("Get in touch")).click();
    }

    @Then("^Verify the user is able to navigate to the contact page \"([^\"]*)\" successfully$")
    public void verify_the_user_is_able_to_navigate_to_the_contact_page_successfully(String arg1) throws Throwable {
        assertEquals(getContactusText().getText(),arg1);
        driver.navigate().back();
    }
}
