package com.jccv.risolva.dashboard.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String category_id;

    @NotBlank
    private String company_id;

}
