package com.pricesApi.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductPriceByDateRequest {

    private Long productId;

    private Long brandId;

    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", timezone = "Europe/Madrid")
    private Date date;
}
