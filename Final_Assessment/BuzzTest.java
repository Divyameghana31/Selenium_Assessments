package Demo;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import assessment01.BuzzPage;
import assessment01.LoginPage;

public class BuzzTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        BuzzPage buzzPage = new BuzzPage(driver);

        buzzPage.clickBuzz();

        buzzPage.enterPost("heyy its TUESDAY");

        buzzPage.clickPost();

        if (buzzPage.getRecentPost().contains("heyy its TUESDAY")) {
            System.out.println("Post is successfully displayed in Recent Posts");
        } else {
            System.out.println("Post is not displayed");
        }

        buzzPage.logout();

        driver.quit();
    }
}