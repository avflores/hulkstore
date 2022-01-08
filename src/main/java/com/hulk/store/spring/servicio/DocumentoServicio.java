package com.hulk.store.spring.servicio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulk.store.spring.dao.DocumentoDao;
import com.hulk.store.spring.dto.MovimientoTo;
import com.hulk.store.spring.enumeracion.TipoMovimientoEnum;
import com.hulk.store.spring.enumeracion.TipoOperacionEnum;
import com.hulk.store.spring.modelo.Documento;
import com.hulk.store.spring.modelo.DocumentoDetalle;
import com.hulk.store.spring.modelo.Kardex;
import com.hulk.store.spring.modelo.Producto;

/**
 * 
 * 
 * @author avfloresp
 *
 */
@Service
public class DocumentoServicio {

	@Autowired
	private DocumentoDao documentoDao;

	@Autowired
	private DocumentoDetalleServicio documentoDetalleServicio;

	@Autowired
	private KardexServicio kardexServicio;

	@Autowired
	private ProductoServicio productoServicio;

	/**
	 * 
	 * @param documento
	 * @return
	 */
	@Transactional
	public Documento guardar(Documento documento) {
		documento = documentoDao.save(documento);
		documentoDetalleServicio.guardarTodos(documento.getDetalle());
		// Descargar de inventario
		documento.getDetalle().forEach(item ->registrarKardex(item));
		
		
		return documento;
	}

	/**
	 * 
	 * @param documentoDetalles
	 */
	@Transactional
	private void registrarKardex(DocumentoDetalle documentoDetalle) {
		Producto producto = productoServicio.buscarPorId(documentoDetalle.getProducto().getId());
		documentoDetalle.setProducto(producto);
		MovimientoTo movimientoTo = new MovimientoTo();
		movimientoTo.setTipoMovimiento(TipoMovimientoEnum.SAL);
		movimientoTo.setTipoOperacionEnum(TipoOperacionEnum.SVEN);
			movimientoTo.setDocumentoDetalle(documentoDetalle);
			Kardex kardex = kardexServicio.guardarInventario(movimientoTo);
			// Actualizar en producto las existencias.			
			producto.setExistencia(kardex.getCantidadExistencia());
			producto.setPrecioMetodoValoracion(kardex.getPrecioUnitarioExistencia());
			productoServicio.actualizar(producto);
	}

}
