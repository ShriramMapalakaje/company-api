package org.example.companyapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product  extends GlobalRecord {


    @Column(unique = true)
    String skuCode;
    String branchName;
    String category;
    String status;
    String packType;
    String packSize;
    String unitPerCase;
    String uom;
    String weightPerUnit;
    String shelfLifeInDays;
    String hsnCode;
    Double isReturnable;
    String discription;
    @ManyToOne
    @JoinColumn(name = "created_by_id")
    User createdBy;
    @ManyToOne
    @JoinColumn(name = "updated_by_id")
    User updatedBy;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;


}
