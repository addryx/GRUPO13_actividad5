package com.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tienda.modelo.beans.Direccione;
import com.tienda.modelo.beans.Tarjeta;
import com.tienda.modelo.beans.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "select u.nombre, COUNT(distinct (c.id_compra)) as pedidos_totales, SUM(pc.precio*pc.unidades) as importe_total "
			+ "from usuarios u "
			+ "join compras c on u.id_usuario = c.id_usuario "
			+ "join productos_compra pc on pc.id_compra = c.id_compra "
			+ "where u.id_usuario = ?1 "
			+ "group by u.nombre;", nativeQuery = true)
	List<Usuario> datosUsuario(int idUsuario);
	
	//Estos metodos se han añadido para meter direcciones y tarjetas
	
	@Query("select u.tarjetas from Usuario u where u.idUsuario=?1")
	List<Tarjeta> tarjetaUsuario(int idUsuario);
	
	@Query("select u.direciones from Usuario u where u.idUsuario=?1")
	List<Direccione> direccionesUsuario(int idUsuario);
}
