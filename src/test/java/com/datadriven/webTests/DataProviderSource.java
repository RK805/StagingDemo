package com.datadriven.webTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.KeywordUtil;

public class DataProviderSource {
	@DataProvider
    public static Object[][] getScenarioData(String OrderId) throws Exception {       
        String path = KeywordUtil.getValue("TestOfferValuesData");
		String sheetName = "offer export";
		ExcelUtils.setExcelFile(path, sheetName);
		int iTestCaseRow1 = ExcelUtils.getRowContains(OrderId, 0);
		Object[][] mandArrErr = ExcelUtils.getOrderArray(path, sheetName, iTestCaseRow1);
		return  mandArrErr;
    }   
}
