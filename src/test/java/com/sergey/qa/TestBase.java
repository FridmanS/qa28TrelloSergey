package com.sergey.qa;

import application.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.ApplicationCache;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp(){
        app.init();
    }

    @AfterClass
    public void tearDown(){
        app.stop();
    }




}
