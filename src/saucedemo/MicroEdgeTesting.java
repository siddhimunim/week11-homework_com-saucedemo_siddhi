package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class MicroEdgeTesting {
    // declare main method//
    public static void main(String[] args) {
        String baseUrl = "https://www.saucedemo.com/";
        System.setProperty("webdriver.msedge.driver", "");
        WebDriver driver = new EdgeDriver();
        //launch the url//
        driver.get(baseUrl);
        // maximize url//
        driver.manage().window().maximize();
        //we give implicit time to driver//
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //print title of the page//
        System.out.println("Title of the page : " + driver.getTitle());
        //print the current Url//
        System.out.println("Current URL : " + driver.getCurrentUrl());
        //print the page source//
        System.out.println("Page source : " + driver.getPageSource());
        //enter username field//
        WebElement userName = driver.findElement(By.name("user-name"));
        userName.sendKeys("standard_user");
        //enter password to password field//
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        //driver close//
        driver.quit();

    }
}
