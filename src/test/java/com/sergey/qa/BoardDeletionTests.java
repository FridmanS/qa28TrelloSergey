package com.sergey.qa;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends  TestBase {

    @BeforeMethod
    public void preCondition() throws InterruptedException {
        //isUserLoggedIn
        if(!isAvatarPresent()){
            login("fridmans93@gmail.com", "?gH6]e?d4Lw~$x!");
        }
    }

    @Test
    public void testBoardDeletion(){
        getBoardsCount();
        selectFirstBoard();
        openMenu();
        deleteBoard();
        returnOnHomePage();

    }

    private void returnOnHomePage() {
        click(By.cssSelector("[data-test-id*=header-home]"));
    }

    private void deleteBoard() {
        click(By.cssSelector(".icon-back"));
        click(By.cssSelector("js-open-more"));
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));


    }

    private void openMenu() {
        click(By.cssSelector(".js"));
    }

    private int getBoardsCount() {
        return wd.findElements(By.xpath("//*[contains(@class, 'boards-page-board-section-header-icon-default-image')]/../../../..//li")).size() - 1;
    }

    private void selectFirstBoard() {
        click(By.xpath("//*[contains(@class, 'boards-page-board-section-header-icon-default-image')]/../../../..//li"));
    }
}
