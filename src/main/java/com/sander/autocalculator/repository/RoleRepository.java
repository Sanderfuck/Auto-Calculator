package com.sander.autocalculator.repository;

import com.sander.autocalculator.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<User,Long> {
}
