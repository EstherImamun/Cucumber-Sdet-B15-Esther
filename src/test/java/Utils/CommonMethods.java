package Utils;

import Pages.LoginPage;
import StepDefinitions.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication() {

        ConfigReader.readProperties();

        String browserType = ConfigReader.getPropertyValue("browserType");//
        switch (browserType) {
            case "Chrome":
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--no-sandbox");
                ops.addArguments("--remote-allow-origins=*");
                if(ConfigReader.getPropertyValue("Headless").equals("true")){
                    ops.addArguments("--headless=new");
                }
                driver = new ChromeDriver(ops);
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            default:
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));
        initializePageObjects();
    }

    public static void closeBrowser() {
        driver.close();

    }


    public static void doClick(WebElement element) throws InterruptedException {
        element.click();
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static Select clickOnDropdown(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    public static void selectByValue(WebElement element, String value) {
        clickOnDropdown(element).selectByValue(value);
    }

    public static void selectByVisibleText(WebElement element, String text) {
        clickOnDropdown(element).selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index) {
        clickOnDropdown(element).selectByIndex(index);
    }

    public static void selectByOptions(WebElement element, String text) {
        List<WebElement> options = clickOnDropdown(element).getOptions();
        for (WebElement option : options) {
            String ddlOptionText = option.getText();
            if (ddlOptionText.equalsIgnoreCase(text)) {
                option.click();
            }
        }
    }

    //===========================SCREENSHOT====================================================

    public static byte[] takeScreenshot(String imageName) {
        // this casts the webdriver instance driver to TakeScreenshot Interface
        TakesScreenshot ts = (TakesScreenshot) driver;

        // This captures the screenshot and stores it as byte of array
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        // This captures the screenshot and stores it as a file in the sourceFile variable
        File sourcePath = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourcePath, new File(Constants.ScreenShot_FILEPATH+
                    imageName +getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);

    }

}










