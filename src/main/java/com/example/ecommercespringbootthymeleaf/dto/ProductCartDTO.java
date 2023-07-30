package com.example.ecommercespringbootthymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCartDTO {
    private String name;
    private String imageLink;
    private Long quantity;
    private Double sum;
}
