package org.example.companyapi.model;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "general_record")
@Inheritance(strategy = InheritanceType.JOINED)
public class GlobalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sysId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private org.apache.catalina.User createdBy;
    private User updatedBy;
}

