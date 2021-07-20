package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
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

    public String getTitle() {
        return wd.findElement(By.xpath("//h1")).getText();
    }

    public void waitForOpenAddListInTheBoard() {
        waitForElementPresent(By.cssSelector("a.open-add-list.js-open-add-list"), 15);
    }

    public void deleteBoard() {
        if(!isElementPresent(By.cssSelector(".js-open-more"))) {
            click(By.cssSelector(".icon-back"));
        }
        click(By.cssSelector(".js-open-more"));
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));
    }

    public void openMenu() {
        if(!isElementPresent(By.cssSelector(".board-menu-header-close-button.icon-lg.icon-close.js-hide-sidebar"))) {
            click(By.cssSelector(".js-show-sidebar"));
        }
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//h3[@class='boards-page-section-header-name']/../div//li")).size() - 1;
    }

    public void selectFirstBoard() {
        click(By.xpath("//h3[@class='boards-page-section-header-name']/../div//li"));
    }
}
