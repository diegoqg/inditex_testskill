package com.inditex.controller;

import com.inditex.dto.PriceDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static Stream<Arguments> priceFilterValues() {
        return Stream.of(
                Arguments.of(
                        35455L,
                        1L,
                        LocalDateTime.of(2020, 6, 14, 10, 0 ,0),
                        new BigDecimal("35.50")
                ),
                Arguments.of(
                        35455L,
                        1L,
                        LocalDateTime.of(2020, 6, 14, 16, 0 ,0),
                        new BigDecimal("25.45")
                ),
                Arguments.of(
                        35455L,
                        1L,
                        LocalDateTime.of(2020, 6, 14, 21, 0 ,0),
                        new BigDecimal("35.50")
                ),
                Arguments.of(
                        35455L,
                        1L,
                        LocalDateTime.of(2020, 6, 15, 10, 0 ,0),
                        new BigDecimal("30.50")
                ),
                Arguments.of(
                        35455L,
                        1L,
                        LocalDateTime.of(2020, 6, 16, 21, 0 ,0),
                        new BigDecimal("38.95")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("priceFilterValues")
    void testPriceEndpointOkResults(Long productId, Long brandId, LocalDateTime dateTime, BigDecimal expectResult) throws Exception {
        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId))
                .param("applicationDate", String.valueOf(dateTime))
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        PriceDTO priceResult = objectMapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class);

        assertEquals(expectResult, priceResult.getPrice());
    }

    @Test
    void testPriceEndpointNotFoundResult() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .param("productId", String.valueOf(33333))
                .param("brandId", String.valueOf(2))
                .param("applicationDate", String.valueOf(LocalDateTime.now()))
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
