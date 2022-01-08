package com.hulk.store.spring.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulk.store.spring.dao.DocumentoDetalleDao;
import com.hulk.store.spring.modelo.DocumentoDetalle;

/**
 * 
 * 
 * @author avfloresp
 *
 */

@Service
public class DocumentoDetalleServicio {

	@Autowired
	private DocumentoDetalleDao documentoDetalleDao;

	/**
	 * 
	 * @param detalleMovimiento
	 * @return
	 */
	@Transactional
	public DocumentoDetalle guardar(DocumentoDetalle detalleMovimiento) {
		return documentoDetalleDao.save(detalleMovimiento);
	}

	/**
	 * 
	 * @param listaDetalle
	 * @return
	 */
	@Transactional
	public List<DocumentoDetalle> guardarTodos(List<DocumentoDetalle> listaDetalle) {
		return (List<DocumentoDetalle>) documentoDetalleDao.saveAll(listaDetalle);
	}

}
