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

import com.hulk.store.spring.enumeracion.TipoIdentificacionEnum;

@Entity
@Table(name = "Cliente")
public class Cliente  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_cliente")
	private Long id;
	
	@Column(name = "tipo_identificacion", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoIdentificacionEnum tipoIdentificacion;

	@Column(name = "numero_identificacion", length = 13, nullable = false)
	private String numeroIdentificacion;
	
	@Column(name = "nombre", length = 150, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 150, nullable = false)
	private String apellido;
		
	@Column(name = "direccion_envio", length = 250, nullable = false)
	private String direccion_envio;
	
	@Column(name = "usuario", length = 150, nullable = false)
	private String usuario;
	
	@Column(name = "contrasenia", length = 150, nullable = false)
	private String contrasenia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoIdentificacionEnum getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacionEnum tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion_envio() {
		return direccion_envio;
	}

	public void setDireccion_envio(String direccion_envio) {
		this.direccion_envio = direccion_envio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	

}
