package com.rahul.app.api.shared;

import java.io.Serializable;
import java.math.BigDecimal;

public class PlanGeneratorDto implements Serializable{

	
	
	private static final long serialVersionUID = -5578284222887505035L;
	
	private double loanAmount;	
	private double nominalRate;
	private int duration;
	private String startDate;
	private BigDecimal borrowerPaymentAmount;
	private String date;
	private BigDecimal initialOutstandingPrincipal;
	private BigDecimal interest;
	private BigDecimal principal;
	private BigDecimal remainingOutstandingPrincipal;
	/**
	 * @return the loanAmount
	 */
	public double getLoanAmount() {
		return loanAmount;
	}
	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	/**
	 * @return the nominalRate
	 */
	public double getNominalRate() {
		return nominalRate;
	}
	/**
	 * @param nominalRate the nominalRate to set
	 */
	public void setNominalRate(double nominalRate) {
		this.nominalRate = nominalRate;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the borrowerPaymentAmount
	 */
	public BigDecimal getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}
	/**
	 * @param borrowerPaymentAmount the borrowerPaymentAmount to set
	 */
	public void setBorrowerPaymentAmount(BigDecimal borrowerPaymentAmount) {
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
	public BigDecimal getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}
	/**
	 * @param initialOutstandingPrincipal the initialOutstandingPrincipal to set
	 */
	public void setInitialOutstandingPrincipal(BigDecimal initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}
	/**
	 * @return the interest
	 */
	public BigDecimal getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}
	/**
	 * @return the principal
	 */
	public BigDecimal getPrincipal() {
		return principal;
	}
	/**
	 * @param principal the principal to set
	 */
	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}
	/**
	 * @return the remainingOutstandingPrincipal
	 */
	public BigDecimal getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}
	/**
	 * @param remainingOutstandingPrincipal the remainingOutstandingPrincipal to set
	 */
	public void setRemainingOutstandingPrincipal(BigDecimal remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}
	

	
}
