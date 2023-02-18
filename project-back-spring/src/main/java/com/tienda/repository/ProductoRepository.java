package com.tienda.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelo.beans.Producto;



public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
		
}
