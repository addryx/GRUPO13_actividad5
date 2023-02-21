package com.tienda.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tienda.modelo.beans.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	@Query( value = "select * from productos where nombre like '%?%' or descripcion like '%?%'", nativeQuery = true )
    List<Producto> buscadorProductos(Producto producto);
		
}
