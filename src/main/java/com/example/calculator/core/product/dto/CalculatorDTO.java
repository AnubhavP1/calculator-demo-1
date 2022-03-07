package com.example.calculator.core.product.dto;

import com.example.calculator.core.product.entity.CalculatorEntity;
import com.example.calculator.utils.DTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@DTO
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatorDTO {

    private String name;

    private float calculatedValue;

    public CalculatorDTO(){
    }

    public CalculatorDTO(CalculatorEntity product){
        this.name = product.getName();
        this.calculatedValue = product.getCalculatedValue();
    }

    public String getName() { return name;}

    public void setName(String name){
        this.name = name;
    }

    public float getCalculatedValue(){
        return calculatedValue;
    }
    public void setCalculatedValue(float calculatedValue){
        this.calculatedValue = calculatedValue;
    }
}