package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EmployeeListPage {
    WebDriver driver;

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By employeeRows = By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']");

    // Verify Employee in List
    public void verifyEmployee(String firstName, String lastName) {
        List<WebElement> rows = driver.findElements(employeeRows);
        boolean found = false;

        for (WebElement row : rows) {
            String name = row.getText();
            if (name.contains(firstName) && name.contains(lastName)) {
                System.out.println(firstName + " " + lastName + " - Name Verified");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(firstName + " " + lastName + " - Not Found");
        }
    }
}

