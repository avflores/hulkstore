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

import com.hulk.store.spring.enumeracion.EstadoRegistroEnum;
import com.hulk.store.spring.enumeracion.MetodoValoracionInventarioEnum;

/**
 * Entidad Producto, almacena los productos de la tienda
 * 
 * @author avfloresp
 *
 */

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_producto")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "codigo_marca", nullable = false)
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "codigo_grupo", nullable = false)
	private Grupo grupo;

	@Enumerated(EnumType.STRING)
	@Column(name = "metodo_valoracion_inventario")
	private MetodoValoracionInventarioEnum metodoValoracionInventario;

	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@Column(name = "cantidad_minima")
	private Integer cantidadMinima;

	@Column(name = "cantidad_maxima")
	private Integer cantidadMaxima;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ingreso", nullable = false)
	private Date fechaIngreso;

	@Column(name = "utilidad_porcentaje")
	private Integer utilidad_porcentaje;

	@Column(name = "existencia")
	private Integer existencia;

	@Column(name = "precio_metodo_valoracion", precision = 15, scale = 4, nullable = false)
	private BigDecimal precioMetodoValoracion;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoRegistroEnum estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public Integer getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(Integer cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public Integer getExistencia() {
		return existencia;
	}

	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getUtilidad_porcentaje() {
		return utilidad_porcentaje;
	}

	public void setUtilidad_porcentaje(Integer utilidad_porcentaje) {
		this.utilidad_porcentaje = utilidad_porcentaje;
	}

	public EstadoRegistroEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoRegistroEnum estado) {
		this.estado = estado;
	}

	public MetodoValoracionInventarioEnum getMetodoValoracionInventario() {
		return metodoValoracionInventario;
	}

	public void setMetodoValoracionInventario(MetodoValoracionInventarioEnum metodoValoracionInventario) {
		this.metodoValoracionInventario = metodoValoracionInventario;
	}

	public BigDecimal getPrecioMetodoValoracion() {
		return precioMetodoValoracion;
	}

	public void setPrecioMetodoValoracion(BigDecimal precioMetodoValoracion) {
		this.precioMetodoValoracion = precioMetodoValoracion;
	}

}
