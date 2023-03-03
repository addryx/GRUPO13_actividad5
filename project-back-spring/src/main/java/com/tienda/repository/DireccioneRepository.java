package com.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tienda.modelo.beans.Direccione;

public interface DireccioneRepository extends JpaRepository<Direccione, Integer>{
	
	@Query(value = "select d.localidad, COUNT(distinct (ud.id_usuario)) as cantidad_usuarios "
            + "from direcciones d "
            + "join usuarios_direcciones ud on d.id_direccion = ud.id_direccion "
            + "group by d.localidad", nativeQuery = true)
	List<Direccione> clientesPorLocalidad();
	
}
