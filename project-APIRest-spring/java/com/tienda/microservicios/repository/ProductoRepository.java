package com.tienda.microservicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.microservicios.modelo.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
}
