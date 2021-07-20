package com.sergey.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {

    @Test
    public void loginTest() throws InterruptedException {
        //clickOnLoginButton
        app.loginHelper().clickOnLoginButton();
        //fillLoginForm
        app.loginHelper().fillLoginForm("fridmans93@gmail.com", "?gH6]e?d4Lw~$x!");
        //confirmLogin
        app.loginHelper().confirmLogin();
        Assert.assertTrue(app.loginHelper().isAvatarPresentWait(), "Avatar is not present");
    }



}
