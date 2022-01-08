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
public enum TipoIdentificacionEnum {
	DNI("Documento nacional identidad"), 
	PASS("Pasaporte");

	private String descripcion;

	private TipoIdentificacionEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

}
