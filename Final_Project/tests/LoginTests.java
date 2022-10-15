package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends BasicTest {

	@Test(priority = 10)
	public void VisitsTheLoginPage() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLanguageButton().click();
		navPage.getEnglishLanguageButton().click();
		navPage.getLoginButton().click();
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/login",
				"ERROR: URL does not contain '/login' route");
		softAssert.assertAll();
	}

	@Test(priority = 20)
	public void ChecksInputTypes() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLoginButton().click();
		WebElement email = loginPage.getEmailInput();
		softAssert.assertEquals(email.getAttribute("type"), "email", "Email attribute is not 'email'");
		WebElement password = loginPage.getPasswordInput();
		softAssert.assertEquals(password.getAttribute("type"), "password", "Password attribute is not 'password'");
		softAssert.assertAll();
	}

	@Test(priority = 30)
	public void DisplaysErrorsWhenUserDoesNotExist() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("non-existing-user@gmail.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		WebElement errorMessage = messagePopUpPage.getPopUpErrorMessage();
		softAssert.assertEquals(errorMessage.getText(), "User does not exists",
				"ERROR: Pop up message does not contain 'User does not exists' text");
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/login",
				"ERROR: Page URL does not contain '/login' route");
		softAssert.assertAll();
	}

	@Test(priority = 40)
	public void DisplaysErrorsWhenPasswordIsWrong() {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLoginButton().click();
		;
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		WebElement wrongPassword = messagePopUpPage.getPopUpErrorMessage();
		softAssert.assertEquals(wrongPassword.getText(), "Wrong password",
				"ERROR: Message does not contain 'Wrong password' text");
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/login",
				"ERROR: Page URL does not contain '/login' route");
	}

	@Test(priority = 50)
	public void Login() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		Thread.sleep(1000);
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/home",
				"ERROR: Page URL does not contain '/home'");

	}

	@Test(priority = 60)
	public void logout() {
		SoftAssert softAssert = new SoftAssert();
		WebElement logoutButton = navPage.getLogoutButton();
		softAssert.assertTrue(logoutButton.isDisplayed(), "ERROR: Logout button in not visible");
		logoutButton.click();
	}

}
