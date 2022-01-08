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
public enum EstadoRegistroEnum {
	ACT("Activo"), 
	INA("Inactivo");

	private String descripcion;

	private EstadoRegistroEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

}
