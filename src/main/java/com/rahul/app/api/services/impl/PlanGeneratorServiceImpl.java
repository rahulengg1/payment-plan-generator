package com.rahul.app.api.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.rahul.app.api.model.request.PlanRequestModel;
import com.rahul.app.api.model.response.PlanResponseModel;
import com.rahul.app.api.services.PlanGeneratorService;
import com.rahul.app.api.shared.PaymentGeneratorUtils;
import com.rahul.app.api.shared.PlanGeneratorDto;

/**
 * @author Rahul
 *
 */

@Service
public class PlanGeneratorServiceImpl implements PlanGeneratorService {

	@Override
	public List<PlanResponseModel> generatePaymentPlan(PlanRequestModel planRequestModel) {
		
		
		ModelMapper modelMapper = new ModelMapper();
		PlanGeneratorDto planGeneratorDto=modelMapper.map(planRequestModel, PlanGeneratorDto.class);
		PaymentGeneratorUtils paymentGeneratorUtils  = new PaymentGeneratorUtils(); 
		
		return paymentGeneratorUtils.PaymentPerMonth(planGeneratorDto);
	}

	
	
	
	
	
}
