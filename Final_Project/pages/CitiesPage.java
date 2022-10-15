package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getNewItemButton() {
		return driver.findElement(By.className("btnNewItem"));
	}

	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}

	public WebElement getNewItemInput() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getEditItemInput() {
		return driver.findElement(By.xpath("//input[@id = 'name']"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.className("btnSave"));
	}
	
	public WebElement getMessageTextSuccessfullySaveCity() {
        return driver.findElement(By.className("success"));
    }

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[text() = ' Delete ']"));
	}
	
	public void waitForDeleteDialogToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-dialog')]//div[text() = 'Warning']")));
	}
	
	public void waitForCreateOrEditDialogToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
	}

	public void waitForNumberOfRaws(int rawNumber) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rawNumber));
	}

	 public void waitForMessageSuccessfullySaveCity() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
	    }
	
	public WebElement waitCellFromTheTable(int rowNumber, int columnNumber) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + columnNumber + "]"));
	}

	public WebElement waitEditButton(int rowNumber) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//button[@id = 'edit']"));
	}

	public WebElement waitDeleteButton(int rowNumber) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//div/button[2]"));
	}

}
