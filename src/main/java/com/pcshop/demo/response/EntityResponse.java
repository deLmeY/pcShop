package com.pcshop.demo.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityResponse<T> {

    private String type;
    private List<T> productsForType;
    private Integer count;
}
