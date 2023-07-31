package com.jccv.risolva.dashboard.controller;

import com.jccv.risolva.dashboard.dto.CompanyDTO;
import com.jccv.risolva.dashboard.models.CompanyEntity;
import com.jccv.risolva.dashboard.repository.CompanyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("v1/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping()
    public ResponseEntity<?> getAllCompanies(){
        Iterable<CompanyEntity>  allCompanies =companyRepository.findAll();
        return ResponseEntity.ok(allCompanies);
    }

    @PostMapping
    public ResponseEntity<?> createCompany(@Valid @RequestBody CompanyDTO companyDTO){

            CompanyEntity companyEntity = CompanyEntity.builder()
                    .name(companyDTO.getName())
                    .description(companyDTO.getDescription())
                    .build();
            CompanyEntity companySaved= companyRepository.save(companyEntity);
            return ResponseEntity.ok(companySaved);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@Valid @RequestBody CompanyDTO companyDTO, @PathVariable String id){

        CompanyEntity companyEntity = CompanyEntity.builder()
                .id(Long.parseLong(id))
                .name(companyDTO.getName())
                .description(companyDTO.getDescription())
                .build();
        CompanyEntity companyUpdated= companyRepository.save(companyEntity);
        return ResponseEntity.ok(companyUpdated);
    }

}
