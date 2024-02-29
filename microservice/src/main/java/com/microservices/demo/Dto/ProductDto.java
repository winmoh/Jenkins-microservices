package com.microservices.demo.Dto;


import com.microservices.demo.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductDto {
    private String product_code;
    private String name;
    private long price ;
    private int available_quantity;
    private Category product_category;
}
