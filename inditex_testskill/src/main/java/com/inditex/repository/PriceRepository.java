package com.inditex.repository;

import com.inditex.model.Price;
import com.inditex.model.PricePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, PricePK> {

    @Query( nativeQuery = true,
            value = "SELECT TOP 1 p.* FROM PRICES p " +
                    "WHERE p.PRODUCT_ID = :productId " +
                    "AND p.BRAND_ID = :brandId " +
                    "AND :date BETWEEN p.START_DATE AND p.END_DATE " +
                    "ORDER BY p.PRIORITY DESC")
    Optional<Price> findPriceByDateProductIdAndBrand(@Param("productId") Long productId,
                                                     @Param("brandId") Long brandId,
                                                     @Param("date") LocalDateTime date);
}
