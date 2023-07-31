package com.jccv.risolva.dashboard.repository;

import com.jccv.risolva.dashboard.models.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {
}
