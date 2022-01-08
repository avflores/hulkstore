package com.hulk.store.spring.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hulk.store.spring.dao.ProductoDao;
import com.hulk.store.spring.dto.MovimientoTo;
import com.hulk.store.spring.enumeracion.TipoMovimientoEnum;
import com.hulk.store.spring.enumeracion.TipoOperacionEnum;
import com.hulk.store.spring.modelo.Producto;

/**
 * 
 * 
 * @author avfloresp
 *
 */
@Service
public class ProductoServicio {

	@Autowired
	private ProductoDao productoDao;

	@Autowired
	private KardexServicio kardexServicio;

	@Transactional(readOnly = true)
	public List<Producto> listar() {
		return (List<Producto>) productoDao.findAll();
	}

	/**
	 * Guarda el producto nuevo y su inventario inicial
	 * 
	 * @param producto
	 * @return
	 */
	@Transactional
	public Producto guardar(Producto producto) {
		productoDao.save(producto);
		// Inventario inicial
		registrarKardex(producto);
		return producto;
	}
	
	/**
	 * 
	 * @param producto
	 * @return
	 */
	@Transactional
	public Producto actualizar(Producto producto) {
		productoDao.save(producto);		
		return producto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Producto buscarPorId(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	/**
	 * 
	 * 
	 * @param producto
	 */
	@Transactional
	private void registrarKardex(Producto producto) {
		MovimientoTo movimientoTo = new MovimientoTo();
		movimientoTo.setTipoMovimiento(TipoMovimientoEnum.ENT);
		movimientoTo.setTipoOperacionEnum(TipoOperacionEnum.INVI);
		movimientoTo.setProducto(producto);
		kardexServicio.guardarInventario(movimientoTo);

	}
}
