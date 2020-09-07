package com.datadriven.webTests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import utilities.KeywordUtil;
import com.datadriven.objects.Locators.HomePage;

public class TestDemo extends KeywordUtil {

	String emailId = null;
	String userName = null;
	String passWord = null;
	String name = null;
	String firstName = null;
	String lastName = null;
	String gender = null;
	String phoneNumber = null;
	String dob = null;
	boolean randomFlag;
	String randomAddress = null;
	String cardNumber = null;
	String cvvExpDate = null;
	int cvvNumber = 0;

	/**
	 * Before test.
	 */
	@BeforeTest
	public void factorygirl_random_data_generator() throws Exception {
		// Factorygirl Random Data
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-IND"), new RandomService());
		Faker faker = new Faker();
		emailId = fakeValuesService.bothify("????##@gmail.com");
		userName = fakeValuesService.regexify("[a-z1-9]{10}");
		passWord = fakeValuesService.regexify("[a-z1-9]{10}");
		name = faker.name().fullName();
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
		phoneNumber = faker.phoneNumber().phoneNumber();
		randomAddress = faker.address().streetName() + "," + faker.address().buildingNumber() + ","
				+ faker.address().city() + "," + faker.address().country();
		randomFlag = faker.bool().bool();
		Date date = faker.date().birthday(18, 55);
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		String strDate = dateFormat.format(date);
		String[] val = strDate.split(" ");
		dob = val[0] + " " + val[1] + ", " + val[2];
		String number1 = faker.finance().creditCard();
		String[] temp = number1.split("-");
		cardNumber = temp[0] + temp[1] + temp[2] + temp[3];
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1); // to get previous year add -1
		Date nextYear = cal.getTime();
		DateFormat modifyDate = new SimpleDateFormat("yyyy");
		String yearVal = modifyDate.format(nextYear);
		cvvExpDate = val[1] + ", " + yearVal;
		Random random = new Random();
		cvvNumber = random.nextInt(900) + 100;
	}

	@Test
	public static void openBrowser() {
		KeywordUtil.getChromeBrowser("chrome");
		KeywordUtil.navigateToUrl(KeywordUtil.getValue("URL"));
	}

	@Test(dependsOnMethods = { "openBrowser" })
	public void fill_the_accountForm() {
		KeywordUtil.inputText(HomePage.userName, userName);
		KeywordUtil.inputText(HomePage.email, emailId);
		KeywordUtil.inputText(HomePage.passWord, passWord);
		KeywordUtil.inputText(HomePage.conPassword, passWord);
		KeywordUtil.click(HomePage.stepOneBtn);
	}

	@Test(dependsOnMethods = { "fill_the_accountForm" })
	public void fill_the_personalForm() {
		KeywordUtil.inputText(HomePage.fName, firstName);
		KeywordUtil.inputText(HomePage.lName, lastName);
		KeywordUtil.click(HomePage.gender);
		if (randomFlag == true) {
			KeywordUtil.click(HomePage.optMale);
		} else {
			KeywordUtil.click(HomePage.optFemal);
		}
		KeywordUtil.click(HomePage.gender);
		KeywordUtil.inputText(HomePage.birthDate, dob);
		KeywordUtil.inputText(HomePage.Aaddress, randomAddress);
		KeywordUtil.inputText(HomePage.phoneNuber, KeywordUtil.randomNumber());
		try {
			KeywordUtil.scrollingToElementofAPage(HomePage.preferedContact1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (randomFlag == true) {
			KeywordUtil.click(HomePage.preferedContact1);
		} else {
			KeywordUtil.click(HomePage.preferedContact2);
		}
		KeywordUtil.click(HomePage.step2Btn);
	}

	@Test(dependsOnMethods = { "fill_the_personalForm" })
	public void fill_the_paymentForm() {
		KeywordUtil.click(HomePage.paymentType);
		if (randomFlag == true) {
			KeywordUtil.click(HomePage.optMasterCard);
		} else {
			KeywordUtil.click(HomePage.optVisaCard);
		}
		KeywordUtil.inputText(HomePage.carduserName, firstName);
		KeywordUtil.inputText(HomePage.cardNumber, cardNumber);
		KeywordUtil.inputText(HomePage.cvcNumber, String.valueOf(cvvNumber));
		KeywordUtil.inputText(HomePage.expirydate, cvvExpDate);
		KeywordUtil.click(HomePage.carduserName);
		try {
			KeywordUtil.clickByJavaScript(HomePage.agreeTerm);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KeywordUtil.click(HomePage.step3Btn);
	}

	@Test(dependsOnMethods = { "fill_the_paymentForm" })
	public void confirmForm() {
		// TODO - ATM card number event firing issue on that - pattern="d*"
	}

	@AfterTest()
	public static void afterTest() {
		System.gc();
		KeywordUtil.getDriver().quit();
	}
}
