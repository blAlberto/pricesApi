package com.pricesApi.response;

import com.pricesApi.entity.Price;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
public class PriceResponse {

    private Long productId;

    private Long brandId;

    private Long priceList;

    private Date startDate;

    private Date endDate;

    private Double price;

    private String curr;

    public PriceResponse (Price price) {
        BeanUtils.copyProperties(price, this);
    }
}
