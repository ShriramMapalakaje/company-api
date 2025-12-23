package org.example.companyapi.services;


import org.example.companyapi.model.Company;
import org.example.companyapi.model.CompanyEmployee;
import org.example.companyapi.model.Role;
import org.example.companyapi.model.User;
import org.example.companyapi.repositories.CompanyEmployeeRepository;
import org.example.companyapi.utilities.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompanyEmployeeService {

    @Autowired
    CompanyEmployeeRepository companyEmployeeRepository;
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    public CompanyEmployee save(CompanyEmployee companyEmployee){
        return  companyEmployeeRepository.save(companyEmployee);
    }

    public CompanyEmployee createFirstAdminAccount(Company company){
        User botUser = userService.getBotUser();
        CompanyEmployee companyEmployee = new CompanyEmployee();
        companyEmployee.setCompany(company);
        companyEmployee.setCompanyEmployeeId(CommonUtility.generateIdForEntity("COMP-EMP"));
        companyEmployee.setEmail(company.getSupportEmail());
        companyEmployee.setPassword(CommonUtility.generateRandomPassword(15));
        companyEmployee.setCreatedAt(LocalDateTime.now());
        companyEmployee.setUpdatedAt(LocalDateTime.now());
        companyEmployee.setAddressLine1(company.getAddressLine1());
        companyEmployee.setAddressLine2(company.getAddressLine2());
        companyEmployee.setAddressLine3(company.getAddressLine3());
        companyEmployee.setFullName(company.getCompanyName() + " " + "Admin");
        companyEmployee.setPhoneNumber(company.getSupportPhoneNumber());
        companyEmployee.setPincode(company.getPincode());
        Role role = roleService.createFirstAdminRoleForCompany(company, botUser);
        companyEmployee.setRoles(List.of(role));
        // We need to create the role for the company admin
        return this.save(companyEmployee);
    }
}