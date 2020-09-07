package com.datadriven.webTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.datadriven.objects.Locators.HomePage;
import utilities.KeywordUtil;

/**
 * We can test several ways using decision box R1 - Rule1 Conditions - R1 R2 R3
 * R4 ... UserName F T T T email F F T T password F F F T Re password F F F F
 *
 */
public class TestDemo2 extends KeywordUtil {

	@Test
	public static void openBrowser() {
		KeywordUtil.getChromeBrowser("chrome");
		KeywordUtil.navigateToUrl(KeywordUtil.getValue("URL"));
	}

	@Test(dependsOnMethods = { "openBrowser" })
	public void fill_the_accountformRule1() throws Exception {
		KeywordUtil.inputText(HomePage.userName, "");
		KeywordUtil.inputText(HomePage.email, "");
		KeywordUtil.inputText(HomePage.passWord, "");
		KeywordUtil.inputText(HomePage.conPassword, "");
		KeywordUtil.click(HomePage.stepOneBtn);
		String popUpErr = KeywordUtil.getWebElement((HomePage.popUpMessage)).getText();
		assertEquals(popUpErr, "Please Fill the Form Properly!", "Please Fill the Form Properly! not displayed");
		KeywordUtil.click(HomePage.confirm);
		String actualMandErr = KeywordUtil.getWebElement((HomePage.mandatoryError)).getText();
		String usrErr = KeywordUtil.getWebElement((HomePage.userNameErr)).getText();
		String actemailErr = KeywordUtil.getWebElement((HomePage.emailErr)).getText();
		String actpwErr = KeywordUtil.getWebElement((HomePage.passWordErr)).getText();
		String actrwdErr = KeywordUtil.getWebElement((HomePage.rePassWordErr)).getText();
		String path = KeywordUtil.getValue("testDataExcelPath");
		String sheetName = "formError";
		ExcelUtils.setExcelFile(path, sheetName);
		int iTestCaseRow1 = ExcelUtils.getRowContains("mainerror", 0);
		int iTestCaseRow2 = ExcelUtils.getRowContains("unameErr", 0);
		int iTestCaseRow3 = ExcelUtils.getRowContains("emailErr", 0);
		int iTestCaseRow4 = ExcelUtils.getRowContains("pwErr", 0);
		int iTestCaseRow5 = ExcelUtils.getRowContains("rpwErr", 0);
		Object[][] mandArrErr = ExcelUtils.getTableArray(path, sheetName, iTestCaseRow1);
		Object[][] userErr = ExcelUtils.getTableArray(path, sheetName, iTestCaseRow2);
		Object[][] eidErr = ExcelUtils.getTableArray(path, sheetName, iTestCaseRow3);
		Object[][] pwErr = ExcelUtils.getTableArray(path, sheetName, iTestCaseRow4);
		Object[][] rpwErr = ExcelUtils.getTableArray(path, sheetName, iTestCaseRow5);
		assertEquals(actualMandErr, mandArrErr[0][0].toString(), "Please enter UserName not displayed");
		assertEquals(usrErr, userErr[0][0].toString(), "Please enter UserName not displayed");
		assertEquals(actemailErr, eidErr[0][0].toString(), "Please enter valid email not displayed");
		assertEquals(actpwErr, pwErr[0][0].toString(), "Password should at least 6 character not displayed");
		assertEquals(actrwdErr, rpwErr[0][0].toString(), "Please retype password not diaplayed");
	}
	@AfterTest()
	public static void afterTest() {
		KeywordUtil.getDriver().quit();
	}
}
