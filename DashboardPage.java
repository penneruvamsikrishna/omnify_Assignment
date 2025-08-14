package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pimMenu = By.xpath("//span[text()='PIM']");

    // Hover and click PIM
    public void goToPIMModule() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(pimMenu)).click().build().perform();
    }
}
