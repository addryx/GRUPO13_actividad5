package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelo.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer>{

}
