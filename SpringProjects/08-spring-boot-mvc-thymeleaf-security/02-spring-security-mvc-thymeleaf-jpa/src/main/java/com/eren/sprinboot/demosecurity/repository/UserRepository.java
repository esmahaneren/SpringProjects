package com.eren.sprinboot.demosecurity.repository;

import com.eren.sprinboot.demosecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
