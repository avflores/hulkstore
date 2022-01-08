/**
 * 
 */
package com.hulk.store.spring.enumeracion;

/**
 * Enumeracion de estados de registro
 * 
 * @author macbook
 *
 */
public enum TipoMovimientoEnum {
	ENT("Entrada"), 
	SAL("Salida");

	private String descripcion;

	private TipoMovimientoEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

}
