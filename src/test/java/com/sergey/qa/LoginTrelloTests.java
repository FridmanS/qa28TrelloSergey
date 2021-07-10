package com.sergey.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTests {

    WebDriver wd;

    @BeforeMethod
    public void setup(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/en");
    }

    @Test
    public void loginTest() throws InterruptedException {
        //clickOnLoginButton
        click(By.xpath("//a[@href='/login']"));

        //fillLoginForm

        type(By.xpath("//*[@name='user']"), "fridmans93@gmail.com");

        Thread.sleep(2000);

        click(By.xpath("//input[@id='login']"));

        type(By.xpath("//*[@name='password']"), "?gH6]e?d4Lw~$x!");

        //confirmLogin
        click(By.xpath("//button[@id='login-submit']"));

        new WebDriverWait(wd, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class = 'boards-page-board-section-list']")));
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
