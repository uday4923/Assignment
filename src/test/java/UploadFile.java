import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.TechListicPage;

public class UploadFile {
	WebDriver driver;

	public void startDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
		webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("body")));
	}

	public void uploadFile() {
		TechListicPage techListPage = new TechListicPage(this.driver);
		techListPage.hardwait(3);
		techListPage.enterFirstName("uday");
		techListPage.enterLastName("kumar");
		techListPage.selectGender("Male");
		techListPage.selectYearOfExperience(2);
		techListPage.selectProfession("manual");
		techListPage.selectAutomationTool("uft");
		techListPage.selectContinents("Africa");
		techListPage.uploadFile();
		techListPage.clickSubmitButton();
	}

	public static void main(String[] args) {
		UploadFile uploadFile = new UploadFile();
		uploadFile.startDriver();
		uploadFile.uploadFile();
	}
}
