package com.pcshop.demo.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
@Getter
@Setter
public class DefaultEntity {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(name = "series")
    private String series;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price", precision = 20, scale = 10)
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;
}
