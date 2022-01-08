package com.hulk.store.spring.controlador;

import java.util.Date;
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

import com.hulk.store.spring.modelo.Kardex;
import com.hulk.store.spring.servicio.KardexServicio;

/**
 * 
 * 
 * @author avfloresp
 *
 */

@RestController
@RequestMapping(value = "api/compras")
@CrossOrigin(origins = "http://localhost:4200")
public class KardexControlador {

	@Autowired
	private KardexServicio kardexServicio;

	@PostMapping(value = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Kardex kardexIn) {
		try {

			kardexIn.setFecha(new Date());
			Kardex kardex = kardexServicio.guardar(kardexIn);

			if (null == kardex) {
				Map<String, String> respuesta = new HashMap<>();
				respuesta.put("mensaje", "Error al guardar la venta");
				return new ResponseEntity<Map<String, String>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Kardex>(kardex, HttpStatus.OK);

		} catch (Exception e) {
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Error al guardar la venta");
			return new ResponseEntity<Map<String, String>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
