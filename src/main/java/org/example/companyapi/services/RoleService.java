package org.example.companyapi.services;

import org.example.companyapi.dto.CreateRoleRequestDto;
import org.example.companyapi.model.Company;
import org.example.companyapi.model.Operation;
import org.example.companyapi.model.Role;
import org.example.companyapi.model.User;
import org.example.companyapi.repositories.RoleRepository;
import org.example.companyapi.utilities.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public List<Role> getRolesByCompanyName(String companyLegalName){
        return roleRepository.fetchRolesByCompanyName(companyLegalName);
    }

    public Role createRoleForCompany(String companyLegalName,
                                     CreateRoleRequestDto createRoleRequestDto,
                                     User user){
        Role role = new Role();
        role.setRoleId(CommonUtility.generateIdForEntity("ROLE"));
        role.setRoleName(companyLegalName + "_" + createRoleRequestDto.getRoleName());
        role.setCreatedBy(user);
        role.setUpdatedBy(List.of(user));
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        List<Operation> operations = operationService.fetchOperationsBySysId(createRoleRequestDto.getOperationsSysId());
        role.setOperations(operations);
        return this.save(role);
    }

    public List<Role> fetchAllRolesBySysId(List<UUID> sysIds){
        List<Role> roles = new ArrayList<>();
        for(UUID sysId : sysIds){
            roles.add(roleRepository.findById(sysId).orElse(null));
        }
        return roles;
    }


    public Role save(Role role){
        return roleRepository.save(role);
    }
}