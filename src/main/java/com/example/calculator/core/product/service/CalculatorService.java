package com.example.calculator.core.product.service;

import com.example.calculator.core.product.entity.CalculatorEntity;
import com.example.calculator.core.product.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class CalculatorService {

    @Autowired
    private CalculatorRepository calculatorRepository;


    public List<CalculatorEntity> findAll() {

        return calculatorRepository.findAll();
    }


    public CalculatorEntity findProductById(Long id) {
        return calculatorRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public CalculatorEntity createProduct(CalculatorEntity product){
        return calculatorRepository.create(product);
    }


    public CalculatorEntity updateProductById(Long productId, CalculatorEntity product) throws Exception {


        Optional<CalculatorEntity> optionalProduct = Optional.ofNullable(findProductById(productId));
        optionalProduct.orElseThrow(NoSuchElementException::new);
        CalculatorEntity productOld = optionalProduct.get();
        productOld.setName(product.getName());
        productOld.setCalculatedValue(product.getCalculatedValue());
        calculatorRepository.update(productOld);
        return productOld;
    }

    public CalculatorEntity deleteProduct(Long productID) {
        CalculatorEntity product = findProductById(productID);
        calculatorRepository.delete(product);
        return product;
    }
}