package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
	}

	public WebElement getPopUpErrorMessage() {
		return driver.findElement(By.xpath("//div[@class = 'v-snack__content']/ul/li"));

	}

	public WebElement getCloseButtonFromPopUpMessage() {
		return driver.findElement(By.xpath("//button//*[text() = 'Close']"));
	}

	public WebElement getSuccessPopUpText() {
		return driver.findElement(By.xpath("//div[contains(@class, 'success')]/div[@role='status']"));
	}

	public WebElement getMessageFromVerifyAccountImportant() {
		return driver.findElement(By.className("dlgVerifyAccount"));
	}

	public WebElement getCloseButtonFromVerifyAccountPopUp() {
		return driver.findElement(By.className("btnClose"));
	}

	public void waitForPopUpToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-snack__content')]")));
	}
			
	public void waitForVerifyAcountPopUp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
	}

	public void waitForSuccessPopUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
	}

}
