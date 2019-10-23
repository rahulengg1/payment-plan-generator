package com.rahul.app.api.shared;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.rahul.app.api.model.response.PlanResponseModel;

public class PaymentGeneratorUtils {

	

	public List<PlanResponseModel> PaymentPerMonth(PlanGeneratorDto dto) { 
		
		ModelMapper modelMapper = new ModelMapper();
		List<PlanResponseModel> responseList = new ArrayList<PlanResponseModel>();
		int counter = 0;
		
		while(counter<dto.getDuration())
		{
			if(counter == 0)
			{
				dto.setBorrowerPaymentAmount(roundOffDoubleValue(calculateBorrowerPaymentAmount(dto)));
				dto.setDate(generatePaymentDate(dto.getStartDate(), counter));
				dto.setInitialOutstandingPrincipal(BigDecimal.valueOf(dto.getLoanAmount()));
				dto.setInterest(roundOffBigDecimalValue(calculateInterest(BigDecimal.valueOf(dto.getNominalRate()),dto.getInitialOutstandingPrincipal())));
				dto.setPrincipal(roundOffBigDecimalValue(calculatePrincipal(dto.getBorrowerPaymentAmount(),dto.getInterest(), dto.getInitialOutstandingPrincipal())));
				dto.setRemainingOutstandingPrincipal( roundOffBigDecimalValue(dto.getInitialOutstandingPrincipal().subtract(dto.getPrincipal())));
				
			}else
			{
				dto.setInitialOutstandingPrincipal(roundOffBigDecimalValue(dto.getRemainingOutstandingPrincipal()));
				dto.setDate(generatePaymentDate(dto.getStartDate(), counter));
				dto.setInterest(roundOffBigDecimalValue(calculateInterest(BigDecimal.valueOf(dto.getNominalRate()),dto.getInitialOutstandingPrincipal())));
				dto.setPrincipal(roundOffBigDecimalValue(calculatePrincipal(dto.getBorrowerPaymentAmount(),dto.getInterest(), dto.getInitialOutstandingPrincipal())));
				dto.setBorrowerPaymentAmount(roundOffBigDecimalValue(dto.getPrincipal().add(dto.getInterest())));
				dto.setRemainingOutstandingPrincipal( roundOffBigDecimalValue(dto.getInitialOutstandingPrincipal().subtract(dto.getPrincipal())));
				
			}
			
			PlanResponseModel planResponseModel = modelMapper.map(dto, PlanResponseModel.class);
			responseList.add(planResponseModel);
			
			counter++;
		}
			
		 return responseList;
		}

	
	private BigDecimal roundOffDoubleValue(final double doubleValue) {
		final BigDecimal bigDecimalValue = BigDecimal.valueOf(doubleValue);
		return bigDecimalValue.setScale(AppConstants.DECIMALS, BigDecimal.ROUND_HALF_UP);
	}

	private BigDecimal roundOffBigDecimalValue(final BigDecimal value) {
		return value.setScale(AppConstants.DECIMALS, BigDecimal.ROUND_HALF_UP);
	}

	private double calculateBorrowerPaymentAmount(final PlanGeneratorDto dto) {
		return borrowerPaymentAmountNumerator(dto) / borrowerPaymentAmountDenominator(dto);
	}

	/*
	 *  Get value of Numerator according to formula PresentValue * Rate per period
	 */
	private double borrowerPaymentAmountNumerator(final PlanGeneratorDto dto) {
		return dto.getLoanAmount() * interestRateOverPaymentsPerYear(dto.getNominalRate());
	}

	/*
	 *  Get value of Denominator value according to formula 1 - (1 + Rate per period) power negative duration
	 */
	private double borrowerPaymentAmountDenominator(final PlanGeneratorDto dto) {
		final double base = 1 + interestRateOverPaymentsPerYear(dto.getNominalRate());
		final double subtrahend = Math.pow(base, -dto.getDuration());
		return (1 - subtrahend);
	}

	private double interestRateOverPaymentsPerYear(final double nominalRate) {
		return ((nominalRate / 100) / AppConstants.PAYMENTS_PER_YEAR);
	}

	private String generatePaymentDate(final String startDateTime, final int counter) {
		final LocalDate startDate = convertStringToLocalDate(startDateTime);
		final LocalDate paymentDate = startDate.plusMonths(counter);
		return convertLocalDateToString(paymentDate);
	}

	private LocalDate convertStringToLocalDate(final String dateTimeAsString) {
		final Instant instant = Instant.parse(dateTimeAsString);
		final LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
		return localDateTime.toLocalDate();
	}

	private String convertLocalDateToString(final LocalDate localDate) {
		final ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.of(localDate, LocalTime.MIDNIGHT),
				ZoneId.of("UTC"));
		return zonedDateTime.format(DateTimeFormatter.ISO_INSTANT);
	}

	private BigDecimal calculateInterest(final BigDecimal nominalRate, final BigDecimal initialOutstandingPrincipal) {
		final BigDecimal interestInCents = (nominalRate.multiply(AppConstants.DAYS_PER_MONTH)
				.multiply(initialOutstandingPrincipal)).divide(AppConstants.DAYS_PER_YEAR, BigDecimal.ROUND_HALF_UP);
		return interestInCents.movePointLeft(AppConstants.DECIMALS);
	}

	private BigDecimal calculatePrincipal(final BigDecimal annuity, final BigDecimal interest, final BigDecimal initialOutstandingPrincipal) {
		final BigDecimal principal = annuity.subtract(interest);
		if (principal.compareTo(initialOutstandingPrincipal) > 0) {
			return initialOutstandingPrincipal;
		} else {
			return principal;
		}
	}

	

}
