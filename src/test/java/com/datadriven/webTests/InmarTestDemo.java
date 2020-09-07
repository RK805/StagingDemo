package com.datadriven.webTests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.KeywordUtil;
import com.datadriven.objects.Locators.DashBoardPage;
import com.datadriven.objects.Locators.HomePage;

public class InmarTestDemo extends KeywordUtil {

	String path = KeywordUtil.getValue("TestOfferValuesData");
	String sheetName = "offer export";
	String date;
	String brandName;
	String shortMessage;
	String[] values;
	String month;
	String currentUsersDir = System.getProperty("user.dir");
	String imgFolder = currentUsersDir + "\\src\\test\\resources\\test.jpg";
	Random random = new Random();
	int randomval = random.nextInt(90000) + 10000;
	// Create the random manufacturerOfferId so we can run this script no of times 
	String manufacturerOfferId = String.valueOf(randomval);

	/**
	 * Before test - launch the browser and navigating Url .
	 */

	@BeforeTest
	public void openBrowser() throws Exception {
		KeywordUtil.getChromeBrowser("chrome");
		KeywordUtil.navigateToUrl(KeywordUtil.getValue("InmarURL"));
		KeywordUtil.waitForVisible(HomePage.userNameInmarApp);
		KeywordUtil.inputText(HomePage.userNameInmarApp, KeywordUtil.getValue("UserName"));
		KeywordUtil.inputText(HomePage.passWordInmarApp, KeywordUtil.getValue("PassWord"));
		KeywordUtil.click(HomePage.logIN);
	}

	@Test()
	public static void clicktheCreateOfferBtn() {
		KeywordUtil.waitForVisible(DashBoardPage.modal_Message);
		if (KeywordUtil.getWebElement((DashBoardPage.modal_Message)).isDisplayed())
			KeywordUtil.click(DashBoardPage.continueBtn);
		KeywordUtil.waitForVisible(DashBoardPage.createOfferBTn);
		KeywordUtil.click(DashBoardPage.createOfferBTn);
	}

	@Test(dependsOnMethods = { "clicktheCreateOfferBtn" })
	public void fillData_for_toCreate_Offer() throws Exception {
		ExcelUtils.setExcelFile(path, sheetName);
		int testCaseRow = ExcelUtils.getRowContains("156839", 0);
		Object[][] ordervalues = ExcelUtils.getOrderArray(path, sheetName, testCaseRow);
		String str = Arrays.deepToString(ordervalues);
		String remove1stChars = str.substring(2);
		String removeLast2Chars = remove1stChars.substring(0, remove1stChars.length() - 2);
		values = removeLast2Chars.split(",");
		LocalDate futureDate = LocalDate.now().plusMonths(1);
		KeywordUtil.waitForVisible(DashBoardPage.offerDropDownBtn);
		KeywordUtil.click(DashBoardPage.offerDropDownBtn);
		KeywordUtil.inputText(DashBoardPage.offerTextBox, values[0]);
		if (KeywordUtil.getWebElement(DashBoardPage.offerSearchOpt(values[0])).isDisplayed()) {
			KeywordUtil.waitForVisible(DashBoardPage.offerSearchOpt(values[0]));
			KeywordUtil.click(DashBoardPage.offerSearchOpt(values[0]));
		} else {
			System.out.println("Required offer type was not found.");
			assertEquals(true, false, "Required offer type was not found.");
		}
		KeywordUtil.inputText(DashBoardPage.brandTextBox, values[1]);
		KeywordUtil.scrollingToElementofAPage(DashBoardPage.brandTextBox);
		if (KeywordUtil.getWebElement(DashBoardPage.brandSearchOpt(values[1])).isDisplayed()) {
			KeywordUtil.waitForVisible(DashBoardPage.brandSearchOpt(values[1]));
			KeywordUtil.click(DashBoardPage.brandSearchOpt(values[1]));
		} else {
			System.out.println("Required brand type was not found.");
			assertEquals(true, false, "Required brand type was not found.");
		}
		KeywordUtil.inputText(DashBoardPage.manufacturer_offer_id, manufacturerOfferId);
		KeywordUtil.inputText(DashBoardPage.requirementTextBox, values[2]);
		KeywordUtil.inputText(DashBoardPage.requirement_quantity, values[4]);
		KeywordUtil.scrollingToElementofAPage(DashBoardPage.monthSelectBtn);
		KeywordUtil.click(DashBoardPage.monthSelectBtn);
		KeywordUtil.click(DashBoardPage.monthselectCol);
		month = String.valueOf(futureDate.getMonthValue() - 1);
		String data = String.valueOf(futureDate.getDayOfMonth());
		KeywordUtil.click(DashBoardPage.monthOpt(month));
		KeywordUtil.click(DashBoardPage.dayOpt(data));
		String startDateVal = KeywordUtil.getWebElement((DashBoardPage.posStartDateVal)).getText();
		System.out.println("fhdsh" + startDateVal);
		StringBuilder builder = new StringBuilder(startDateVal);
		date = builder.substring(0, 8);
		String hours = builder.substring(10, 12);
		String min = builder.substring(13, 15);
		String ampmselect = builder.substring(15, 17);
		System.out.println(hours);
		System.out.println(min);
		System.out.println(ampmselect);
		// We can use Autoit s/w for upload functionality
		getDriver().findElement(DashBoardPage.imageUpload).sendKeys(imgFolder);
		KeywordUtil.inputText(DashBoardPage.custom_field_billing, values[5]);
		KeywordUtil.click(DashBoardPage.monthSelectBtn);
		KeywordUtil.click(DashBoardPage.hoursBtn);
		KeywordUtil.click(DashBoardPage.hoursOpt(hours));
		KeywordUtil.click(DashBoardPage.minuteBtn);
		KeywordUtil.click(DashBoardPage.mintOpt(min));
		KeywordUtil.click(DashBoardPage.ampmBtn);
		KeywordUtil.click(DashBoardPage.ampmOpt(ampmselect));
		KeywordUtil.click(DashBoardPage.shortDescriptiongTextBox);
		KeywordUtil.inputText(DashBoardPage.shortDescriptiongTextBox, values[3]);
		KeywordUtil.clickByJavaScript(DashBoardPage.saveBtn);
	}

