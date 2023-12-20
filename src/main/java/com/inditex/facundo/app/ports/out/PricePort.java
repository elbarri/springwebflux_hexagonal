package com.inditex.facundo.app.ports.out;

import com.inditex.facundo.domain.model.PriceRecord;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface PricePort {
  /**
   *
   * @param productId
   * @param brandId
   * @param date
   * @return prices within the validity of the provided date
   */
  Flux<PriceRecord> getPrices(Integer productId, Integer brandId, LocalDateTime date);
}
