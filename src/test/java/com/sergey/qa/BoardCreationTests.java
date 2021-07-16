package com.sergey.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase{

    @BeforeMethod
    public void preCondition() throws InterruptedException {
        //isUserLoggedIn
        if(!isAvatarPresent()){
            login("fridmans93@gmail.com", "?gH6]e?d4Lw~$x!");
        }
    }

    @Test
    public void boardCreationTest() throws InterruptedException {
        String boardName = "qa28Board_" + System.currentTimeMillis();
        //clickOnPlusButton
        clickOnPlusButton();
        //SelectCreateBoard
        selectCreateBoard();
        //FillBoardCreationForm
        fillBoardCreationForm(boardName);
        confirmBoardCreation();
        waitForOpenAddListInTheBoard();
        String title = getTitle();
        Assert.assertEquals(title, boardName);
    }



}
