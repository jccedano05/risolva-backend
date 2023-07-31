package com.jccv.risolva.dashboard.controller;

import com.jccv.risolva.dashboard.dto.CategoryProductDTO;
import com.jccv.risolva.dashboard.dto.CompanyDTO;
import com.jccv.risolva.dashboard.models.CategoryProductEntity;
import com.jccv.risolva.dashboard.models.CompanyEntity;
import com.jccv.risolva.dashboard.repository.CategoryProductRepository;
import com.jccv.risolva.dashboard.repository.CompanyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("v1/categoriesProduct")
public class CategoryProductController {
    @Autowired
    private CategoryProductRepository categoryProductRepository;

    @GetMapping()
    public ResponseEntity<?> getAllCompanies(){
        Iterable<CategoryProductEntity>  allCategories =categoryProductRepository.findAll();
        return ResponseEntity.ok(allCategories);
    }

    @PostMapping
    public ResponseEntity<?> createCompany(@Valid @RequestBody CategoryProductDTO categoryProductDTO){

        CategoryProductEntity categoryProductEntity = CategoryProductEntity.builder()
                .name(categoryProductDTO.getName())
                .description(categoryProductDTO.getDescription())
                .build();
        CategoryProductEntity categoryProductSaved= categoryProductRepository.save(categoryProductEntity);
        return ResponseEntity.ok(categoryProductSaved);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@Valid @RequestBody CategoryProductDTO categoryProductDTO, @PathVariable String id){

        CategoryProductEntity categoryProductEntity = CategoryProductEntity.builder()
                .id(Long.parseLong(id))
                .name(categoryProductDTO.getName())
                .description(categoryProductDTO.getDescription())
                .build();
        CategoryProductEntity categoryProductSaved= categoryProductRepository.save(categoryProductEntity);
        return ResponseEntity.ok(categoryProductSaved);
    }
}
