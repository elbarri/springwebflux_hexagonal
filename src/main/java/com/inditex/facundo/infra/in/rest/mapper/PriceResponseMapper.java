package com.inditex.facundo.infra.in.rest.mapper;

import com.inditex.facundo.domain.model.PriceRecord;
import com.inditex.facundo.infra.in.rest.records.PriceResponse;
import org.mapstruct.Mapper;

@Mapper
public interface PriceResponseMapper {
  PriceResponse toPriceResponse(PriceRecord priceRecord);
}
