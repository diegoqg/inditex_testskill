package com.inditex.mapper;

import com.inditex.dto.PriceDTO;
import com.inditex.model.Brand;
import com.inditex.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Mapper(componentModel = "spring")
public interface EntityDtoMapper {

    @Mapping(target = "productId", source = "id.productId")
    @Mapping(target = "priority", source = "id.priority")
    @Mapping(target = "priceList", source = "id.priceList")
    @Mapping(target = "brand", source = "id.brand", qualifiedByName = "transformBrandToText")
    @Mapping(target = "price", source = "price", qualifiedByName = "setFormatPrice")
    PriceDTO toDto(Price price);

    @Named("transformBrandToText")
    static String transformBrandToText(Brand brand) {
        return brand.getId() + "-" + brand.getName();
    }
    @Named("setFormatPrice")
    static BigDecimal setFormatPrice(BigDecimal price) {
        return price.setScale(2, RoundingMode.HALF_UP);
    }
}
