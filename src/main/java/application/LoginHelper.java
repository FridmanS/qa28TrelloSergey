package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase {

    public LoginHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmLogin() {
        click(By.xpath("//button[@id='login-submit']"));
    }

    public void fillLoginForm(String email, String password) throws InterruptedException {
        type(By.xpath("//*[@name='user']"), email);
        Thread.sleep(2000);
        click(By.xpath("//input[@id='login']"));
        type(By.xpath("//*[@name='password']"), password);
    }

    public void clickOnLoginButton() {
        click(By.xpath("//a[@href='/login']"));
    }


}
