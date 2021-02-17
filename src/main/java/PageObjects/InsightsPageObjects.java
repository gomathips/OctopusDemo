package PageObjects;
import DriverManagement.DriverManagement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class InsightsPageObjects extends DriverManagement {
    protected WebElement getLandingPageTextMessage() {
        return driver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/div[1]/div/h1"));
    }

    protected WebElement getInsightMessage() {
        return driver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/div[1]/div/p"));
    }

    protected WebElement getOctopusLogo() {
        return driver.findElement(By.xpath("//*[@id=\"primaryNav\"]/div[2]/a"));
    }

    protected WebElement getOctopusWelcomeMessage() {
        return driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/section[1]/div[1]/div/h1"));
    }

    protected WebElement getTopNavigationBar() { return driver.findElement(By.className("primaryNav")); }

    protected WebElement getMenuitemAbout() { return driver.findElement(By.id("menu-item-127")); }

    protected WebElement getMenuitemBusinesses() { return driver.findElement(By.id("menu-item-14")); }

    protected WebElement getMenuitemInsights() { return driver.findElement(By.id("menu-item-36")); }

    protected WebElement getMenuitemCareers(){ return driver.findElement(By.id("menu-item-128")); }

    protected WebElement getMenuitemContact() { return driver.findElement(By.id("menu-item-95")); }

    protected WebElement getTopSearchIcon() { return driver.findElement(By.className("icon-search")); }

    protected WebElement getTopSearchTextBox() { return driver.findElement(By.id("input-focus")); }

    protected WebElement getTopCloseIcon() { return driver.findElement(By.className("icon-x")); }

    protected WebElement getSearchTextBox() {
        return driver.findElement(By.xpath("//*[@id=\"main\"]/section[2]/div/form/div[1]/input")); }

    protected WebElement getFilterDropdown() { return driver.findElement(By.className("select-css")); }

    protected WebElement getSerchResulText() {
        return driver.findElement(By.xpath("//*[@id=\"main\"]/section[3]/div/h2"));
    }

    protected WebElement getResult() { return driver.findElement(By.className("deepsea-tag")); }

    protected WebElement getResultItemText() {
        return driver.findElement(By.xpath("//*[@id=\"main\"]/section[3]/div/div[1]/div[1]/article/div/h3/a"));
    }

    protected WebElement getContactusText() {
        return driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/main/article/div/section[1]/div/h2"));
    }
}
