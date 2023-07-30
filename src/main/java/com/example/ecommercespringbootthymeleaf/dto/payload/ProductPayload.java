package com.example.ecommercespringbootthymeleaf.dto.payload;

import com.example.ecommercespringbootthymeleaf.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPayload {
    private String name;
    private String shortDes;
    private String description;
    private Double price;
    private String imageLink;
    private List<Long> categoryIds;

    public Product convertToModel(){
        Product product = new Product();
        product.setName(this.getName());
        product.setImageLink(this.imageLink);
        product.setDescription(this.getDescription());
        product.setShortDes(this.shortDes);
        product.setPrice(this.getPrice());
        return product;
    }
}
