package com.inditex.facundo.infra.out;

import com.inditex.facundo.app.ports.out.PricePort;
import com.inditex.facundo.domain.model.PriceRecord;
import com.inditex.facundo.infra.out.repository.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Service
public class PricePersistenceAdapter implements PricePort {
  @Autowired
  private PriceRepo priceRepo;

  @Override
  public Flux<PriceRecord> getPrices(Integer productId, Integer brandId, LocalDateTime date) {
    return priceRepo.findByProductIdAndBrandIdForDate(productId, brandId, date);
  }
}
