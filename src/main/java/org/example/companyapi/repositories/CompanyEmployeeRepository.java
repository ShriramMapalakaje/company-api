package org.example.companyapi.repositories;

import org.example.companyapi.model.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyEmployeeRepository extends JpaRepository<CompanyEmployee, UUID> {
}
