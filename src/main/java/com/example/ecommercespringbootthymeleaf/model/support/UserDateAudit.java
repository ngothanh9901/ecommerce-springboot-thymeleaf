package com.example.ecommercespringbootthymeleaf.model.support;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

public abstract class UserDateAudit extends DateAudit{
    @CreatedBy
    @JsonIgnore
    private Long createdBy;
    @LastModifiedBy
    @JsonIgnore
    private Long updatedBy;
    private boolean deleted;
}
