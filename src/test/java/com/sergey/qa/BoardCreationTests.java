package com.sergey.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase{

    @BeforeMethod
    public void preCondition() throws InterruptedException {
        //isUserLoggedIn
        if(!isElementPresent(By.xpath("//*[@data-test-id='header-member-menu-button']"))){
            login();
        }
    }

    @Test
    public void boardCreationTest() throws InterruptedException {
        String title0 = "qa28Board_" + System.currentTimeMillis();
        //clickOnPlusButton
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
        //SelectCreateBoard
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
        //FillBoardCreationForm
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), title0);
        click(By.xpath("//button[@data-test-id='create-board-submit-button']"));
        new WebDriverWait(wd, 30).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.open-add-list.js-open-add-list")));
        String title = wd.findElement(By.xpath("//h1")).getText();
        System.out.println(title0 + " " + title);
        Assert.assertEquals(title, title0);
    }
}
