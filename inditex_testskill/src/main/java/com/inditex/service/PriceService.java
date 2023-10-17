package com.inditex.service;

import com.inditex.dto.PriceDTO;
import com.inditex.mapper.EntityDtoMapper;
import com.inditex.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceService {

    private final PriceRepository priceRepository;
    private final EntityDtoMapper mapper;

    public PriceService(PriceRepository priceRepository, EntityDtoMapper mapper) {
        this.priceRepository = priceRepository;
        this.mapper = mapper;
    }

    public PriceDTO findPriceByProductIdBrandIdAndDate(Long productId, Long brandId, LocalDateTime date) {
        return mapper.toDto(
                priceRepository.findPriceByDateProductIdAndBrand(productId, brandId, date).orElse(null)
        );
    }
}
