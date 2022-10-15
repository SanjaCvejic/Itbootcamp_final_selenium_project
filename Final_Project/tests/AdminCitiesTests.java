package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminCitiesTests extends BasicTest {

	@Test(priority = 10)
	public void VisitsTheAdminCitiesPageAndListCities() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
				"ERROR: URL does not contain '/admin/cities'");
	}

	@Test(priority = 20)
	public void ChecksInputTypesForCreateEditNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForCreateOrEditDialogToBeVisible();
		Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"), "text",
				"ERROR: New item name is not type 'text'");
	}

	@Test(priority = 30)
	public void CreateNewCity() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForCreateOrEditDialogToBeVisible();
		citiesPage.getNewItemInput().sendKeys("S.C's city");
		citiesPage.getSaveButton().click();
		citiesPage.waitForMessageSuccessfullySaveCity();
		Assert.assertTrue(citiesPage.getMessageTextSuccessfullySaveCity().getText().contains("Saved successfully"),
				"ERROR: The message does not contain 'Saved successfully'");
	}

	@Test(priority = 40)
	public void EditCity() throws InterruptedException {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("S.C's city");
		citiesPage.waitForNumberOfRaws(1);
		citiesPage.waitEditButton(1).click();
		citiesPage.waitForCreateOrEditDialogToBeVisible();
		Thread.sleep(1000);
		citiesPage.getEditItemInput().sendKeys(Keys.CONTROL, "a");
		citiesPage.getEditItemInput().sendKeys(Keys.DELETE);
		citiesPage.getEditItemInput().sendKeys("Sanja's city");
		citiesPage.getSaveButton().click();
		citiesPage.waitForMessageSuccessfullySaveCity();
		Assert.assertTrue(citiesPage.getMessageTextSuccessfullySaveCity().getText().contains("Saved successfully"),
				"ERROR: The message from pop-up does not contain 'Saved successfully'");
	}

	@Test(priority = 50)
	public void SearchCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Sanja's city");
		citiesPage.waitForNumberOfRaws(1);
		citiesPage.waitCellFromTheTable(1, 2);
		Assert.assertEquals(citiesPage.waitCellFromTheTable(1, 2).getText(), "Sanja C's city",
				"ERROR: City with that name does not exist.");
	}

	@Test(priority = 60)
	public void DeleteCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Sanja's city");
		citiesPage.waitForNumberOfRaws(1);
		citiesPage.waitCellFromTheTable(1, 2);
		Assert.assertEquals(citiesPage.waitCellFromTheTable(1, 2).getText(), "Sanja C's city",
				"ERROR: City with that name does not exist.");
		citiesPage.waitDeleteButton(1).click();
		citiesPage.waitForDeleteDialogToBeVisible();
		citiesPage.getDeleteButton().click();
		citiesPage.waitForMessageSuccessfullySaveCity();
		Assert.assertTrue(citiesPage.getMessageTextSuccessfullySaveCity().getText().contains("Deleted successfully"),
				"ERROR: The message does not contain 'Deleted successfully'");
	}
}