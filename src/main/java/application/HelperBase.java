package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd){
        this.wd = wd;
    }

    public void click(By locator){

        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator){

        return wd.findElements(locator).size() > 0;
    }

    public boolean waitForElementPresent(By locator, int timeOut){
        return new WebDriverWait(wd, timeOut)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).size()>0;
    }

    public void login(String email, String password) throws InterruptedException {
        click(By.xpath("//a[@href='/login']"));
        type(By.xpath("//*[@name='user']"), email);
        Thread.sleep(2000);
        click(By.xpath("//input[@id='login']"));
        type(By.xpath("//*[@name='password']"), password);
        click(By.xpath("//button[@id='login-submit']"));
    }

    public boolean isAvatarPresentWait() {
        return waitForElementPresent(By.xpath("//ul[@class = 'boards-page-board-section-list']"), 15);
    }

    public boolean isAvatarPresent() {
        return isElementPresent(By.xpath("//*[@data-test-id='header-member-menu-button']"));
    }

    public void logOut(){
        clickOnAvatar();
        selectLogoutFromDropList();
        confirmLogout();
        checkUserLoggedOut();
    }

    private void selectLogoutFromDropList() {
        click(By.cssSelector("[data-test-id$=logout]"));
    }

    public boolean checkUserLoggedOut() {
        return wd.getCurrentUrl().equals("https://trello.com/logged-out");
    }

    public void confirmLogout() {
        click(By.cssSelector("#logout-submit"));
    }

    public void selectLogoutFromDropDownList() {
        click(By.cssSelector("[data-test-id$=logout]"));
    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id=header-member-menu-button]"));
    }

    public void returnOnHomePage() {
        click(By.cssSelector("[data-test-id*=header-home]"));
    }
}
