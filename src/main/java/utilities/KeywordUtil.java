package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;


public class KeywordUtil extends GlobalUtil {
	static WebDriver driver = null;
	public static String cucumberTagName;
	private static final int DEFAULT_WAIT_SECONDS = 40;
	protected static final int FAIL = 0;
	static WebElement webElement;
	protected static String url = "";
	public static final String VALUE = "value";
	public static String lastAction = "";


	public static WebDriver getChromeBrowser(String browserName) {

		try {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    options.setExperimentalOption("prefs", prefs);
			options.addArguments("--window-size=1920,1200");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-web-security");
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--allow-running-insecure-content");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));

			options.addArguments("--ignore-certificate-errors");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

			GlobalUtil.driver = driver;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return driver;
	}
	
	public static void navigateToUrl(String url) {
		try {
			KeywordUtil.lastAction = "Navigate to: " + url;
//			 getDriver().navigate().to(url);
			getDriver().get(url);
			String Pagetitle = getDriver().getTitle();
			System.out.println(Pagetitle);
			if (Pagetitle.contains("Robot Check")) {
				getDriver().get(url);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebElement getWebElement(By locator) {
		KeywordUtil.lastAction = "Find Element: " + locator.toString();
		return getDriver().findElement(locator);
	}
	
	

	public static WebElement waitForVisible(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
			// wait.ignoring(ElementNotVisibleException.class);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			return null;
		}
	}
	
	

	public static boolean click(By locator) {

		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();

		KeywordUtil.lastAction = "Click: " + locator.toString();
		WebElement elm = waitForVisible(locator);
		if (elm == null) {
			return false;
		} else {
			elm.click();
			return true;
		}
	}

	public static boolean inputText(By locator, String data) {
		KeywordUtil.lastAction = "Input Text: " + data + " - " + locator.toString();
		WebElement elm = waitForVisible(locator);
		if (elm == null) {
			return false;
		} else {
			elm.clear();
			elm.sendKeys(data);
			return true;
		}
	}

	public static Properties loadPropertyFile(String filePath) {
		File file = new File(filePath);
		Properties prop = new Properties();

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;

	}

	public static String getValue(String key) {

		Properties prop = loadPropertyFile("src/main/resources/config.properties");
		 return prop.getProperty(key);
	}
	
	/**
	 * Execution delay.
	 *
	 * @param time
	 *            the time
	 */
	public static void executionDelay(long time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Switch to tab.
	 *
	 * @param tabNumber
	 *            the tab number
	 * @return true, if successful
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static boolean switchToTab(int tabNumber) throws InterruptedException {

		executionDelay(10000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(tabNumber));
		executionDelay(5000);

		return true;
	}
	
	/**
	 * Scrolling to elementof A page.
	 *
	 * @param by
	 *            the by
	 * @return true, if successful
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static boolean scrollingToElementofAPage(By by) throws InterruptedException {
		Thread.sleep(5000);
		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		// highLightElement(driver, element);
		return true;
	}
	
	public static String randomNumber() {
		String pnumb;
		Random num = new Random();
	      int num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11;
	      num0 = 9;
	      num1 = 1;
	      num2 = 9;
	      num3 = num.nextInt(9) + 10;
	      num4 = num.nextInt(10);
	      num5 = num.nextInt(5) + 11;
	      num6 = num.nextInt(10);
	      num7 = num.nextInt(3);
	      num8 = num.nextInt(5);
	      num9 = num.nextInt(10);
	      pnumb = num0 + num1 + "-" + num2 +  num3 + num4 +num5 +num6 +num7 + num8 +num9;
	      return pnumb;
	}
	/**
	 * Hover on element with click.
	 *
	 * @param by
	 *            the by
	 * @return true, if successful
	 */
	public static boolean hoverOnElementWithClick(By by) {
		WebElement element = getWebElement(by);
		executionDelay(4000);
		Actions act = new Actions(getDriver());
		act.moveToElement(element).click().build().perform();
        executionDelay(4000);
        return true;

	}

	/**
	 * Click by java script.
	 *
	 * @param by
	 *            the by
	 * @return true, if successful
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static boolean clickByJavaScript(By by) throws InterruptedException {
		executionDelay(1000);
		WebElement element = getWebElement(by);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
		return true;
	}
	
	/**
	 * Explicit wait for element.
	 *
	 * @param by
	 *            the by
	 * @return the web element
	 */
	public static WebElement explicitWaitForElement(By by) {
		long time  = Long.parseLong(getValue("explicit_timeout"));
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		return driver.findElement(by);
	}
}
