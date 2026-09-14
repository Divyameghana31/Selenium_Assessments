package Datadriventesting;

import java.io.FileReader;
import java.time.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoWebApp {
	public static void main(String[] args) throws Exception {
		// Step 1: Read data from JSON file
		FileReader fir = new FileReader(".\\src\\test\\resources\\DDT\\Spiders.json");
		JSONParser pars = new JSONParser();
		JSONObject js = (JSONObject) pars.parse(fir);
		String browser = (String) js.get("browser");
		String username = (String) js.get("username");
		String password = (String) js.get("password");
		String url = (String) js.get("url");
		// Step 2: Launch browser
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Step 3: Navigate to application
		driver.get(url);
		// Step 4: Enter data
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		// Step 5: Click Submit
		driver.findElement(By.id("button-login-submit")).click();
		
	}
}
