package com.hulk.store.spring.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad Documento: almacena el encabezado del comprobante de venta
 * 
 * @author avfloresp
 *
 */

@Entity
@Table(name = "Documento")
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_documento")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "codigo_cliente", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "codigo_forma_pago", nullable = false)
	private FormaPago formaPago;

	@Column(name = "numero_documento", length = 15, nullable = false)
	private String numeroDocumento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_emision", nullable = false)
	private Date fechaEmision;

	@Column(name = "direccion", length = 100, nullable = false)
	private String direccion;

	@Column(name = "subtotal_pago", nullable = false, precision = 15, scale = 4)
	private BigDecimal subtotalPago;

	@Column(name = "impuesto_valor_agregado", nullable = false, precision = 15, scale = 4)
	private BigDecimal impuestoValorAgregado;

	@Column(name = "total_pago", nullable = false, precision = 15, scale = 4)
	private BigDecimal totalPago;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documento", cascade = CascadeType.ALL)
	private List<DocumentoDetalle> detalle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getSubtotalPago() {
		return subtotalPago;
	}

	public void setSubtotalPago(BigDecimal subtotalPago) {
		this.subtotalPago = subtotalPago;
	}

	public BigDecimal getImpuestoValorAgregado() {
		return impuestoValorAgregado;
	}

	public void setImpuestoValorAgregado(BigDecimal impuestoValorAgregado) {
		this.impuestoValorAgregado = impuestoValorAgregado;
	}

	public BigDecimal getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(BigDecimal totalPago) {
		this.totalPago = totalPago;
	}

	public List<DocumentoDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DocumentoDetalle> detalle) {
		this.detalle = detalle;
	}

}
