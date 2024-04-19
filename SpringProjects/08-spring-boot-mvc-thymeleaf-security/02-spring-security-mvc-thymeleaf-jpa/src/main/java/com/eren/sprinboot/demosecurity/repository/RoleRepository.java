package com.eren.sprinboot.demosecurity.repository;

import com.eren.sprinboot.demosecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

   Role findRoleByName(String roleName);
}
