package com.example.calculator.core.product.entity;

import com.example.calculator.utils.EntityState;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
//import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "CalculatorEntity")
@Table(name = "calculatorOutput")
public class CalculatorEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "calculatedValue")
    private float calculatedValue;

    @LastModifiedBy
    @Column(name = "last_update_by", nullable = true, updatable = false)
    private Long updatedBy;

//    @LastModifiedDate
//    @Column(name = "last_update_time", nullable = true, updatable = false)
//    private LocalDateTime updateDate;


    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private Long createdBy;

//    @CreatedDate
//    @Column(name = "creation_time", nullable = true, updatable = false)
//    private LocalDateTime creationDate;

    @Enumerated(EnumType.ORDINAL)
    private EntityState status = EntityState.ACTIVE;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid = UUID.randomUUID().toString();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public EntityState getStatus() {
        return status;
    }

    public void setStatus(EntityState status) {
        this.status = status;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

//    public LocalDateTime getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(LocalDateTime creationDate) {
//        this.creationDate = creationDate;
//    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

//    public LocalDateTime getUpdateDate() {
//        return updateDate;
//    }
//
//    public void setUpdateDate(LocalDateTime updateDate) {
//        this.updateDate = updateDate;
//    }

    public float getCalculatedValue() {
        return calculatedValue;
    }

    public void setCalculatedValue(float calculatedValue) {
        this.calculatedValue = calculatedValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CalculatorEntity other = (CalculatorEntity) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }


}