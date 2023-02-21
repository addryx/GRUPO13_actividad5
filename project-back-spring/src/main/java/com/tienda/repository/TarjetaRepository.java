package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelo.beans.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{

}
