package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AuthRoutesTests extends BasicTest {

	SoftAssert softAssert = new SoftAssert();

	@Test(priority = 10)
	public void ForbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.navigate().to(baseUrl + "/home");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: URL does not contain '/login' ");
	}

	@Test(priority = 20)
	public void ForbidsVisitsToProfileUrlIfNotAuthenticated() {
		driver.navigate().to(baseUrl + "/profile");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: URL does not contain '/login' ");
	}

	@Test(priority = 30)
	public void ForbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/cities");
		softAssert.assertEquals(baseUrl + "/login", "https://vue-demo.daniel-avellaneda.com/login",
				"ERROR: URL does not contain '/login' ");
		softAssert.assertAll();
	}

	@Test(priority = 40)
	public void ForbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
		driver.navigate().to(baseUrl + "/admin/users");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: URL does not contain '/login' ");
	}

}
