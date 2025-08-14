package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import pages.PIMPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OrangeHRMTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication("Admin", "admin123");

        // Navigate to PIM
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.goToPIMModule();

        // Add Employees
        PIMPage pimPage = new PIMPage(driver);

        List<String[]> employees = new ArrayList<>();
        employees.add(new String[]{"Vamsi", "Kumar"});
        employees.add(new String[]{"Ravi", "Sharma"});
        employees.add(new String[]{"Anita", "Singh"});

        for (String[] emp : employees) {
            pimPage.clickAddEmployee();
            Thread.sleep(1000); // small wait for form to open
            pimPage.addEmployee(emp[0], emp[1]);
        }

        // Navigate to Employee List and verify
        EmployeeListPage empListPage = new EmployeeListPage(driver);
        for (String[] emp : employees) {
            empListPage.verifyEmployee(emp[0], emp[1]);
        }

        // Log out (optional, if needed)
        // driver.findElement(By.xpath("//p[text()='Logout']")).click();

        driver.quit();
    }
}
