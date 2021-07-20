package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    LoginHelper loginHelper;
    BoardHelper boardHelper;

    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/en");
        loginHelper = new LoginHelper(wd);
        boardHelper = new BoardHelper(wd);
    }

    public void stop(){
        wd.quit();
    }

    public LoginHelper loginHelper(){
        return loginHelper;
    }

    public BoardHelper boardHelper(){
        return boardHelper;
    }
}

