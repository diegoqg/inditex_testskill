package com.inditex.mapper;

import com.inditex.dto.PriceDTO;
import com.inditex.model.Brand;
import com.inditex.model.Price;
import com.inditex.model.PricePK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-15T11:59:55+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class EntityDtoMapperImpl implements EntityDtoMapper {

    @Override
    public PriceDTO toDto(Price price) {
        if ( price == null ) {
            return null;
        }

        PriceDTO priceDTO = new PriceDTO();

        priceDTO.setProductId( priceIdProductId( price ) );
        priceDTO.setPriority( priceIdPriority( price ) );
        priceDTO.setPriceList( priceIdPriceList( price ) );
        priceDTO.setBrand( EntityDtoMapper.transformBrandToText( priceIdBrand( price ) ) );
        priceDTO.setPrice( EntityDtoMapper.setFormatPrice( price.getPrice() ) );
        priceDTO.setStartDate( price.getStartDate() );
        priceDTO.setEndDate( price.getEndDate() );
        priceDTO.setCurr( price.getCurr() );

        return priceDTO;
    }

    private Long priceIdProductId(Price price) {
        if ( price == null ) {
            return null;
        }
        PricePK id = price.getId();
        if ( id == null ) {
            return null;
        }
        Long productId = id.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    private Long priceIdPriority(Price price) {
        if ( price == null ) {
            return null;
        }
        PricePK id = price.getId();
        if ( id == null ) {
            return null;
        }
        Long priority = id.getPriority();
        if ( priority == null ) {
            return null;
        }
        return priority;
    }

    private Long priceIdPriceList(Price price) {
        if ( price == null ) {
            return null;
        }
        PricePK id = price.getId();
        if ( id == null ) {
            return null;
        }
        Long priceList = id.getPriceList();
        if ( priceList == null ) {
            return null;
        }
        return priceList;
    }

    private Brand priceIdBrand(Price price) {
        if ( price == null ) {
            return null;
        }
        PricePK id = price.getId();
        if ( id == null ) {
            return null;
        }
        Brand brand = id.getBrand();
        if ( brand == null ) {
            return null;
        }
        return brand;
    }
}
