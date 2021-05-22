import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"top\"]/div[1]/div[1]/div/div[1]/ul/li[1]/a")
    public WebElement entry_btn;

    @FindBy(xpath = "//*[@id=\"search_content_form_outer\"]/div[2]/a[1]")
    public WebElement check_states_btn;
    @FindBy(xpath = "//*[@id=\"index-service-orpho\"]/img")
    public WebElement check_orphogr_btn;
    @FindBy(xpath = "//*[@id=\"index-service-genpass\"]/img")
    public WebElement generate_password_btn;

    @FindBy(xpath = "//*[@id=\"menu_7\"]")
    public WebElement forum_btn;

    @FindBy(xpath = "//*[@id=\"login_small_close\"]")
    public WebElement close_btn;


}
