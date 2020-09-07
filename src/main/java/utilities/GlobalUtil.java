package utilities;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;


/**
 * This class will get date and time and it will rename the file with date and
 * time
 *
 */
public class GlobalUtil {

	public static WebDriver driver = null;
	private static String currentBrowser;
	private static String currentSuiteName;
	static String currentUserFirstName;
	static String currentUserLastName;
	public static String currentUserFullName;
	public static String result_FolderName = System.getProperty("user.dir") + "/target/cucumber-html-report";
	public static String ErrorMsg;
	public static Throwable e;

	protected static final HashMap<String, String> popupCurrentData = new HashMap<String, String>();

	/**
	 * Get data and time stamp
	 */
	public static String getDateTime() {
		Calendar cal = Calendar.getInstance();
		System.out.println("current date: " + cal.getTime());
		cal.add(Calendar.DATE, 1);
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
		String dateOfExecution = dateFormat.format(date);
		System.out.println(dateOfExecution);
		return dateOfExecution;
	}

	/**
	 * @return the currentBrowser
	 */
	public static String getCurrentBrowser() {
		return currentBrowser;
	}

	/**
	 * @param currentBrowser
	 *            the currentBrowser to set
	 */
	public static void setCurrentBrowser(String currentBrowser) {
		GlobalUtil.currentBrowser = currentBrowser;
	}

	/**
	 * @return the currentSuiteName
	 */
	public static String getCurrentSuiteName() {
		return currentSuiteName;
	}

	/**
	 * @param currentSuiteName
	 *            the currentSuiteName to set
	 */
	public static void setCurrentSuiteName(String currentSuiteName) {
		GlobalUtil.currentSuiteName = currentSuiteName;
	}


	public static WebDriver getDriver() {
		return driver;
	}

	

	/**
	 * @param driver
	 *            the driver to set
	 */
	public static void setDriver(WebDriver driver) {
		GlobalUtil.driver = driver;
	}

	

}
