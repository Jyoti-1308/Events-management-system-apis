package com.manage.repositories;


import com.manage.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, String> {
    Login findByUsername(String username);
}
