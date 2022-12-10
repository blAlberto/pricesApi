package com.pricesApi.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRICE")
public class Price {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long brandId;

    @Column(columnDefinition = "TIMESTAMP")
    private Date startDate;

    @Column(columnDefinition = "TIMESTAMP")
    private Date endDate;

    private Long priceList;

    private Long productId;

    @Column(columnDefinition = "NUMERIC(2)")
    private Long priority;

    private Double price;

    @Column(columnDefinition = "VARCHAR(3)")
    private String curr;

}
