package com.inditex.controller;

import com.inditex.dto.PriceDTO;
import com.inditex.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/price")
public class PriceController {

    public final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(params = {"productId", "brandId", "applicationDate"})
    public ResponseEntity getPrice(@RequestParam("productId") Long productId,
                             @RequestParam("brandId") Long brandId,
                             @RequestParam("applicationDate") LocalDateTime applicationDate) {
        PriceDTO result = priceService.findPriceByProductIdBrandIdAndDate(productId, brandId, applicationDate);
        if (result == null) {
            return new ResponseEntity<>(
                    "Error to find price by: " + productId + ", " + brandId + ", " + applicationDate,
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
