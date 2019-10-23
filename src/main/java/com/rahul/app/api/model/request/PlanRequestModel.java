package com.rahul.app.api.model.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Rahul
 *
 */

public class PlanRequestModel {
	
	@DecimalMin(value = "1.0", message="Loan amount must be greater than 0")
	private double loanAmount;	
	
	@DecimalMin(value = "1.0", message="Nominal Rate must be greater than 0")
	private double nominalRate;
	
	@Min(value = 1, message="Duration must be greater than 0")
	private int duration;
	
	@NotNull(message ="Start Date cannot be null")
	@NotEmpty(message ="Start Date cannot be blank")
	private String startDate;

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
	
	
}
