package com.rahul.app.api.model.response;

import java.util.Date;
import java.util.List;


/**
 * @author Rahul
 *
 */

public class ErrorMessage {
	
	
	private Date timeStamp;
	private int status;
	private List<String> error;
	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the error
	 */
	public List<String> getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(List<String> error) {
		this.error = error;
	}
	
	

}
