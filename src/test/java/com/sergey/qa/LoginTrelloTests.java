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
        clickOnLoginButton();
        //fillLoginForm
        fillLoginForm("fridmans93@gmail.com", "?gH6]e?d4Lw~$x!");
        //confirmLogin
        confirmLogin();
        Assert.assertTrue(isAvatarPresentWait(), "Avatar is not present");
    }



}
