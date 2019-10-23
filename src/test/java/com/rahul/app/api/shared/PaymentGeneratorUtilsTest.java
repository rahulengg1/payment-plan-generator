package com.rahul.app.api.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.rahul.app.api.model.response.PlanResponseModel;

@SpringBootTest
class PaymentGeneratorUtilsTest {

	
	private PlanGeneratorDto dto; 
	
	

	@BeforeEach
	void setUp() throws Exception {
		dto = new PlanGeneratorDto();
		dto.setLoanAmount(5000);
		dto.setStartDate("2018-01-01T00:00:01Z");
		dto.setNominalRate(5);
		dto.setDuration(24);
		
	}

	@Test
	void testPaymentPerMonth() {
		PaymentGeneratorUtils utils = new PaymentGeneratorUtils();
		List<PlanResponseModel> responseList=utils.PaymentPerMonth(dto);
		
		assertEquals(responseList.size(), 24);
		
		assertEquals(responseList.get(0).getRemainingOutstandingPrincipal(), 4801.47);
		assertEquals(responseList.get(0).getInitialOutstandingPrincipal(), 5000.00);
		assertEquals(responseList.get(0).getDate(), "2018-01-01T00:00:00Z");
		assertEquals(responseList.get(0).getInterest(), 20.83);
		assertEquals(responseList.get(0).getPrincipal(), 198.53);
		assertEquals(responseList.get(0).getBorrowerPaymentAmount(), 219.36);
		assertEquals(responseList.get(1).getRemainingOutstandingPrincipal(), 4602.12);
		assertEquals(responseList.get(1).getInitialOutstandingPrincipal(), 4801.47);
		assertEquals(responseList.get(1).getDate(), "2018-02-01T00:00:00Z");
		assertEquals(responseList.get(1).getInterest(), 20.01);
		assertEquals(responseList.get(1).getPrincipal(), 199.35);
		assertEquals(responseList.get(1).getBorrowerPaymentAmount(), 219.36);
		assertEquals(responseList.get(23).getRemainingOutstandingPrincipal(), 0);
		assertEquals(responseList.get(23).getInitialOutstandingPrincipal(), 218.37);
		assertEquals(responseList.get(23).getDate(), "2019-12-01T00:00:00Z");
		assertEquals(responseList.get(23).getInterest(), 0.91);
		assertEquals(responseList.get(23).getPrincipal(), 218.37);
		assertEquals(responseList.get(23).getBorrowerPaymentAmount(), 219.28);
		assertEquals(responseList.get(23).getRemainingOutstandingPrincipal(), 0);
		
	
	}

}
