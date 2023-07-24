package com.example.ecommercespringbootthymeleaf.model;


import com.example.ecommercespringbootthymeleaf.model.support.UserDateAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max=200)
    private String name;
    private String email;
    @NotBlank
    @Size(max=100)
    private String username;
    @NotBlank
    @Size(max=100)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @Column(name = "login_times")
    private Integer loginTimes = 0;
    private int loginFailedTimes = 0;
    public Users(Long id, String username){
        this.id=id;
        this.username=username;
    }
}
