package com.example.ecommercespringbootthymeleaf.model;

import com.example.ecommercespringbootthymeleaf.model.support.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;

    public  Category convertToModel(Category category){

        category.setName(this.getName());
        category.setDescription(this.getDescription());
        return category;
    }
}
