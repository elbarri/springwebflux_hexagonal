# INDITEX CHALLENGE 👨🏻‍💻

## Summary

This is a SpringWebflux app that provides prices through a REST interface.

It stands behind hexagonal architecture principles and it uses newly added features such as Record.

Layers are clearly defined, making the code open for extension.

## Tests

Unit: `./mvnw clean test`

Unit + Integration: `/mvnw clean verify`

## Run Instructions

`./mvnw spring-boot:run`

Open your browser and navigate to http://localhost:8089/api/v1/prices?date=2020-06-16%2017:00:00&productId=35455&brandId=1

You should get this as response:
`{"brandId":1,"productId":35455,"priceList":4,"startDate":"2020-06-15 16:00:00","endDate":"2020-12-31 23:59:59","price":38.95}`
