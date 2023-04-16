package StepDefinitions;

import Pages.AddEmployeePage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() throws InterruptedException {
        //driver.findElement(By.id("menu_pim_viewPimModule")).click();
       // WebElement pimTab=driver.findElement(By.id("menu_pim_viewPimModule"));
        doClick(addEmployeePage.pimTab);

    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() throws InterruptedException {
       //WebElement addEmpBtn = driver.findElement(By.id("menu_pim_addEmployee"));
       doClick(addEmployeePage.addEmpBtn);

    }
    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        //WebElement firstNameTextBox=driver.findElement(By.id("firstName"));
        sendText(addEmployeePage.firstNameTextBox,ConfigReader.getPropertyValue("firstname"));

        //WebElement middleNameTextBox = driver.findElement(By.id("middleName"));
        sendText(addEmployeePage.middleNameTextBox,ConfigReader.getPropertyValue("middlename"));

       // WebElement lastNameTextBox = driver.findElement(By.id("lastName"));
        sendText(addEmployeePage.lastNameTextBox,ConfigReader.getPropertyValue("lastname"));


       // driver.findElement(By.id("firstName")).sendKeys(ConfigReader.getPropertyValue("firstname"));
        //driver.findElement(By.id("middleName")).sendKeys(ConfigReader.getPropertyValue("middlename"));
        //driver.findElement(By.id("lastName")).sendKeys(ConfigReader.getPropertyValue("lastname"));

    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() throws InterruptedException {
       // WebElement saveBtn = driver.findElement(By.id("btnSave"));
        doClick(addEmployeePage.saveBtn);

    }

}
