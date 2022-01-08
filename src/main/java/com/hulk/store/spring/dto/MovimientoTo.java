package com.hulk.store.spring.dto;

import com.hulk.store.spring.enumeracion.TipoMovimientoEnum;
import com.hulk.store.spring.enumeracion.TipoOperacionEnum;
import com.hulk.store.spring.modelo.DocumentoDetalle;
import com.hulk.store.spring.modelo.Kardex;
import com.hulk.store.spring.modelo.Producto;

public class MovimientoTo {

	private TipoMovimientoEnum tipoMovimiento;

	private TipoOperacionEnum tipoOperacionEnum;

	private Producto producto;

	private DocumentoDetalle documentoDetalle;

	private Kardex kardex;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public DocumentoDetalle getDocumentoDetalle() {
		return documentoDetalle;
	}

	public void setDocumentoDetalle(DocumentoDetalle documentoDetalle) {
		this.documentoDetalle = documentoDetalle;
	}

	public Kardex getKardex() {
		return kardex;
	}

	public void setKardex(Kardex kardex) {
		this.kardex = kardex;
	}

	public TipoMovimientoEnum getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimientoEnum tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public TipoOperacionEnum getTipoOperacionEnum() {
		return tipoOperacionEnum;
	}

	public void setTipoOperacionEnum(TipoOperacionEnum tipoOperacionEnum) {
		this.tipoOperacionEnum = tipoOperacionEnum;
	}

}
