package com.hulk.store.spring.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hulk.store.spring.enumeracion.TipoMovimientoEnum;
import com.hulk.store.spring.enumeracion.TipoOperacionEnum;

/**
 * Entidad Kardex: almacena las entradas y salidas de la mercaderia
 * 
 * @author avfloresp
 *
 */

@Entity
@Table(name = "kardex")
public class Kardex implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_kardex")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "codigo_producto")
	private Producto producto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "concepto", length = 200, nullable = false)
	private String concepto;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_movimiento")
	private TipoMovimientoEnum tipoMovimiento;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_operacion")
	private TipoOperacionEnum tipoOperacion;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "precio_unitario", precision = 15, scale = 4, nullable = false)
	private BigDecimal precioUnitario;

	@Column(name = "cantidad_existencia")
	private Integer cantidadExistencia;

	@Column(name = "precio_unitario_existencia", precision = 15, scale = 4, nullable = false)
	private BigDecimal precioUnitarioExistencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public TipoMovimientoEnum getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimientoEnum tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
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

	public Integer getCantidadExistencia() {
		return cantidadExistencia;
	}

	public void setCantidadExistencia(Integer cantidadExistencia) {
		this.cantidadExistencia = cantidadExistencia;
	}

	public BigDecimal getPrecioUnitarioExistencia() {
		return precioUnitarioExistencia;
	}

	public void setPrecioUnitarioExistencia(BigDecimal precioUnitarioExistencia) {
		this.precioUnitarioExistencia = precioUnitarioExistencia;
	}

	public TipoOperacionEnum getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacionEnum tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
