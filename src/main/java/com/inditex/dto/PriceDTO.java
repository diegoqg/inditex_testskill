package com.inditex.dto;

import com.inditex.constants.Currency;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class PriceDTO {
    private Long priceList;
    private Long productId;
    private Long priority;
    private String brand; // FORMAT 1-ZARA

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private Currency curr;
}
