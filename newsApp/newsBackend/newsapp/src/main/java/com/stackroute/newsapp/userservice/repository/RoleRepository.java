package com.stackroute.newsapp.userservice.repository;

import com.stackroute.newsapp.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
