package com.vnmcodes.liquibase_integration.repository;


import com.vnmcodes.liquibase_integration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

