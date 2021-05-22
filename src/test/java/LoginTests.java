import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class LoginTests {
    public static WebDriver driver = new ChromeDriver();
    public static MainPage mainPage;
     public static String login = "sofyasofyasdtkrf";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sones\\IdeaProjects\\software_testing_lab3");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    void login() {
        final var username = "sofyasofyasdtkrf";
        final var email = "soneshya@mail.ru";
        final var password = "Mathson933";

        driver.get("https://advego.com/");
        mainPage = new MainPage(driver);
        mainPage.entry_btn.click();
        driver.findElement(By.xpath("//*[@id='top']/div[1]/div[1]/div/div[1]/ul/li[1]/a"));
        driver.findElement(By.xpath("//*[@id='login-form-login']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='login-form-pwd']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='login_ok']")).click();


        {
            WebDriverWait wait = new WebDriverWait(driver, 500);
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//a[contains(@href, '/profile/" + username + "/')]")
                    )
            );
        }

        assertNotNull(driver.findElement(By.xpath("//*[@id=\"top\"]/div[1]/div[1]/div/div[1]/ul/li[1]/ul/li[1]/a[2]")).getText());

    }

    @Test
    @Order(2)
    public void checkSpelling() {
        mainPage.check_orphogr_btn.click();
        driver.findElement(By.xpath(" //*[@id=\"job_text_spell\"]")).sendKeys("корова,карова");
        driver.findElement(By.xpath(" //*[@id=\"text_spell_check\"]/a[1]")).click();
        assertNotNull(driver.findElement(By.xpath("//*[@id=\"text_check_results_form\"]/div[1]")).getText());
    }


}
