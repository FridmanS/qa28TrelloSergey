package com.sergey.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeClass
    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/en");
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

    public void login() throws InterruptedException {
        click(By.xpath("//a[@href='/login']"));
        type(By.xpath("//*[@name='user']"), "fridmans93@gmail.com");
        Thread.sleep(2000);
        click(By.xpath("//input[@id='login']"));
        type(By.xpath("//*[@name='password']"), "?gH6]e?d4Lw~$x!");
        click(By.xpath("//button[@id='login-submit']"));
    }

    @AfterClass
    public void tearDown(){

        wd.quit();
    }
}
