package assessments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraTest {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");

		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("T-shirt");

		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys(Keys.ENTER);

		// Select a product
		driver.findElement(By.xpath("(//li[contains(@class,'product-base')])[1]")).click();

		// Click Wishlist
		driver.findElement(By.xpath("//div[contains(text(),'WISHLIST')]")).click();

		// Verify wishlist
		String actualText = driver.findElement(By.xpath("//span[contains(text(),'Wishlist')]")).getText();

		if(actualText.contains("Wishlist")) {
		    System.out.println("Product is added to Wishlist");
		} else {
		    System.out.println("Product is NOT added to Wishlist");
		}
	}
}