package com.example.ecommercespringbootthymeleaf.model;

import com.example.ecommercespringbootthymeleaf.model.support.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code",unique = true)
    private String code;
    @Column(name = "name",unique = true)
    private String name;
    public Role(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
