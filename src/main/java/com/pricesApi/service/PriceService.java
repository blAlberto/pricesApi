package com.pricesApi.service;

import com.pricesApi.entity.Price;
import com.pricesApi.repository.PriceRepository;
import com.pricesApi.response.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepository;

    public PriceResponse getProductPriceByDate(Long productId, Long brandId, LocalDateTime date) {

        if (productId == null || brandId == null || date == null) {
            throw new IllegalArgumentException("Ningún campo de la petición puede ser nulo");
        }
        Price price = priceRepository.findAllByProductIdBrandIdAndDate(productId, brandId, date);
        return price != null ? new PriceResponse(price) : null;
    }

}
