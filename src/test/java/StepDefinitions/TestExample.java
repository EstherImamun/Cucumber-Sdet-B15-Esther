package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestExample {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver(); // this will go in the CommonMethods file
        driver.get("http://hrm.syntaxtechs.net/"); // this line will go into the property file or config.property
        // and the ConfigReader will help you to read the file in the config.properties file.
        driver.findElement(By.xpath("//[@id=2342'")).sendKeys("DATA");// this will also be
        // in the config.properties file and be read by the ConfigReader too
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));// this line will be in the Constants file
        // because it's constant or final. cannot be changed
        driver.close();

        // Hooks will be there in your step Definitions to ensure that all browsers are closed after running
        // even when the test case/cases passed or not
    }
}
