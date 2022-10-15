package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.MessagePopUpPage;

public class SignUpTests extends BasicTest {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority = 10)
	public void VisitsTheSignupPage() {
		navPage.getSignUpButton().click();
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/signup", "ERROR: URL does not contain '/signup' route");	
	}
	
	@Test(priority = 20)
	public void ChecksInputTypes() {
		navPage.getSignUpButton().click();
		WebElement email = signUpPage.getEmailInput();
		softAssert.assertEquals(email.getAttribute("type"), "email", "ERROR: Email is not type 'email'");
		WebElement password = signUpPage.getPasswordInput();
		softAssert.assertEquals(password.getAttribute("type"), "password", "ERROR: Password is not type 'password'");
		WebElement confirmPassword = signUpPage.getConfirmPasswordInput();
		softAssert.assertEquals(password.getAttribute("type"), "password", "ERROR: Confirm password is not type 'password'");
		softAssert.assertAll();
	}
	
	@Test(priority = 30)
	public void  DisplaysErrorsWhenAlreadyExist() {
		navPage.getSignUpButton().click();
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/signup", "ERROR: URL route does not contain '/signup'");
        signUpPage.getNameInput().sendKeys("Another User");
        signUpPage.getEmailInput().sendKeys ("admin@admin.com");
        signUpPage.getPasswordInput().sendKeys("12345");
        signUpPage.getConfirmPasswordInput().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        WebElement errorMessage = messagePopUpPage.getPopUpErrorMessage();
		softAssert.assertEquals(errorMessage.getText(), "E-mail already exists");
		String currentUrl1 = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl1, "https://vue-demo.daniel-avellaneda.com/signup");
	}
	
	@Test(priority = 40)
	public void Signup() {
		navPage.getSignUpButton().click();
		signUpPage.getNameInput().sendKeys("Sanja Cvejic");
	    signUpPage.getEmailInput().sendKeys ("sanja.cvejic207@itbootcamp.rs");
	    signUpPage.getPasswordInput().sendKeys("12345");
	    signUpPage.getConfirmPasswordInput().sendKeys("12345");
	    signUpPage.getSignMeUpButton().click();
	    String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, "https://vue-demo.daniel-avellaneda.com/home");
		messagePopUpPage.getCloseButtonFromVerifyAccountPopUp().click();
		navPage.getLogoutButton().click();
	}

}
