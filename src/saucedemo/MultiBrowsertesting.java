package saucedemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowsertesting {
    //declare global variable//
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;
    //declare main method//
    public static void main(String[] args) {
        //declare scanner for input//
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter browser name : ");
        String browser = scanner.next();
        scanner.close();
        //try and catch block define for catching exception//
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.msedge.driver", "drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else {
                System.out.println("wrong browser");
            }
            driver.get(baseUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            System.out.println("Title of the page : " + driver.getTitle());
            //print the current URL//
            System.out.println( " Current URL : "  + driver.getCurrentUrl());
            //print the page source//
            System.out.println("Page source  : "  + driver.getPageSource());
            //enter username into the  field //
            WebElement userField = driver.findElement(By.name("user-name"));
            userField.sendKeys("standard_user");
            //enter password to password field//
            WebElement passwordField =driver.findElement(By.name("password"));
            passwordField.sendKeys("123test");


        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println(message);



        }
        driver.quit();
    }

}
