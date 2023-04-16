package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.cucumber.datatable.DataTable;

import java.time.Duration;
//import java.util.List;
import java.util.*;

public class Login extends CommonMethods {

   /* @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {
        openBrowserAndLaunchApplication();
    }*/

    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
       // LoginPage login=new LoginPage();
        //WebElement usernameTextBox=driver.findElement(By.id("txtUsername"));
        sendText(login.usernameTextBox,ConfigReader.getPropertyValue("username"));
       // WebElement passwordTextBox=driver.findElement(By.id("txtPassword"));
        sendText(login.passwordTextBox,ConfigReader.getPropertyValue("password"));

       // driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(ConfigReader.getPropertyValue("username"));
        //driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(ConfigReader.getPropertyValue("password"));
    }

    @When("click on login button")
    public void click_on_login_button() throws InterruptedException {
       // LoginPage login=new LoginPage();
      //  WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        doClick(login.loginBtn);
    }

    @Then("user is logged in successfully into the application")
    public void user_is_logged_in_successfully() {
        boolean userLoggedIn = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed();
        if(userLoggedIn){
            System.out.println("User is logged in Successfully");
        }

    }
    @Then("Close the browser")
    public void close_the_browser() {
      closeBrowser();
    }

    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {
       // LoginPage login=new LoginPage();
       // WebElement usernameTextBox=driver.findElement(By.id("txtUsername"));
        sendText(login.usernameTextBox,username);
        //WebElement passwordTextBox=driver.findElement(By.id("txtPassword"));
        sendText(login.passwordTextBox,password);
    }
    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) throws InterruptedException {
       // LoginPage login=new LoginPage();
        List<Map<String, String>> userCredentials = dataTable.asMaps();
        for (Map<String, String> userCreds : userCredentials) {
            String username = userCreds.get("username");
            String password = userCreds.get("password");

           // WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
            sendText(login.usernameTextBox, username);
            //WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
            sendText(login.passwordTextBox, password);



           // WebElement loginBtn = driver.findElement(By.id("btnLogin"));
            doClick(login.loginBtn);



            //WebElement welcomeIcon = driver.findElement(By.id("welcome"));
            doClick(login.welcomeIcon);
           // WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
            doClick(login.logoutLink);
        }
    }

}
