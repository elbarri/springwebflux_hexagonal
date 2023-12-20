package com.inditex.facundo.infra.in.rest.records;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceResponse(
  Integer brandId,
  Integer productId,
  Integer priceList,
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime endDate,
  BigDecimal price
) {}
