package com.inditex.facundo.out;

import com.inditex.facundo.domain.model.PriceRecord;
import com.inditex.facundo.infra.out.entity.PriceEntity;
import com.inditex.facundo.infra.out.repository.PriceRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataR2dbcTest
@ExtendWith(SpringExtension.class)
class PersistenceTests {

	@Autowired
	private PriceRepo priceRepo;
	private final PriceEntity pe1 = new PriceEntity();
	private final PriceEntity pe2 = new PriceEntity();

	@BeforeEach
	void setUp() {
		pe1.setBrandId(1);
		pe1.setProductId(11);
		pe1.setPrice(BigDecimal.valueOf(12.33));
		pe1.setStartDate(LocalDateTime.now().minusDays(1));
		pe1.setEndDate(LocalDateTime.now().plusDays(1));
		pe1.setPriority(1);
		priceRepo.save(pe1).block();

		pe2.setBrandId(1);
		pe2.setProductId(11);
		pe2.setPrice(BigDecimal.valueOf(15.33));
		pe2.setStartDate(LocalDateTime.now().minusDays(1));
		pe2.setEndDate(LocalDateTime.now().plusDays(1));
		pe2.setPriority(2);
		priceRepo.save(pe2).block();

		PriceEntity pe3 = new PriceEntity();
		pe3.setBrandId(1);
		pe3.setProductId(11);
		pe3.setStartDate(LocalDateTime.now().minusDays(1));
		pe3.setEndDate(LocalDateTime.now().minusHours(1));
		pe3.setPriority(18);
		priceRepo.save(pe3).block();
	}

	@Test
	void findPricesByProductIdAndBrandIdWithinGivenDate() {
		List<PriceRecord> records = priceRepo.findByProductIdAndBrandIdForDate(11, 1, LocalDateTime.now())
						.collectSortedList(Comparator.comparing(PriceRecord::priority))
						.block();

		assertEquals(2, records.size());
		assertEquals(pe1.getProductId(), records.get(0).productId());
		assertEquals(pe1.getPriority(), records.get(0).priority());
		assertEquals(pe1.getPrice(), records.get(0).price());

		assertEquals(pe2.getProductId(), records.get(1).productId());
		assertEquals(pe2.getPriority(), records.get(1).priority());
		assertEquals(pe2.getPrice(), records.get(1).price());
	}
}
