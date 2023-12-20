package com.inditex.facundo.infra.in.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricesRestIT {

  @Autowired
  private WebTestClient webClient;

  @Test
  public void shouldGetPricesValidForGivenDateRange() {
    runTest("2020-06-14 10:00:00", 35.50, 1);
    runTest("2020-06-14 16:00:00", 25.45, 2);
    runTest("2020-06-14 21:00:00", 35.50, 1);
    runTest("2020-06-15 10:00:00", 30.50, 3);
    runTest("2020-06-16 21:00:00", 38.95, 4);
  }

  public void runTest(String date, double expectedPrice, int expectedPricelist) {
    int productId = 35455;
    int brandId = 1;

    webClient.get()
        .uri(uriBuilder -> uriBuilder
                .path("/api/v1/prices")
                .queryParam("productId", productId)
                .queryParam("brandId", brandId)
                .queryParam("date", date)
                .build())
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("productId").isEqualTo(productId)
        .jsonPath("brandId").isEqualTo(brandId)
        .jsonPath("price").isEqualTo(expectedPrice)
        .jsonPath("priceList").isEqualTo(expectedPricelist);
  }
}
