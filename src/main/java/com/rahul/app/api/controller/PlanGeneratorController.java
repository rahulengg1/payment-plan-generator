package com.rahul.app.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.app.api.model.request.PlanRequestModel;
import com.rahul.app.api.model.response.PlanResponseModel;
import com.rahul.app.api.services.PlanGeneratorService;

/**
 * @author Rahul
 *
 */

@RestController
@RequestMapping(value = "generate-plan")
public class PlanGeneratorController {
	
	
	
	private PlanGeneratorService planGeneratorService;
	
	public PlanGeneratorController(PlanGeneratorService planGeneratorService)
	{
		this.planGeneratorService = planGeneratorService;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE
	             ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PlanResponseModel>> generatePaymentPlan(@Valid @RequestBody PlanRequestModel planRequestModel)
	{
		
		List<PlanResponseModel> responseList = planGeneratorService.generatePaymentPlan(planRequestModel);
	
		return ResponseEntity.status(HttpStatus.OK).body(responseList);
	}

}
