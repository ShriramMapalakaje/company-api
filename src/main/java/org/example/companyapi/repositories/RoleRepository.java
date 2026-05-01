package org.example.companyapi.repositories;

import org.example.companyapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    @Query("SELECT r FROM Role r WHERE r.roleName LIKE CONCAT(:companyName, '_%')")
    List<Role> fetchRolesByCompanyName(@Param("companyName") String companyName);
}
