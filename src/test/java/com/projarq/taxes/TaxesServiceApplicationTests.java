package com.projarq.taxes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.projarq.taxes.domain.Tax;
import com.projarq.taxes.domain.TaxRepository;

@SpringBootTest
@ActiveProfiles("test")
class TaxesServiceApplicationTests {

	@Autowired
	private TaxRepository taxRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testTaxRepository() {
		// Test that we can save and retrieve a tax
		Tax tax = new Tax("TEST", 0.15);
		taxRepository.save(tax);
		
		Tax found = taxRepository.findByState("TEST");
		assertNotNull(found);
		assertEquals("TEST", found.getState());
		assertEquals(0.15, found.getRate(), 0.001);
	}
} 