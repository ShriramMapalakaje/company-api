package org.example.companyapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sysId;
    private String documentName;
    private String documentType;
    private String documentUrl;
}
