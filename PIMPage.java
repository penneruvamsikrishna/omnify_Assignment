package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
    WebDriver driver;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addEmployeeButton = By.xpath("//button//span[text()='Add Employee']");

    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By saveButton = By.xpath("//button[text()=' Save ']");

    /*// Click Add Employee with wait
    public void clickAddEmployee() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton)).click();
    }*/
    
    public void clickAddEmployee() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        // Wait for the button to be clickable
        WebElement addEmployeeBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[normalize-space()='Add Employee']")));
        
        // Scroll into view (in case it's off-screen)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addEmployeeBtn);
        
        // Click the button
        addEmployeeBtn.click();
    }


    // Add Employee
    public void addEmployee(String firstName, String lastName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(saveButton).click();
    }
}
