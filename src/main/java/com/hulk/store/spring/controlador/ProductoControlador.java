package com.hulk.store.spring.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.spring.modelo.Producto;
import com.hulk.store.spring.servicio.ProductoServicio;

@RestController
@RequestMapping(value = "api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoControlador {

	@Autowired
	private ProductoServicio productoServicio;

	@PostMapping(value = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Producto productoIn) {
		try {

			Producto producto = productoServicio.guardar(productoIn);
			if (null == producto) {
				Map<String, String> respuesta = new HashMap<>();
				respuesta.put("mensaje", "Error al guardar el producto");
				return new ResponseEntity<Map<String, String>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);

		} catch (Exception e) {
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Error al guardar el producto");
			return new ResponseEntity<Map<String, String>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
