package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
