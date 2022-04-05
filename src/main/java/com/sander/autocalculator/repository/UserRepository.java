package com.sander.autocalculator.repository;

import com.sander.autocalculator.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
