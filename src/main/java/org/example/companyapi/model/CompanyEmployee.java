package org.example.companyapi.model;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "company_employees")
public class CompanyEmployee extends User{
    private String companyEmployeeId;
    @ManyToOne
    private Company company;
}