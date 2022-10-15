package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getHomeLink() {
		return driver.findElement(By.className("btnHome"));
	}

	public WebElement getAboutLink() {
		return driver.findElement(By.className("btnAbout"));
	}

	public WebElement getMyProfileLink() {
		return driver.findElement(By.className("btnProfile"));
	}

	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}

	public WebElement getCitiesLink() {
		return driver.findElement(By.className("btnAdminCities"));
	}

	public WebElement getUsersLink() {
		return driver.findElement(By.className("btnAdminUsers"));
	}

	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//*[text() = ' Sign Up ']"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//a[contains(@class, 'btnLogin')]"));
	}

	public WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
	}

	public WebElement getLanguageButton() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
	}

	public WebElement getEnglishLanguageButton() {
		return driver
				.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]//span[contains(@class, 'f-gb')]"));
	}

	public WebElement getSpanishLanguageButton() {
		return driver
				.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]//span[contains(@class, 'f-es')]"));
	}

	public WebElement getHeaderText() {
		return driver.findElement(By.xpath("//h1"));
	}

	public WebElement getFrenchLanguageButton() {
		return driver
				.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]//span[contains(@class, 'f-fr')]"));
	}

	public WebElement getChinaLanguageButton() {
		return driver
				.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]//span[contains(@class, 'f-cn')]"));
	}
}
