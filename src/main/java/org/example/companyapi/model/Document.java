package org.example.companyapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents")
public class Document extends GlobalRecord{
    String documentName;
    String documentOriginalName;
    String documentType;
    String documentUrl;
}
