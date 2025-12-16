package org.example.companyapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "company")
public class Company extends GlobalRecord {
    private String id;
    private String companyName;
    private String legalName;

    //Business Compliance...
    private String gstNumber;
    private String panNumber;
    private String cinNumber;
    private String companyType;

    //Address....
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private String geoLatitude;
    private String geoLongitude;
    private boolean isKycCompleted;

    // Contact Info....
    private String contactPersonName;
    private String contactPersonEmail;
    private String supportEmail;
    private String supportPhoneNumber;

    //Finance & Banking details....
    private String bankName;
    private String bankAccountNumber;
    private String ifscCode;
    private String bankAccountType;
    private String creditLimitForDistributors;

    @OneToMany
    List<Document> documentsList;
    private String status;
}
