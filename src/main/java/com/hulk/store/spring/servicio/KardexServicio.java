package com.hulk.store.spring.servicio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hulk.store.spring.dao.KardexDao;
import com.hulk.store.spring.dto.MovimientoTo;
import com.hulk.store.spring.enumeracion.MetodoValoracionInventarioEnum;
import com.hulk.store.spring.enumeracion.TipoMovimientoEnum;
import com.hulk.store.spring.enumeracion.TipoOperacionEnum;
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
public class KardexServicio {

	@Autowired
	private KardexDao kardexDao;

	@Autowired
	private ProductoServicio productoServicio;

	@Transactional
	public Kardex guardar(Kardex kardex) {
		Producto producto = productoServicio.buscarPorId(kardex.getProducto().getId());
		kardex.setProducto(producto);
		MovimientoTo movimientoTo = new MovimientoTo();
		movimientoTo.setTipoMovimiento(TipoMovimientoEnum.ENT);
		movimientoTo.setTipoOperacionEnum(TipoOperacionEnum.ECOM);
		movimientoTo.setKardex(kardex);
		kardex = guardarInventario(movimientoTo);
		// Actualizar en producto las existencias.
		producto.setExistencia(kardex.getCantidadExistencia());
		producto.setPrecioMetodoValoracion(kardex.getPrecioUnitarioExistencia());
		productoServicio.actualizar(producto);
		return kardex;
	}

	@Transactional
	public Kardex guardarInventario(MovimientoTo movimientoTo) {
		Kardex kardex = new Kardex();
		if (TipoMovimientoEnum.ENT.equals(movimientoTo.getTipoMovimiento())) {

			// Entrada Inventario Inicial
			if (TipoOperacionEnum.INVI.equals(movimientoTo.getTipoOperacionEnum())) {
				// guarda el inventario inicial
				kardex.setProducto(movimientoTo.getProducto());
				kardex.setCantidad(movimientoTo.getProducto().getExistencia());
				kardex.setPrecioUnitario(movimientoTo.getProducto().getPrecioMetodoValoracion());
				kardex.setCantidadExistencia(movimientoTo.getProducto().getExistencia());
				kardex.setPrecioUnitarioExistencia(movimientoTo.getProducto().getPrecioMetodoValoracion());
				kardex.setTipoMovimiento(TipoMovimientoEnum.ENT);
				kardex.setTipoOperacion(TipoOperacionEnum.INVI);
				kardex.setConcepto(TipoOperacionEnum.INVI.getDescripcion());
				kardex.setFecha(new Date());
			}
			// Entrada compras
			if (TipoOperacionEnum.ECOM.equals(movimientoTo.getTipoOperacionEnum())) {
				kardex = calculoExistenciaEntradaCompra(movimientoTo.getKardex());
			}
		}

		if (TipoMovimientoEnum.SAL.equals(movimientoTo.getTipoMovimiento())) {
			// Salidas Ventas
			if (TipoOperacionEnum.SVEN.equals(movimientoTo.getTipoOperacionEnum())) {
				kardex = calculoExistenciaSalidaVenta(movimientoTo.getDocumentoDetalle());
			}
		}

		return kardexDao.save(kardex);
	}

	private Kardex calculoExistenciaEntradaCompra(Kardex kardex) {
		// Promedio ponderado
		if (MetodoValoracionInventarioEnum.PP.equals(kardex.getProducto().getMetodoValoracionInventario())) {
			Integer existenciaTotalProducto = Integer.sum(kardex.getProducto().getExistencia(), kardex.getCantidad());
			BigDecimal valorTotalExistencia = kardex.getProducto().getPrecioMetodoValoracion()
					.multiply(new BigDecimal(kardex.getProducto().getExistencia()));
			BigDecimal valorTotalEntrada = kardex.getPrecioUnitario().multiply(new BigDecimal(kardex.getCantidad()));
			BigDecimal valorTotalProducto = valorTotalExistencia.add(valorTotalEntrada);
			kardex.setCantidadExistencia(existenciaTotalProducto);
			kardex.setPrecioUnitarioExistencia(
					valorTotalProducto.divide(new BigDecimal(existenciaTotalProducto), RoundingMode.HALF_UP));
		} else {
			// FIFO
			kardex.setCantidadExistencia(kardex.getProducto().getExistencia());
			kardex.setPrecioUnitarioExistencia(kardex.getPrecioUnitario());
		}

		return kardex;
	}

	private Kardex calculoExistenciaSalidaVenta(DocumentoDetalle documentoDetalle) {
		Kardex kardex = new Kardex();
		// Promedio ponderado
		if (MetodoValoracionInventarioEnum.PP.equals(documentoDetalle.getProducto().getMetodoValoracionInventario())) {
			BigDecimal existenciaTotalProducto = new BigDecimal(documentoDetalle.getProducto().getExistencia())
					.subtract(new BigDecimal(documentoDetalle.getCantidad()));
			kardex.setProducto(documentoDetalle.getProducto());
			kardex.setCantidad(documentoDetalle.getCantidad());
			kardex.setPrecioUnitario(documentoDetalle.getProducto().getPrecioMetodoValoracion());
			kardex.setCantidadExistencia(existenciaTotalProducto.intValue());
			kardex.setPrecioUnitarioExistencia(documentoDetalle.getProducto().getPrecioMetodoValoracion());
			kardex.setTipoMovimiento(TipoMovimientoEnum.SAL);
			kardex.setTipoOperacion(TipoOperacionEnum.SVEN);
			kardex.setConcepto(TipoOperacionEnum.SVEN.getDescripcion()
					.concat(" con Documento: ".concat(documentoDetalle.getDocumento().getId().toString())));
			kardex.setFecha(new Date());
		} else {
			/**
			 * @todo Implementar metodo de Venta metodo FIFO
			 */
		}

		return kardex;
	}
}
