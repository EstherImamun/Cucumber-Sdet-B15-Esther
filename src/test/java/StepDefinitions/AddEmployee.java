package StepDefinitions;

import Pages.AddEmployeePage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;
import Utils.GlobalVariables;
import io.cucumber.java.en.*;
import org.junit.Assert;
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
        sendText(addEmployeePage.firstNameTextBox, ConfigReader.getPropertyValue("firstname"));

        //WebElement middleNameTextBox = driver.findElement(By.id("middleName"));
        sendText(addEmployeePage.middleNameTextBox, ConfigReader.getPropertyValue("middlename"));

        // WebElement lastNameTextBox = driver.findElement(By.id("lastName"));
        sendText(addEmployeePage.lastNameTextBox, ConfigReader.getPropertyValue("lastname"));


        // driver.findElement(By.id("firstName")).sendKeys(ConfigReader.getPropertyValue("firstname"));
        //driver.findElement(By.id("middleName")).sendKeys(ConfigReader.getPropertyValue("middlename"));
        //driver.findElement(By.id("lastName")).sendKeys(ConfigReader.getPropertyValue("lastname"));

    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() throws InterruptedException {
        // WebElement saveBtn = driver.findElement(By.id("btnSave"));
        Assert.assertTrue(addEmployeePage.saveBtn.isDisplayed());
        System.out.println("my assertion is returning true");
        doClick(addEmployeePage.saveBtn);

    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String fname, String mname, String lname) {
        sendText(addEmployeePage.firstNameTextBox, fname);
        sendText(addEmployeePage.middleNameTextBox, mname);
        sendText(addEmployeePage.lastNameTextBox, lname);
    }

    @When("user captures the employee id")
    public void user_captures_the_employee_id() {
    GlobalVariables.emp_id=addEmployeePage.empIdLocator.getAttribute("value");
        System.out.println("The employee id is: "+GlobalVariables.emp_id);
    }

    @When("query the information in backend")
    public void query_the_information_in_backend() {
        String query = "select * from hs_hr_employees where employee_id='"+GlobalVariables.emp_id+"'";
        // to store the table coming from db, we used global variable here
        // in this variable we got all the keys and values or the employee we searched for
       GlobalVariables.tabledata= DBUtility.getListOfMapsFromRset(query);
    }

    @Then("verify the results from front end and backend")
    public void verify_the_results_from_front_end_and_backend() {
        String firstNameFromDB=GlobalVariables.tabledata.get(0).get("emp_firstname");
        System.out.println(firstNameFromDB);
        String lastNameFromDB=GlobalVariables.tabledata.get(0).get("emp_lastname");
        System.out.println(lastNameFromDB);

        // Adding Assertions

        Assert.assertEquals(firstNameFromDB, "nesha");
        Assert.assertEquals(lastNameFromDB, "standart");
        System.out.println("My assertions has passed my test case");

    }
}
