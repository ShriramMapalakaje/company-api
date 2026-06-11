package org.example.companyapi.services;

import org.example.companyapi.model.Operation;
import org.example.companyapi.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OperationService {
    @Autowired
    OperationRepository operationRepository;

    public List<Operation> fetchAllOperations(){
        return operationRepository.findAll();
    }

    public List<Operation> fetchOperationsBySysId(List<UUID> sysIds){
        List<Operation> operations = new ArrayList<>();
        for(UUID sysId : sysIds){
            operations.add(operationRepository.findById(sysId).orElse(null));
        }
        return operations;
    }
}