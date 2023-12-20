package com.inditex.facundo.app.ports.in;

import com.inditex.facundo.domain.model.PriceRecord;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceUseCase {
  /**
   *
   * @param date
   * @param productId
   * @param brandId
   * @return price response for the given args
   */
  Optional<PriceRecord> getPriceFor(LocalDateTime date, Integer productId, Integer brandId);
}
