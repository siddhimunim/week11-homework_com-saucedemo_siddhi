package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromedriverTesting {
    //declare main method//
    public static void main(String[] args) {


        String baseUrl = "https://www.saucedemo.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //launch the url//
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //implicit time to driver//
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //print the title page//
        System.out.println("Title page : " + driver.getTitle());
        //print the current URL//
        System.out.println("Current URL" + driver.getCurrentUrl());
        //print the page source//
        System.out.println("Page source " + driver.getPageSource());
        // enter username into userfeild//
        WebElement UserName = driver.findElement(By.id("user-name"));
        UserName.sendKeys("standard_user");
        //enter password//
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        driver.quit();

    }
}