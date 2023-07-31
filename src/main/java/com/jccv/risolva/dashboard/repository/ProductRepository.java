package com.jccv.risolva.dashboard.repository;

import com.jccv.risolva.dashboard.models.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
