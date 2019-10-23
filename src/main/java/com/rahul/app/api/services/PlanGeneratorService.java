package com.rahul.app.api.services;

import java.util.List;

import com.rahul.app.api.model.request.PlanRequestModel;
import com.rahul.app.api.model.response.PlanResponseModel;

/**
 * @author Rahul
 *
 */
public interface PlanGeneratorService {

	List<PlanResponseModel> generatePaymentPlan(PlanRequestModel planRequestModel);
	
}
