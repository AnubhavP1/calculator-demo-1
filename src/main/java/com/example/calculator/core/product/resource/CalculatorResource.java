package com.example.calculator.core.product.resource;

import com.example.calculator.core.product.dto.CalculatorDTO;
import com.example.calculator.core.product.entity.CalculatorEntity;
import com.example.calculator.core.product.service.CalculatorService;
import com.example.calculator.utils.RequestDTO;
import com.example.calculator.utils.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calculator")
public class CalculatorResource {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/all")
    public List<CalculatorDTO> listAllProducts(){
        return calculatorService.findAll().stream().map(CalculatorDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/create")
    @Transactional
    public ResponseDTO<CalculatorDTO> createProduct (@RequestDTO(CalculatorDTO.class) @Validated @RequestBody CalculatorEntity product){
        return ResponseDTO.accepted().convertTo(calculatorService.createProduct(product), CalculatorDTO.class);
    }


    @GetMapping("{id}")
    public ResponseEntity<CalculatorEntity> findProductById(@PathVariable Long id){
        return ResponseEntity.ok(calculatorService.findProductById(id));
    }


    @PutMapping("update/{id}")
    public ResponseEntity<CalculatorEntity> updateProductById(@PathVariable("id") Long productId, @RequestBody @Validated CalculatorEntity product) throws Exception {
        return  ResponseEntity.ok(calculatorService.updateProductById(productId, product));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<CalculatorEntity> deleteProductById(@PathVariable("id") Long productID){
        return ResponseEntity.ok(calculatorService.deleteProduct(productID));
    }

}