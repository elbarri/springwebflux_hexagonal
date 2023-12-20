package com.inditex.facundo.infra.in.rest;

import com.inditex.facundo.app.ports.in.PriceUseCase;
import com.inditex.facundo.domain.model.PriceRecord;
import com.inditex.facundo.infra.in.rest.mapper.PriceResponseMapper;
import com.inditex.facundo.infra.in.rest.records.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/prices")
public class PricesRestController {

  @Autowired
  private PriceUseCase priceUseCase;
  @Autowired
  private PriceResponseMapper mapper;

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @GetMapping
  public Mono<ResponseEntity<PriceResponse>> getPrice(String date, Integer productId, Integer brandId) {
    Optional<PriceRecord> price = priceUseCase.getPriceFor(LocalDateTime.parse(date, formatter), productId, brandId);
    Optional<PriceResponse> priceResponse = price.map(mapper::toPriceResponse);
    return Mono.just(ResponseEntity.of(priceResponse));
  }
}
