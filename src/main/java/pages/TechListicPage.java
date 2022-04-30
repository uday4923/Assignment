package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TechListicPage {
	WebDriver driver;

	@FindBy(name = "firstname")
	public WebElement firstNameField;

	@FindBy(name = "lastname")
	public WebElement lastNameField;

	@FindBy(css = ".button")
	private WebElement submitButton;

	@FindBy(xpath = "//div[@class='control-group']/b[contains(text(),'Gender')]/following-sibling::input")
	private List<WebElement> genderCheckBox;

	@FindBy(xpath = "//div[@class='control-group']/span[text()='Years of Experience']/following-sibling::input")
	private List<WebElement> experinceCheckBox;

	@FindBy(xpath = "//div[@class='control-group']/span[text()='Profession']/following-sibling::input")
	private List<WebElement> professionCheckBox;

	@FindBy(xpath = "//div[@class='control-group']/span[text()='Automation Tools']/following-sibling::input")
	private List<WebElement> automationToolCheckBox;

	@FindBy(css = "#continents")
	private WebElement continentsSelectEle;
	
	
	@FindBy(css = ".input-file")
	private WebElement uploadFileButton;
	
	public TechListicPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstName) {
		scrollTo(driver.findElement(By.name("firstname")));
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		scrollTo(lastNameField);
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
	}

	public void selectGender(String gender) {
		scrollTo(genderCheckBox.get(0));
		if (gender.equalsIgnoreCase("male")) {
			genderCheckBox.get(0).click();
		} else {
			genderCheckBox.get(1).click();
		}
	}

	public void selectYearOfExperience(int exp) {
		scrollTo(experinceCheckBox.get(0));
		experinceCheckBox.get(exp - 1).click();
	}

	public void selectProfession(String profession) {
		scrollTo(professionCheckBox.get(0));
		if (profession.equalsIgnoreCase("manual")) {
			professionCheckBox.get(0).click();
		} else {
			professionCheckBox.get(1).click();
		}
	}

	public void selectAutomationTool(String tool) {
		scrollTo(automationToolCheckBox.get(0));
		if (tool.equalsIgnoreCase("uft")) {
			automationToolCheckBox.get(0).click();
		} else if (tool.equalsIgnoreCase("protractor")) {
			automationToolCheckBox.get(1).click();
		} else {
			automationToolCheckBox.get(2).click();
		}
	}

	public void selectContinents(String value) {
		continentsSelectEle.click();
		continentsSelectEle.findElement(By.xpath("./option[text()='"+ value + "']")).click();
	}

	public void selectCommands() {

	}

	public void uploadFile() {
		uploadFileButton.sendKeys(System.getProperty("user.dir") + "/pom.xml");
	}

	public void clickSubmitButton() {
		submitButton.click();
	}
	
	private void scrollTo(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void hardwait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (Exception e) {

		}
	}
}
