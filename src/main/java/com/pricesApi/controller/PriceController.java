package com.pricesApi.controller;

import com.pricesApi.request.ProductPriceByDateRequest;
import com.pricesApi.response.PriceResponse;
import com.pricesApi.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/productPriceByDate")
    public ResponseEntity<List<PriceResponse>> getProductPriceByDate(@RequestBody ProductPriceByDateRequest request) {
        List<PriceResponse> result = priceService.getProductPriceByDate(request);

        return ResponseEntity.ok(result);
    }

}
