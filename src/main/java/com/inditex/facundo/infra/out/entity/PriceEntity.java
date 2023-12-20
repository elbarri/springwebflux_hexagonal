package com.inditex.facundo.infra.out.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table("PRICES")
public class PriceEntity {
  @Id
  private Long id;

  @Column(value = "BRAND_ID")

  private Integer brandId;

  @Column(value = "START_DATE")
  private LocalDateTime startDate;

  @Column(value = "END_DATE")
  private LocalDateTime endDate;

  @Column(value = "PRICE_LIST")
  private Integer priceList;

  @Column(value = "PRODUCT_ID")
  private Integer productId;

  @Column(value = "PRIORITY")
  private Integer priority;

  @Column(value = "PRICE")
  private BigDecimal price;

  @Column(value = "CURR")
  private String currency;
}
