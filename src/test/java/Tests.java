import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    public static WebDriver driver = new ChromeDriver();
    public static MainPage mainPage;
    public static int aov = 30;
    public static int rpr = 2;
    public static int lifestyle = 2;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sones\\IdeaProjects\\software_testing_lab3");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://advego.com/");
        mainPage = new MainPage(driver);
    }


    @Test
    public void generatePassword() {
        mainPage.generate_password_btn.click();
        driver.findElement(By.xpath("//*[@id=\"pwd_len\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"pwd_len\"]")).sendKeys("29");
        driver.findElement(By.xpath("//*[@id=\"pwd_form\"]/div[6]/div/button")).click();
        assertTrue(driver.findElement(By.xpath("//*[@id=\"password\"]")).getAttribute("value").length() == 29);
    }

    @Test
    public void testForum() {
        mainPage.forum_btn.click();
        driver.findElement(By.xpath("//*[@id=\"submenu_7\"]/div/div[5]/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys("google");
        driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[2]/div/div[2]/div[1]/form/div[1]/div/button")).click();
        assertTrue(driver.findElement(By.xpath(" //*[@id=\"login_small_form\"]/div[1]")).isDisplayed());
        mainPage.close_btn.click();
    }


    @Test
    public void testRevertText() {
        driver.findElement(By.xpath("//*[@id=\"text-reverse\"]/img")).click();
        driver.findElement(By.xpath("//*[@id=\"textData\"]")).sendKeys("ток");
        driver.findElement(By.xpath("//*[@id=\"reverseText\"]")).click();
        assertEquals("кот", driver.findElement(By.xpath(("html/body/div[3]/div[2]/div[2]/div/div[2]/form/textarea[1]"))).getAttribute("value"));
    }

    @Test
    public void testLTVValue() {
        driver.findElement(By.xpath("//*[@id=\"customer-lifetime-value\"]/img")).click();
        driver.findElement(By.xpath("//*[@id=\"AOV\"]")).sendKeys("30");
        driver.findElement(By.xpath("//*[@id=\"RPR\"]")).sendKeys("2");
        driver.findElement(By.xpath("//*[@id=\"Lifetime\"]")).sendKeys("2");
        driver.findElement(By.xpath("//*[@id=\"calcCTR\"]")).click();
        assertEquals(Math.multiplyExact(Math.multiplyExact(aov,rpr),lifestyle)+"%",driver.findElement(By.xpath("//*[@id=\"res\"]")).getAttribute("value"));
    }
}
