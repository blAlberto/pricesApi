package com.pricesApi.service;

import com.pricesApi.entity.Price;
import com.pricesApi.repository.PriceRepository;
import com.pricesApi.request.ProductPriceByDateRequest;
import com.pricesApi.response.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepository;

    public List<PriceResponse> getProductPriceByDate(ProductPriceByDateRequest request) {

        validateProductPriceByDateRequest(request);

        List<Price> prices = priceRepository.findAllByProductIdBrandIdAndDate(request.getProductId(), request.getBrandId(), request.getDate());

        return prices.stream().map(PriceResponse::new).collect(Collectors.toList());
    }

    private void validateProductPriceByDateRequest(ProductPriceByDateRequest request) {
        if (request.getProductId() == null || request.getBrandId() == null || request.getDate() == null) {
            throw new IllegalArgumentException("Ningún campo de la petición puede ser nulo");
        }
    }
}
