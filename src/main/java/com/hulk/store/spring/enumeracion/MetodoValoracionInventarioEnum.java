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
public enum MetodoValoracionInventarioEnum {
	PP("Promedio ponderado"), 
	FIFO("Primero en entrar primero en salir");

	private String descripcion;

	private MetodoValoracionInventarioEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

}
