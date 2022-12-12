package com.pricesApi.controller;

import com.pricesApi.response.PriceResponse;
import com.pricesApi.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController()
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    // Swagger non permite pasar un requestBody nunha chamada de tipo get, polo que se recibiran parametros
    @GetMapping(value = "/productPriceByDate")
    @Operation(summary = "Get the price of a certain product by date")
    public ResponseEntity<PriceResponse> getproductPriceByDate(
            @RequestParam("productId") @Parameter(example = "35455") Long productId,
            @RequestParam("brandId") @Parameter(example = "1") Long brandId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Parameter(example = "2020-12-30T20:20:20Z") LocalDateTime date
    ) {
        PriceResponse result = priceService.getProductPriceByDate(productId, brandId, date);

        return ResponseEntity.ok(result);
    }
}
