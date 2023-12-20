package com.inditex.facundo.domain.service;

import com.inditex.facundo.app.ports.in.PriceUseCase;
import com.inditex.facundo.app.ports.out.PricePort;
import com.inditex.facundo.domain.model.PriceRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PriceService implements PriceUseCase {

  @Autowired
  private PricePort pricePort;

  @Override
  public Optional<PriceRecord> getPriceFor(LocalDateTime date, Integer productId, Integer brandId) {
    return pricePort.getPrices(productId, brandId, date)
            .collect(Collectors.maxBy(Comparator.comparing(PriceRecord::priority)))
            .block()
            .stream()
            .findFirst();
  }
}
