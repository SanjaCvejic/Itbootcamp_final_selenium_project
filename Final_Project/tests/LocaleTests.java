package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LocaleTests extends BasicTest{
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority = 10)
	public void SetLocaleToES() {
		navPage.getLanguageButton().click();
		navPage.getSpanishLanguageButton().click();
		softAssert.assertEquals(navPage.getHeaderText().getText(), "Página de aterrizaje", "ERROR: Header does not contain text 'Página de aterrizaje' ");
		softAssert.assertAll();
	}
	
	@Test(priority = 20)
	public void SetLocaleToEN() {
		navPage.getLanguageButton().click();
		navPage.getEnglishLanguageButton().click();
		softAssert.assertEquals(navPage.getHeaderText().getText(), "Landing", "ERROR: Header does not contain text 'Landing' ");
		softAssert.assertAll();
	}
	
	@Test(priority = 30)
	public void SetLocaleToCN() {
		navPage.getLanguageButton().click();
		navPage.getChinaLanguageButton().click();
		softAssert.assertEquals(navPage.getHeaderText().getText(), "首页", "ERROR: Header does not contain text '首页' ");
		softAssert.assertAll();
	}
	
	@Test(priority = 40)
	public void SetLocaleToFR() {
		navPage.getLanguageButton().click();
		navPage.getFrenchLanguageButton().click();
		softAssert.assertEquals(navPage.getHeaderText().getText(), "Page d'atterrissage");
		softAssert.assertAll();
	}

}
