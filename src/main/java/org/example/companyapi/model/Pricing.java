package org.example.companyapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pricing")
public class Pricing extends GlobalRecord{
    String priceId;
    @ManyToOne
    @JoinColumn(name = "product_sys_id")
    Product product;
    Double basePrice;
    Double tradePrice;
    Double purchasePrice;
    String currency;
    LocalDateTime effectiveFrom;
    LocalDateTime effectiveTo;
    String regionCode;
    String priceType;

}
