package com.tienda.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tienda.modelo.beans.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	@Query("SELECT p from Producto p where p.nombre LIKE %?1%")
    List<Producto> buscadorProductos(String nombre);
	
	@Query("SELECT p from Producto p order by p.nombre asc")
    List<Producto> filtroProductos(String nombre);

}
