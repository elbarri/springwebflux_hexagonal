package com.inditex.facundo.infra.out.repository;

import com.inditex.facundo.domain.model.PriceRecord;
import com.inditex.facundo.infra.out.entity.PriceEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface PriceRepo extends R2dbcRepository<PriceEntity, Long> {
  /**
   * @param productId
   * @param brandId
   * @param date
   * @return matching results where provided date is between start and end date
   */
  @Query("SELECT * FROM prices " +
          "WHERE product_id = :productId AND brand_id = :brandId AND start_date <= :date AND end_date >= :date")
  Flux<PriceRecord> findByProductIdAndBrandIdForDate(Integer productId, Integer brandId, LocalDateTime date);
}
