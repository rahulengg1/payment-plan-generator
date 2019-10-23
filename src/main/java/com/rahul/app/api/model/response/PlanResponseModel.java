package com.rahul.app.api.model.response;

/**
 * @author Rahul
 *
 */

public class PlanResponseModel {
	
	
	private double borrowerPaymentAmount;
	private String date;
	private double initialOutstandingPrincipal;
	private double interest;
	private double principal;
	private double remainingOutstandingPrincipal;
	
	/**
	 * @return the borrowerPaymentAmount
	 */
	public double getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}
	/**
	 * @param borrowerPaymentAmount the borrowerPaymentAmount to set
	 */
	public void setBorrowerPaymentAmount(double borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the initialOutstandingPrincipal
	 */
	public double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}
	/**
	 * @param initialOutstandingPrincipal the initialOutstandingPrincipal to set
	 */
	public void setInitialOutstandingPrincipal(double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}
	/**
	 * @return the interest
	 */
	public double getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}
	/**
	 * @return the principal
	 */
	public double getPrincipal() {
		return principal;
	}
	/**
	 * @param principal the principal to set
	 */
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	/**
	 * @return the remainingOutstandingPrincipal
	 */
	public double getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}
	/**
	 * @param remainingOutstandingPrincipal the remainingOutstandingPrincipal to set
	 */
	public void setRemainingOutstandingPrincipal(double remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}
	

	
	
}

