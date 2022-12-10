package com.pricesApi.repository;

import com.pricesApi.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface PriceRepository extends JpaRepository<Price, Long> {

    //List<Price> findAllByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriority(Long productId, Long brandId, Date date, Date sameDate);

//    @Query("SELECT p " +
//            "FROM Price p " +
//            "WHERE p.productId = :productId and p.brandId = :brandId and :date between p.startDate and p.endDate " +
//            "ORDER BY p.priority DESC")
    @Query(value = "SELECT p.* " +
            "FROM PRICE p " +
            "WHERE p.product_id = :productId AND p.brand_Id = :brandId AND :date BETWEEN p.start_Date AND p.end_Date " +
            "ORDER BY p.priority DESC " +
            "LIMIT 1", nativeQuery = true)

    Price findAllByProductIdBrandIdAndDate(Long productId, Long brandId, LocalDateTime date);
}
