package org.example.companyapi.jobs;

import org.example.companyapi.model.Operation;
import org.example.companyapi.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OperationScheduler {

    @Autowired
    OperationRepository operationRepository;

    @Scheduled(initialDelay = 5000, fixedDelay = Long.MAX_VALUE)
    public void insertOperations() {
        // Fetch all existing operations once to avoid repeated database queries
        Set<String> existingOperationNames = operationRepository.findAll().stream()
                .map(Operation::getOperationName)
                .collect(Collectors.toSet());

        this.processOperation("COMPANY_CREATE", "COMPANY", existingOperationNames);
        this.processOperation("COMPANY_VIEW", "COMPANY", existingOperationNames);
        this.processOperation("COMPANY_UPDATE", "COMPANY", existingOperationNames);
        this.processOperation("COMPANY_DELETE", "COMPANY", existingOperationNames);
        this.processOperation("COMPANY_ONBOARD", "COMPANY", existingOperationNames);
        this.processOperation("COMPANY_VERIFY", "COMPANY", existingOperationNames);
        this.processOperation("COMPANY_ACTIVATE", "COMPANY", existingOperationNames);
        this.processOperation("COMPANY_DEACTIVATE", "COMPANY", existingOperationNames);
        this.processOperation("PRODUCT_CREATE", "PRODUCT", existingOperationNames);
        this.processOperation("PRODUCT_VIEW", "PRODUCT", existingOperationNames);
        this.processOperation("PRODUCT_UPDATE", "PRODUCT", existingOperationNames);
        this.processOperation("PRODUCT_DELETE", "PRODUCT", existingOperationNames);
        this.processOperation("PRODUCT_PRICE_UPDATE", "PRODUCT", existingOperationNames);
        this.processOperation("PRODUCT_STOCK_UPDATE", "PRODUCT", existingOperationNames);
        this.processOperation("PRODUCT_BULK_UPLOAD", "PRODUCT", existingOperationNames);
        this.processOperation("PO_CREATE", "PURCHASE_ORDER", existingOperationNames);
        this.processOperation("PO_VIEW", "PURCHASE_ORDER", existingOperationNames);
        this.processOperation("PO_UPDATE", "PURCHASE_ORDER", existingOperationNames);
        this.processOperation("PO_CANCEL", "PURCHASE_ORDER", existingOperationNames);
        this.processOperation("PO_APPROVE", "PURCHASE_ORDER", existingOperationNames);
        this.processOperation("PO_REJECT", "PURCHASE_ORDER", existingOperationNames);
        this.processOperation("PO_CLOSE", "PURCHASE_ORDER", existingOperationNames);
        this.processOperation("SO_CREATE", "SALES_ORDER", existingOperationNames);
        this.processOperation("SO_VIEW", "SALES_ORDER", existingOperationNames);
        this.processOperation("SO_UPDATE", "SALES_ORDER", existingOperationNames);
        this.processOperation("SO_CANCEL", "SALES_ORDER", existingOperationNames);
        this.processOperation("SO_DISPATCH", "SALES_ORDER", existingOperationNames);
        this.processOperation("SO_DELIVER", "SALES_ORDER", existingOperationNames);
        this.processOperation("INVENTORY_VIEW", "INVENTORY", existingOperationNames);
        this.processOperation("INVENTORY_ADD_STOCK", "INVENTORY", existingOperationNames);
        this.processOperation("INVENTORY_REMOVE_STOCK", "INVENTORY", existingOperationNames);
        this.processOperation("INVENTORY_ADJUSTMENT", "INVENTORY", existingOperationNames);
        this.processOperation("INVENTORY_TRANSFER", "INVENTORY", existingOperationNames);
        this.processOperation("USER_CREATE", "USER", existingOperationNames);
        this.processOperation("USER_VIEW", "USER", existingOperationNames);
        this.processOperation("USER_UPDATE", "USER", existingOperationNames);
        this.processOperation("USER_DELETE", "USER", existingOperationNames);
        this.processOperation("USER_ASSIGN_ROLE", "USER", existingOperationNames);
        this.processOperation("USER_REVOKE_ROLE", "USER", existingOperationNames);
        this.processOperation("PAYMENT_INITIATE", "PAYMENT", existingOperationNames);
        this.processOperation("PAYMENT_RECEIVE", "PAYMENT", existingOperationNames);
        this.processOperation("PAYMENT_REFUND", "PAYMENT", existingOperationNames);
        this.processOperation("PAYMENT_FAILED", "PAYMENT", existingOperationNames);
        this.processOperation("INVITE_EMPLOYEE", "SECURITY", existingOperationNames);
        this.processOperation("CREATE_ROLE", "SECURITY", existingOperationNames);
        this.processOperation("VIEW_ROLE", "SECURITY", existingOperationNames);
        this.processOperation("VIEW_OPERATIONS", "SECURITY", existingOperationNames);
    }

    private void processOperation(String operationName, String operationType, Set<String> existingOperationNames) {
        if (existingOperationNames.contains(operationName)) {
            return;
        }

        Operation operation = new Operation();
        operation.setOperationName(operationName);
        operation.setOperationType(operationType);

        operationRepository.save(operation);
        existingOperationNames.add(operationName);
    }
    
    // Kept for backward compatibility if needed, or can be removed
    public void insertOperation(String operationName, String operationType) {
        if (operationRepository.findByOperationName(operationName) != null) {
            return;
        }
        Operation operation = new Operation();
        operation.setOperationName(operationName);
        operation.setOperationType(operationType);
        operationRepository.save(operation);
    }
}