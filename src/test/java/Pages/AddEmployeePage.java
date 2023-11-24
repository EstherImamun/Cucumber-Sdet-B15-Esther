package Pages;

import StepDefinitions.AddEmployee;
import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {

    public AddEmployeePage(){ // you will get a null pointer exception if you don't
        PageFactory.initElements(driver,this);// initialize your webElements using a constructor
    }

    @FindBy(id="menu_pim_viewPimModule")
   public WebElement pimTab;
    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmpBtn;
    @FindBy(id="firstName")
   public WebElement firstNameTextBox;
    @FindBy(id="middleName")
    public WebElement middleNameTextBox;
    @FindBy(id="lastName")
    public  WebElement lastNameTextBox;
    @FindBy(id="btnSave")
    public  WebElement saveBtn;

    @FindBy(id="employeeId")
    public WebElement empIdLocator;





}
