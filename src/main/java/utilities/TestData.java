package utilities;

// TODO: Auto-generated Javadoc
/**
 * The Class TestData.
 */
public class TestData {

	/** The test set. */
	private String testSet;

	/** The test case ID. */
	private String testCaseID;

	/** The test case summary. */
	private String testCaseSummary;

	/** The complexity. */
	private String complexity;

	/** The browser. */
	private String browser;

	/** The platform. */
	private String platform;

	/**
	 * Gets the complexity.
	 *
	 * @return the complexity
	 */
	public String getComplexity() {
		return complexity;
	}

	/**
	 * Sets the complexity.
	 *
	 * @param complexity
	 *            the new complexity
	 */
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	/**
	 * Gets the platform.
	 *
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * Sets the platform.
	 *
	 * @param platform
	 *            the new platform
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * Gets the test set.
	 *
	 * @return the test set
	 */
	public String getTestSet() {
		return testSet;
	}

	/**
	 * Sets the test set.
	 *
	 * @param testSet
	 *            the new test set
	 */
	public void setTestSet(String testSet) {
		this.testSet = testSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestData [testSet=" + testSet + ", testCaseID=" + testCaseID + ", testCaseSummary=" + testCaseSummary
				+ ", complexity=" + complexity + ", estimatedExecutionTime=" + browser + "]";
	}

	/**
	 * Gets the test case ID.
	 *
	 * @return the test case ID
	 */
	public String getTestCaseID() {
		return testCaseID;
	}

	/**
	 * Sets the test case ID.
	 *
	 * @param testCaseID
	 *            the new test case ID
	 */
	public void setTestCaseID(String testCaseID) {
		this.testCaseID = testCaseID;
	}

	/**
	 * Gets the test case summary.
	 *
	 * @return the test case summary
	 */
	public String getTestCaseSummary() {
		return testCaseSummary;
	}

	/**
	 * Sets the test case summary.
	 *
	 * @param testCaseSummary
	 *            the new test case summary
	 */
	public void setTestCaseSummary(String testCaseSummary) {
		this.testCaseSummary = testCaseSummary;
	}

	/**
	 * Gets the browser.
	 *
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * Sets the browser.
	 *
	 * @param currentBrowser
	 *            the new browser
	 */
	public void setBrowser(String currentBrowser) {
		this.browser = currentBrowser;
	}

}
