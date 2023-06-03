package com.pcshop.demo.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EntityRequest {

    private Long id;
    private String series;
    private String manufacturer;
    private BigDecimal price;
    private Integer quantity;
    private Integer volume;
    private String form;
    private Double size;
    private Double diagonal;
    private String type;
}