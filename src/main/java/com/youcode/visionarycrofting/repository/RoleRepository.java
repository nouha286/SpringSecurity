package com.youcode.visionarycrofting.repository;


import com.youcode.visionarycrofting.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByNameRole(String name);
}
