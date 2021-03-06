import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ChromeDriver
{

    protected static WebDriver driver;


    public static void main(String[] args)
    {

        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        String Date1 = dateFormat.format(date);

        // this code is used to open the browser on the internet.
        System.setProperty("webdriver.chrome.driver","src\\BrowserDrivers\\chromedriver.exe");
        driver = new org.openqa.selenium.chrome.ChromeDriver();

        // this is to manage the time before it throws the error if the page is not loaded in the below time.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //this is to open the website you want to test.
        driver.get("https://demo.nopcommerce.com/");
        //to maximise the window
        driver.manage().window().maximize();

        // to click on Register button on homepage
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        // to select the gender using id....
        driver.findElement(By.id("gender-male")).click();
        //to Enter the First Name using xpath
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Neeraj123");
        // to Enter Last Name using id
        driver.findElement(By.id("LastName")).sendKeys("Arora1122");
        // Enter DOB using xpath. Enter the date first
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("10");
        //enter the month
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("October");
        //enter the year
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1910");
        // enter the email using xpath
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("neo"+Date1+"@neo.com");
        //enter Company Name
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Indian Tigers");
        //enter password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("neoneoneo");
        //verify password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("neoneoneo");

        //click on register button
        driver.findElement(By.xpath("//input[@id='register-button']")).click();

        //this is to match up your expected results = actual results using class name in find Elements
        String ActualResult = driver.findElement(By.className("result")).getText();

         /* this is the assert syntax to match up your results.
         In some cases Assert will come up as RED so type @Test in the main class and download the jar file for junit
          */
        Assert.assertEquals("Your registration completed", ActualResult);
        System.out.println("Expected Result : Your registration completed = Actual Result : " +ActualResult);

        driver.findElement(By.xpath("//input[@name='register-continue']")).click();

        // this will close your current browser
        //driver.close();

       //this will close all the opened browsers
       driver.quit();
    }

}
