package com.example.calculator.core.product.repository;

import com.example.calculator.core.product.entity.CalculatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.time.LocalDateTime;

@Repository
public interface CalculatorRepository extends JpaRepository<CalculatorEntity, Long> {

    default CalculatorEntity create(CalculatorEntity product){
        product.setCreatedBy(1l);
//        product.setCreationDate(LocalDateTime.now());
        return this.save(product);
    }

    default CalculatorEntity update(CalculatorEntity product) throws Exception {
        if (product.getId() == null) {
            throw new Exception("Product does not existe");
        }

//        product.setUpdateDate(LocalDateTime.now());

        return this.save(product);
    }
}