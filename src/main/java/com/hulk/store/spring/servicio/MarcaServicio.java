package com.hulk.store.spring.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hulk.store.spring.dao.MarcaDao;
import com.hulk.store.spring.modelo.Marca;

/**
 * 
 * 
 * @author avfloresp
 *
 */

@Service
public class MarcaServicio {
	
	@Autowired
	private MarcaDao marcaDao;

	@Transactional(readOnly = true)
	public List<Marca> listar() {
		return (List<Marca>) marcaDao.findAll();
	}
}
