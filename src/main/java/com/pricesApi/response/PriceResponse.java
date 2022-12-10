package com.pricesApi.response;

import com.pricesApi.entity.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PriceResponse {

    private long id;

    private Long productId;

    private Long brandId;

    private Long priceList;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double price;

    private String curr;

    public PriceResponse (Price price) {
        BeanUtils.copyProperties(price, this);
    }
}
