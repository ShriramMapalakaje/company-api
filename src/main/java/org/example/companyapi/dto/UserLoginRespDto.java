package org.example.companyapi.dto;

import lombok.Data;
import org.example.companyapi.model.Role;

import java.util.List;

@Data
public class UserLoginRespDto {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    List<Role> roles;
    CompanyLoginResp companyLoginResp;
    private int pincode;
    String token;
    private boolean isCompanyUser; // Company dashboard, else distributor dashboard
}
