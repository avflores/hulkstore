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

import com.hulk.store.spring.modelo.Documento;
import com.hulk.store.spring.servicio.DocumentoServicio;

/**
 * 
 * @author avfloresp
 *
 */

@RestController
@RequestMapping(value = "api/venta")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentoControlador {

	@Autowired
	private DocumentoServicio documentoServicio;

	/**
	 * 
	 * @param documentoIn
	 * @return
	 */
	@PostMapping(value = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Documento documentoIn) {
		try {

			documentoIn.setFechaEmision(new Date());
			Documento documento = documentoServicio.guardar(documentoIn);

			if (null == documento) {
				Map<String, String> respuesta = new HashMap<>();
				respuesta.put("mensaje", "Error al guardar la venta");
				return new ResponseEntity<Map<String, String>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Documento>(documento, HttpStatus.OK);

		} catch (Exception e) {
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Error al guardar la venta");
			return new ResponseEntity<Map<String, String>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
