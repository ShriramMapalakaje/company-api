package org.example.companyapi.repositories;

import org.example.companyapi.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperationRepository extends JpaRepository<Operation, UUID> {
    public Operation findByOperationName(String name);
    public Operation existByOperationName(String name);
}
