import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckStatesTest {


    public static WebDriver driver = new ChromeDriver();
    public static MainPage mainPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sones\\IdeaProjects\\software_testing_lab3");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://advego.com/");
        mainPage = new MainPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkStates() {
        driver.findElement(By.xpath("//*[@id=\"search_content_form\"]/fieldset[1]/div/input")).sendKeys("конституция");
        driver.findElement(By.xpath("//*[@id=\"search_content_form\"]/fieldset[2]/div[1]/input[2]")).sendKeys("1000");
        mainPage.check_states_btn.click();
        assertNotNull(driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[2]/div/div[2]/div[4]/div/div/div[2]")).getText());
    }


}

