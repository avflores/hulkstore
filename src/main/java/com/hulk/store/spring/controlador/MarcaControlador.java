package com.hulk.store.spring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.spring.modelo.Marca;
import com.hulk.store.spring.servicio.MarcaServicio;

/**
 * 
 * 
 * @author avfloresp
 *
 */

@RestController
@RequestMapping(value = "api/marcas")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcaControlador {

	@Autowired
	private MarcaServicio marcaServicio;
	
	
	@GetMapping(value = "/listar")
	public List<Marca> listar() {
		return marcaServicio.listar();
	}
	
	
}
