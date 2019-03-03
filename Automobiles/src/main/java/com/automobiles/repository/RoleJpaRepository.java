package com.automobiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobiles.model.Role;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Integer> {

}
