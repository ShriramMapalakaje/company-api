package org.example.companyapi.repositories;

import org.example.companyapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    public User findByEmail(String email);
}
