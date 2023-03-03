package com.tienda.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.beans.Direccione;
import com.tienda.repository.DireccioneRepository;

@Service
public class DireccioneDaoImplMy8 implements IntDireccioneDao{
	
	@Autowired
	DireccioneRepository drepo;
	
	@Override
	public int registrarDireccion(Direccione direccione) {
		int filas = 0;
		try {
			drepo.save(direccione);
			filas = 1;
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		return filas;
		}

	@Override
	public int eliminarDireccion(int idDireccion) {
		int filas = 0;
		try {
			drepo.deleteById(idDireccion);
			filas = 1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Direccione> clientesPorLocalidad() {
		try {
			return drepo.clientesPorLocalidad();
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
		
	}
}
