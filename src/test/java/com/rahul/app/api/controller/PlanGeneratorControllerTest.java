package com.rahul.app.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.app.api.model.request.PlanRequestModel;
import com.rahul.app.api.services.impl.PlanGeneratorServiceImpl;

@AutoConfigureMockMvc
@ContextConfiguration(classes = { PlanGeneratorController.class, PlanGeneratorServiceImpl.class })
@WebMvcTest
class PlanGeneratorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static final String API_ENDPOINT = "/generate-plan";

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	
	}

	@Test
	void whenValidInput_thenReturns200() throws Exception {
		PlanRequestModel model = new PlanRequestModel();
		model.setDuration(24);
		model.setLoanAmount(5000);
		model.setNominalRate(5);
		model.setStartDate("2018-01-01T00:00:00Z");

		mockMvc.perform(post(API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isOk());
	}

	@Test
	void whenInvalidLoanAmount_thenReturns200() throws Exception {
		PlanRequestModel model = new PlanRequestModel();
		model.setDuration(24);
		model.setNominalRate(5);
		model.setStartDate("2018-01-01T00:00:00Z");

		mockMvc.perform(post(API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isBadRequest());
	}

	@Test
	void whenInvalidDuration_thenReturns400() throws Exception {
		PlanRequestModel model = new PlanRequestModel();
		model.setLoanAmount(5000);
		model.setNominalRate(5);
		model.setStartDate("2018-01-01T00:00:00Z");

		mockMvc.perform(post(API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isBadRequest());
	}

	@Test
	void whenInvalidNominalRate_thenReturns400() throws Exception {
		PlanRequestModel model = new PlanRequestModel();
		model.setDuration(24);
		model.setLoanAmount(5000);
		model.setStartDate("2018-01-01T00:00:00Z");

		mockMvc.perform(post(API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isBadRequest());
	}

	@Test
	void whenInvalidStartDate_thenReturns400() throws Exception {
		PlanRequestModel model = new PlanRequestModel();
		model.setDuration(24);
		model.setLoanAmount(5000);
		model.setNominalRate(5);

		mockMvc.perform(post(API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isBadRequest());
	}

	@Test
	void testPlanGeneratorData_isOk() throws Exception {
		PlanRequestModel model= new PlanRequestModel();
		model.setDuration(24);
		model.setLoanAmount(5000);
		model.setNominalRate(5);
		model.setStartDate("2018-01-01T00:00:00Z");
		
		mockMvc.perform(post(API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
	    .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(objectMapper.writeValueAsString(model)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].borrowerPaymentAmount").value(219.36))
        .andExpect(jsonPath("$[0].date").value("2018-01-01T00:00:00Z"))
        .andExpect(jsonPath("$[0].initialOutstandingPrincipal").value(5000))
        .andExpect(jsonPath("$[0].interest").value(20.83))
        .andExpect(jsonPath("$[0].principal").value(198.53))
        .andExpect(jsonPath("$[0].remainingOutstandingPrincipal").value(4801.47))
        .andExpect(jsonPath("$[1].borrowerPaymentAmount").value(219.36))
        .andExpect(jsonPath("$[1].date").value("2018-02-01T00:00:00Z"))
        .andExpect(jsonPath("$[1].initialOutstandingPrincipal").value(4801.47))
        .andExpect(jsonPath("$[1].interest").value(20.01))
        .andExpect(jsonPath("$[1].principal").value(199.35))
        .andExpect(jsonPath("$[1].remainingOutstandingPrincipal").value(4602.12))
        .andExpect(jsonPath("$[23].borrowerPaymentAmount").value(219.28))
        .andExpect(jsonPath("$[23].date").value("2019-12-01T00:00:00Z"))
        .andExpect(jsonPath("$[23].initialOutstandingPrincipal").value(218.37))
        .andExpect(jsonPath("$[23].interest").value(0.91))
        .andExpect(jsonPath("$[23].principal").value(218.37))
        .andExpect(jsonPath("$[23].remainingOutstandingPrincipal").value(0))
        .andExpect(jsonPath("$[24].borrowerPaymentAmount").doesNotExist())
        .andExpect(jsonPath("$[24].date").doesNotExist())
        .andExpect(jsonPath("$[24].initialOutstandingPrincipal").doesNotExist())
        .andExpect(jsonPath("$[24].interest").doesNotExist())
        .andExpect(jsonPath("$[24].principal").doesNotExist())
        .andExpect(jsonPath("$[24].remainingOutstandingPrincipal").doesNotExist()).andReturn();
	}

}
