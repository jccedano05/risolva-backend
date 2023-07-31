package com.jccv.risolva.dashboard.controller;

import com.jccv.risolva.dashboard.dto.CompanyDTO;
import com.jccv.risolva.dashboard.dto.ProductDto;
import com.jccv.risolva.dashboard.models.CategoryProductEntity;
import com.jccv.risolva.dashboard.models.CompanyEntity;
import com.jccv.risolva.dashboard.models.ProductEntity;
import com.jccv.risolva.dashboard.repository.CategoryProductRepository;
import com.jccv.risolva.dashboard.repository.CompanyRepository;
import com.jccv.risolva.dashboard.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("v1/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryProductRepository categoryProductRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping()
    public ResponseEntity<?> getAllProducts(){
        Iterable<ProductEntity>  allProducts =productRepository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<?> createProducts(@Valid @RequestBody ProductDto productDto){

        CategoryProductEntity categoryProduct = categoryProductRepository.findById(Long.parseLong(productDto.getCategory_id())).get();
        CompanyEntity companyEntity = companyRepository.findById(Long.parseLong(productDto.getCompany_id())).get();


        ProductEntity product = ProductEntity.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .categoryProduct(categoryProduct)
                .company(companyEntity)
                .build();
        ProductEntity productSaved= productRepository.save(product);
        return ResponseEntity.ok(productSaved);
    }

}
