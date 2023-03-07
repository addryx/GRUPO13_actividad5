package com.tienda.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.beans.Compra;
import com.tienda.modelo.beans.ProductosCompra;
import com.tienda.modelo.dao.IntCompraDao;
import com.tienda.modelo.dao.IntProductoDao;
import com.tienda.modelo.dto.LineaCompraDto;

@Controller
@RequestMapping("/carrito")
public class CompraController {
	
	@Autowired
	IntProductoDao pdao;
	
	@Autowired
	IntCompraDao cdao;
	
	@PostMapping("/alta")
	public String altaPedido(HttpSession sesion) {
		
		List<LineaCompraDto> lista = (List<LineaCompraDto>)sesion.getAttribute("carrito");
		
		Compra c = new Compra();
		c.setDireccione(null);
		c.setEstado("Terminado");
		c.setFecha(new Date());
		c.setTarjeta(null);
		c.setUsuario(null);
		
		List<ProductosCompra> listaPC = new ArrayList<>();
		
		for (LineaCompraDto ele: lista) {
			ProductosCompra pep = new ProductosCompra();
			pep.setUnidades(ele.getCantidad());
			pep.setCompra(c);
			pep.setProducto(pdao.buscarUno(ele.getIdProducto()));
			pep.setPrecio(BigDecimal.valueOf(ele.getPrecioVenta()));
			listaPC.add(pep);
		}
		
		// Hay que desarrollar este método en la Impl del DAO.
		cdao.procesarCompra(c);
		
		return null;
		
	}
	
}
