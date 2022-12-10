package com.pricesApi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICE")
@Getter
@Setter
public class Price {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long brandId;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;

    private Long priceList;

    private Long productId;

    @Column(columnDefinition = "NUMERIC(2)")
    private Long priority;

    private Double price;

    @Column(columnDefinition = "VARCHAR(3)")
    private String curr;

}
