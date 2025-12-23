package org.example.companyapi.services;

import org.example.companyapi.model.Operation;
import org.example.companyapi.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    @Autowired
    OperationRepository operationRepository;

    public List<Operation> fetchAllOperations(){
        return operationRepository.findAll();
    }
}