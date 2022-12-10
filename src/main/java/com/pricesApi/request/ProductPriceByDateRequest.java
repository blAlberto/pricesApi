package com.pricesApi.request;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductPriceByDateRequest {

    @Parameter
    private Long productId;

    @Parameter
    private Long brandId;

    @Parameter
    //@JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss", timezone = "Europe/Madrid")
    private Date date;
}
