package org.example.companyapi.services;

import org.example.companyapi.model.Company;
import org.example.companyapi.model.Role;
import org.example.companyapi.model.User;
import org.example.companyapi.repositories.RoleRepository;
import org.example.companyapi.utilities.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    OperationService operationService;
    @Autowired
    RoleRepository roleRepository;

    public Role createBotRole(){
        Role role = new Role();
        role.setRoleId(CommonUtility.generateIdForEntity("ROLE"));
        role.setRoleName("SupplyNext_Bot");
        role.setOperations(operationService.fetchAllOperations());
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        return this.save(role);
    }

    public Role createFirstAdminRoleForCompany(Company company, User botUser){
        Role role = new Role();
        role.setRoleId(CommonUtility.generateIdForEntity("ROLE"));
        role.setRoleName(company.getLegalName() + "_" + "Admin");
        role.setOperations(operationService.fetchAllOperations());
        role.setCreatedBy(botUser);
        role.setUpdatedBy(List.of(botUser));
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        return this.save(role);
    }


    public Role save(Role role){
        return roleRepository.save(role);
    }
}