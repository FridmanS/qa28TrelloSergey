package com.sergey.qa;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends  TestBase {

    @BeforeMethod
    public void preCondition() throws InterruptedException {
        //isUserLoggedIn
        if(!app.boardHelper().isAvatarPresent()){
            app.boardHelper().login("fridmans93@gmail.com", "?gH6]e?d4Lw~$x!");
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        Thread.sleep(4000);
        int boardsCount = app.boardHelper().getBoardsCount();
        while (boardsCount>1) {
            app.boardHelper().selectFirstBoard();
            app.boardHelper().openMenu();
            app.boardHelper().deleteBoard();
            app.boardHelper().returnOnHomePage();
            Thread.sleep(4000);
            boardsCount = app.boardHelper().getBoardsCount();
        }

    }
}
