package com.sergey.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {

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

}
