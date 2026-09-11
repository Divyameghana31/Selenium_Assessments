package handlingWebelements;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Instagram {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();

		List<WebElement> textfields = driver.findElements(By.xpath("//input"));
		System.out.println("Number of text fields: " + textfields.size());
		for (WebElement textfield : textfields) {
			System.out.println("Width: " + textfield.getSize().getWidth());
			System.out.println("Height: " + textfield.getSize().getHeight());
			textfield.sendKeys("test");
		}

	}
}