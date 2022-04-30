import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FindAllBrokenAssignment {

	public static void findAllBrokenLinks() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://stackoverflow.com/questions");

		List<WebElement> linkElems = driver.findElements(By.cssSelector("a"));
		List<String> invalidUrlsList = new ArrayList<String>();
		linkElems.forEach(ele -> {
			String url = ele.getAttribute("href");
			if (url != null && !url.isEmpty() && url.contains(".") && !checkIsUrlValid(url)) {
				invalidUrlsList.add(url);
			}
		});

		if (driver != null) {
			driver.quit();
		}

		System.out.println("List of invalid Url : " + invalidUrlsList);
	}

	public static boolean checkIsUrlValid(String url) {
		System.out.println(url);
		try {
			Response urlResp = RestAssured.given().when().get(url).then().extract().response();
			return urlResp.getStatusCode() == 200;
		} catch (Exception e) {
			return false;
		}

	}

	public static void main(String[] args) {
		findAllBrokenLinks();
	}
}
