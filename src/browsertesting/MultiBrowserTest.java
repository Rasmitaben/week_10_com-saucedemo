package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Edge";
    static WebDriver driver;
    static String baseUrl = " https://www.saucedemo.com/ ";


    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else{
            System.out.println("Wrong Browser name");
        }
        //Open the Url into Browser
        driver.get(baseUrl);

        // Maximise the Browser
        driver.manage().window().maximize();

        // We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        // Get the Title of the Page
        String title = driver.getTitle();
        System.out.println(title);

        // Get the current Url
        System.out.println("current Url : " + driver.getCurrentUrl());

        // Get the page source
        System.out.println("page source : " + driver.getPageSource());

        // Find the Username field element
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Find the Password field element and type the password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        // Close the Browser
         driver.close();



    }
}
