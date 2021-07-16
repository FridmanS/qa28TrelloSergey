package com.sergey.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeClass
    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openSite("https://trello.com/en");

    }

    private void openSite(String url) {
        wd.navigate().to(url);
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

    public boolean waitForElementPresentTryCatch(By locator, int timeOut){
        try{
            waitForElement(locator, timeOut);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }



    public void login(String email, String password) throws InterruptedException {
        click(By.xpath("//a[@href='/login']"));
        type(By.xpath("//*[@name='user']"), email);
        Thread.sleep(2000);
        click(By.xpath("//input[@id='login']"));
        type(By.xpath("//*[@name='password']"), password);
        click(By.xpath("//button[@id='login-submit']"));
    }

    @AfterClass
    public void tearDown(){

        stop();
    }

    private void stop() {
        wd.quit();
    }

    public void logOut(){
        clickOnAvatar();
        selectLogoutFromDropList();
        confirmLogout();
        checkUserLoggedOut();
    }

    public void waitForElement(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void confirmLogin() {
        click(By.xpath("//button[@id='login-submit']"));
    }

    public void fillLoginForm(String email, String password) throws InterruptedException {
        type(By.xpath("//*[@name='user']"), email);
        Thread.sleep(2000);
        click(By.xpath("//input[@id='login']"));
        type(By.xpath("//*[@name='password']"), password);
    }

    public void clickOnLoginButton() {
        click(By.xpath("//a[@href='/login']"));
    }

    public String getTitle() {
        return wd.findElement(By.xpath("//h1")).getText();
    }

    public void confirmBoardCreation() {
        click(By.xpath("//button[@data-test-id='create-board-submit-button']"));
    }

    public void fillBoardCreationForm(String title0) {
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), title0);
    }

    public void selectCreateBoard() {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public boolean isAvatarPresent() {
        return isElementPresent(By.xpath("//*[@data-test-id='header-member-menu-button']"));
    }

    public void waitForOpenAddListInTheBoard() {
        waitForElement(By.cssSelector("a.open-add-list.js-open-add-list"), 15);
    }

    public boolean isAvatarPresentWait() {
        return waitForElementPresent(By.xpath("//ul[@class = 'boards-page-board-section-list']"), 15);
    }
}
