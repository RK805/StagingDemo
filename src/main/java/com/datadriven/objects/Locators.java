package com.datadriven.objects;

import org.openqa.selenium.By;

/**
 * This Java Class provides Element Ids
 * 
 * @author Rama
 *
 */

public class Locators {

	public static class HomePage {

		public static By userName = By.cssSelector("#uname");
		public static By email = By.cssSelector("#email");
		public static By passWord = By.cssSelector("#pass");
		public static By conPassword = By.cssSelector("#cpass");
		public static By stepOneBtn = By
				.xpath("//div[@class='form-group signUpForm-step-1']//button[normalize-space(.)='Next']");
		public static By fName = By.cssSelector("#fname");
		public static By lName = By.cssSelector("#lname");
		public static By gender = By.cssSelector("#gender");
		public static By optMale = By.xpath("//option[@value='Male']");
		public static By optFemal = By.xpath("//option[@value='Femal']");
		public static By birthDate = By.cssSelector("#birthdate");
		public static By Aaddress = By.cssSelector("#address");
		public static By phoneNuber = By.cssSelector("#phone");
		public static By preferedContact1 = By.xpath("//label[@for='preferedcontact1']");
		public static By preferedContact2 = By.xpath("//label[@for='preferedcontact2']");
		public static By step2Btn = By
				.xpath("//div[@class='form-group signUpForm-step-2']//button[normalize-space(.)='Next']");
		public static By paymentType = By.cssSelector("#paymenttype");
		public static By optMasterCard = By.xpath("//option[@value='Master Card']");
		public static By optVisaCard = By.xpath("//option[@value='Visa Card']");
		public static By carduserName = By.cssSelector("#hname");
		public static By cardNumber = By.cssSelector("#cardnumber");
		public static By cvcNumber = By.cssSelector("#cvc");
		public static By expirydate = By.cssSelector("#expirydate");
		public static By agreeTerm = By.xpath("//label[@for='aggre']");
		public static By step3Btn = By
				.xpath("//div[@class='form-group signUpForm-step-3']//button[normalize-space(.)='Next']");
		public static By confirm = By.cssSelector(".confirm");
		// Error
		public static By mandatoryError = By.xpath("//div[@class='help-block with-errors mandatory-error']//li");
		public static By userNameErr = By.xpath("//div[@class='form-group validuname has-error has-danger']//li");
		public static By emailErr = By.xpath("//div[@class='form-group validemail has-error has-danger']//li");
		public static By passWordErr = By.xpath("//div[@class='form-group validpass has-error has-danger']//li");
		public static By rePassWordErr = By.xpath("//div[@class='form-group has-error has-danger']//li");
		public static By popUpMessage = By.xpath("//div[@class='sa-icon sa-success']//following-sibling::p");

		
		//Inmat staging testcase objects
		public static By userNameInmarApp = By.cssSelector("#username");
		public static By passWordInmarApp = By.cssSelector("#password");
		public static By logIN = By.cssSelector("#login");
		
		
	}

	public static class DashBoardPage {
		
		public static By createOfferBTn = By.cssSelector("#createOfferFormButton");
		public static By posStartDateVal = By.xpath("//legend[text()='POS Start Date *']//parent::fieldset//div[@class='form-control reportrange-text']//div");
		public static By monthSelectBtn = By.xpath("//legend[text()='POS End Date *']//parent::fieldset//div[@class='calendar-icon']");
		public static By modal_Message = By.cssSelector("#modal_message");
		public static By continueBtn = By.cssSelector(".btn.btn-primary");
		   
		public static By offerDropDownBtn = By.xpath("//span[normalize-space(.)='Select Offer Type']");
		public static By offerTextBox = By.xpath("//input[@id='offer_type']");
		public static By brandTextBox = By.cssSelector("#brands");
		public static By requirementTextBox = By.cssSelector("#requirement_value");
		public static By requirement_quantity = By.cssSelector("#requirement_quantity");
		public static By shortDescriptiongTextBox = By.cssSelector("#en_us_short_description");
		public static By imageUpload = By.xpath("//input[@name='media_file']");
		public static By monthselectCol  = By.cssSelector(".monthselect.col");
//		public static By monthselectCol  = By.xpath("//th[@class='month']");
		public static By custom_field_billing  = By.cssSelector("#custom_field_billing");
		public static By manufacturer_offer_id  = By.cssSelector("#manufacturer_offer_id");
		public static By saveBtn  = By.cssSelector(".btn.submit-button.btn-secondary");
		
		public static By hoursBtn = By.xpath("//select[@class='hourselect']");
		public static By minuteBtn = By.xpath("//select[@class='minuteselect']");
		public static By ampmBtn = By.xpath("//select[@class='ampmselect']");
		public static By searchIDButton = By.cssSelector("#searchIDButton");
		public static By idSsearchType = By.cssSelector(".id_search_type.form-control.form-control-sm");
		public static By optmanfarID = By.xpath("//option[@value='manufacturer_offer_id']");
		public static By textoptmanfarID = By.xpath("//textarea[@class='search_input form-control no-mouseflow']");
		public static By offersIDSearchBtn = By.cssSelector("#offersIDSearch");
		public static By offerDetail = By.xpath("//div[@id='results']//div[contains(@class,'closed offer-draft')]");
		public static By actPOSStartDate = By.xpath("//div[contains(@class ,'offer-draft')]//tr[2]//td[1]");
		public static By actPOSEndDate = By.xpath("//div[contains(@class ,'offer-draft')]//tr[2]//td[2]");
		public static By actBrandName = By.xpath("//div[@id='results']//td[@class='brandsList']");
		public static By actmanfarID = By.xpath("//div[@id='results']//div[contains(@class ,'offer-draft')]//li[2]");
		public static By actTestDescrText = By.xpath("//div[@id='results']//p/span[@class='bold fourteen']");
		public static By userView = By.xpath("//div[@id='userinfo']");
		public static By logOut  = By.cssSelector("#logOut");
		public static By staging = By.xpath("//div[@class='staging']");
		
		public static By offerSearchOpt(String item) {
		    By offerSearchOption = By.xpath("//div[@class='opt-title semi-bold' and text()='"+item+"']");
			return offerSearchOption;
		}
		public static By brandSearchOpt(String item) {
			String val = item.trim();
		    By offerSearchOption = By.xpath("//a[@class='list-group-item list-group-item-action' and normalize-space(.)='"+val+"']");
			return offerSearchOption;
		}
		public static By monthOpt(String i) {
			
			By monthOpt = By.xpath("//div//select[@class='monthselect col']//option[@value='"+i+"']");
			return monthOpt;
		}
		public static By dayOpt(String c) {
			By dayOpt = By.xpath("//table[@class='table-condensed']//td[normalize-space(.)='"+c+"']");
			return dayOpt;
		}
		public static By hoursOpt(String c) {
			By dayOpt = By.xpath("//select[@class='hourselect']//option[text()='"+c+"']");
			return dayOpt;
		}
		public static By mintOpt(String c) {
			By dayOpt = By.xpath("//select[@class='minuteselect']//option[text()='"+c+"']");
			return dayOpt;
		}
		public static By ampmOpt(String c) {
			By dayOpt = By.xpath("//select[@class='ampmselect']//option[text()='"+c+"']");
			return dayOpt;
		}

	}

}
