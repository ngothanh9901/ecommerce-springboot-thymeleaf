package com.example.ecommercespringbootthymeleaf.model;

import com.example.ecommercespringbootthymeleaf.model.support.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status = false;
    private String note;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;
    @OneToMany(mappedBy="orders")
    @JsonIgnore
    private List<OrderDetail> orderDetailList = new ArrayList<>();
    public Orders(Users user){
        this.user = user;
    }
}
