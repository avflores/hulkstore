package com.hulk.store.spring.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hulk.store.spring.enumeracion.EstadoRegistroEnum;

/**
 * Entidad Documento_Detalle: almacena el detalle del comprobante de venta
 * 
 * @author avfloresp
 *
 */

@Entity
@Table(name = "Documento_Detalle")
public class DocumentoDetalle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_documento_detalle")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "codigo_documento")
	//@JsonIgnore
	private Documento documento;

	@ManyToOne
	@JoinColumn(name = "codigo_producto", nullable = false)
	private Producto producto;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "precio_unitario")
	private BigDecimal precioUnitario;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoRegistroEnum estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public EstadoRegistroEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoRegistroEnum estado) {
		this.estado = estado;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}
