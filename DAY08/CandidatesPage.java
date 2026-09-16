package pomrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CandidatesPage {

    WebDriver driver;

    public CandidatesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Candidates']")
    private WebElement candidates;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[1]")
    private WebElement jobTitle;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[2]")
    private WebElement vacancy;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[3]")
    private WebElement hiringManager;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[4]")
    private WebElement status;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement candidateName;

    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]")
    private WebElement fromDate;

    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[2]")
    private WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

	public WebDriver getDriver() {
		return driver;
	}

	public void getJobTitle(String value) {
	    jobTitle.click();
	    driver.findElement(By.xpath("//div[@role='option']//span[text()='" + value + "']")).click();
	}

	public void getVacancy(String value) {
	    vacancy.click();
	    driver.findElement(By.xpath("//div[@role='option']//span[text()='" + value + "']")).click();
	}

	public void getHiringManager(String value) {
	    hiringManager.click();
	    driver.findElement(By.xpath("//div[@role='option']//span[text()='" + value + "']")).click();
	}

	public void getStatus(String value) {
	    status.click();
	    driver.findElement(By.xpath("//div[@role='option']//span[text()='" + value + "']")).click();
	}

	public void getCandidateName(String value) {
	    candidateName.sendKeys(value);
	}

	public void getSearchButton() {
	    searchButton.click();
	}
}

