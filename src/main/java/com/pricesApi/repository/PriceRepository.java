package com.pricesApi.repository;

import com.pricesApi.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    //List<Price> findAllByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(Long productId, Long brandId, Date date, Date sameDate);

    @Query("SELECT p FROM Price p where p.productId = :productId and p.brandId = :brandId and :date between p.startDate and p.endDate")
    List<Price> findAllByProductIdBrandIdAndDate(Long productId, Long brandId, Date date);
}
