package utilities;

// TODO: Auto-generated Javadoc
/**
 * The Class TestResults.
 */
public class TestResults {

	/** The date of execution. */
	private String dateOfExecution;

	/** The total time taken. */
	private long totalTimeTaken;

	/** The result status. */
	private String resultStatus;

	/** The reason for failure. */
	private String reasonForFailure;

	/** The failed screen shot reference. */
	private String failedScreenShotReference;

	/**
	 * Gets the date of execution.
	 *
	 * @return the date of execution
	 */
	public String getDateOfExecution() {
		return dateOfExecution;
	}

	/**
	 * Sets the date of execution.
	 *
	 * @param dateOfExecution
	 *            the new date of execution
	 */
	public void setDateOfExecution(String dateOfExecution) {
		this.dateOfExecution = dateOfExecution;
	}

	/**
	 * Gets the result status.
	 *
	 * @return the result status
	 */
	public String getResultStatus() {
		return resultStatus;
	}

	/**
	 * Sets the result status.
	 *
	 * @param resultStatus
	 *            the new result status
	 */
	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus.toUpperCase();
	}

	/**
	 * Gets the total time taken.
	 *
	 * @return the total time taken
	 */
	public long getTotalTimeTaken() {
		return totalTimeTaken;
	}

	/**
	 * Sets the total time taken.
	 *
	 * @param totalTimeTaken
	 *            the new total time taken
	 */
	public void setTotalTimeTaken(long totalTimeTaken) {
		this.totalTimeTaken = totalTimeTaken;
	}

	/**
	 * Gets the reason for failure.
	 *
	 * @return the reason for failure
	 */
	public String getReasonForFailure() {
		return reasonForFailure;
	}

	/**
	 * Sets the reason for failure.
	 *
	 * @param reasonForFailure
	 *            the new reason for failure
	 */
	public void setReasonForFailure(String reasonForFailure) {
		this.reasonForFailure = reasonForFailure;
	}

	/**
	 * Gets the failed screen shot reference.
	 *
	 * @return the failed screen shot reference
	 */
	public String getFailedScreenShotReference() {
		return failedScreenShotReference;
	}

	/**
	 * Sets the failed screen shot reference.
	 *
	 * @param failedScreenShotReference
	 *            the new failed screen shot reference
	 */
	public void setFailedScreenShotReference(String failedScreenShotReference) {
		this.failedScreenShotReference = failedScreenShotReference;
	}

}
