package org.example.companyapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/c2d/api/v1/company")
public class CompanyController {
    @PostMapping("/start-onboarding")
    public ResponseEntity startOnBoarding(
            @RequestPart(value = "gstCertificate")MultipartFile getGSTCertificate,
            @RequestPart(value = "panCard")MultipartFile getPanCard,
            @RequestPart(value = "companyRegistrationCertificate")MultipartFile companyRegistrationCertificate,
            @RequestPart(value = "companyLogo")MultipartFile getCompanyLogo,
            @RequestPart(value = "companyInfo")MultipartFile companyInfo
            ) {

        return  ResponseEntity.ok("Success");

    }
}
