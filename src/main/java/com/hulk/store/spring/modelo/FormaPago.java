package com.hulk.store.spring.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hulk.store.spring.enumeracion.EstadoRegistroEnum;

/**
 *  Entidad Forma_Pago: almacena las formas de pago
 *  
 * @author avfloresp
 *
 */
@Entity
@Table(name = "Forma_Pago")
public class FormaPago implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_forma_pago")
	private Long id;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@Column(name = "descripcion", length = 150, nullable = true)
	private String descripcion;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoRegistroEnum estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoRegistroEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoRegistroEnum estado) {
		this.estado = estado;
	}
	
	
}