	@Test(dependsOnMethods = { "fillData_for_toCreate_Offer" })
	public void verify_the_offer_values() throws Exception {
		KeywordUtil.explicitWaitForElement(DashBoardPage.searchIDButton);
//		KeywordUtil.click(DashBoardPage.searchIDButton);
//		KeywordUtil.click(DashBoardPage.idSsearchType);
		KeywordUtil.clickByJavaScript(DashBoardPage.searchIDButton);
		KeywordUtil.waitForVisible(DashBoardPage.idSsearchType);
		KeywordUtil.clickByJavaScript(DashBoardPage.idSsearchType);
		KeywordUtil.click(DashBoardPage.optmanfarID);
		System.out.println("manufacturerOfferId " + manufacturerOfferId);
		KeywordUtil.inputText(DashBoardPage.textoptmanfarID, manufacturerOfferId);
		KeywordUtil.click(DashBoardPage.offersIDSearchBtn);
		KeywordUtil.click(DashBoardPage.staging);
		KeywordUtil.waitForVisible(DashBoardPage.offerDetail);
		KeywordUtil.hoverOnElementWithClick(DashBoardPage.offerDetail);
		String actPOSStartDate = KeywordUtil.getWebElement((DashBoardPage.actPOSStartDate)).getAttribute("innerText");
		String actPOSEndDate = KeywordUtil.getWebElement((DashBoardPage.actPOSEndDate)).getAttribute("innerText");
		String actBrandName = KeywordUtil.getWebElement((DashBoardPage.actBrandName)).getAttribute("innerText");
		String actTestDescrText = KeywordUtil.getWebElement((DashBoardPage.actTestDescrText)).getText();
		String actmanfarID = KeywordUtil.getWebElement((DashBoardPage.actmanfarID)).getAttribute("innerText");
		StringBuilder builderSDate = new StringBuilder(actPOSStartDate);
		String sdate = builderSDate.substring(0, 6) + builderSDate.substring(8, 10);
		StringBuilder builderLDtae = new StringBuilder(actPOSEndDate);
		String ldate = builderLDtae.substring(0, 6) + builderLDtae.substring(8, 10);
		String expdate = month + builderLDtae.substring(2, 8);
		System.out.println("actPOSStartDate " + actPOSStartDate);
		System.out.println("sdate " + sdate);
		System.out.println("date " + date);
		assertEquals(sdate, date, "actPOSStartDate not displayed");
		// assertEquals(ldate, expdate, "actPOSEndDate not displayed");
		assertEquals(actBrandName.trim(), values[1].trim(), "actBrandName not displayed");
		assertEquals(actTestDescrText.trim(), values[3].trim(), "actTestDescrText not displayed");
		System.out.println("actmanfarID " + actmanfarID);
		StringBuilder builderMiD = new StringBuilder(actmanfarID);
		String mmid = builderMiD.substring(23, 28);
		assertEquals(mmid, manufacturerOfferId, "manufacturerOfferId not displayed");
	}

	@AfterTest()
	public static void afterTest() throws InterruptedException {
		KeywordUtil.hoverOnElementWithClick(DashBoardPage.userView);
		KeywordUtil.click(DashBoardPage.logOut);
		KeywordUtil.getDriver().quit();
	}
}
