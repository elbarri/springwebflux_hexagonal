package com.inditex.facundo.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceRecord(
  Long id,
  Integer brandId,
  LocalDateTime startDate,
  LocalDateTime endDate,
  Integer priceList,
  Integer productId,
  Integer priority,
  BigDecimal price,
  String currency
) {}
