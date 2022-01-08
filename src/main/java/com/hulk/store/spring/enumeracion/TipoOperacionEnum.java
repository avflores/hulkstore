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
public enum TipoOperacionEnum {
	ECOM("Compra"), 
	EDEV("Devolucion en venta"), 
	SVEN("Venta"), 
	SDCO("Devolucion en compra"),
	INVI("Inventario inicial");

	private String descripcion;

	private TipoOperacionEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

}
