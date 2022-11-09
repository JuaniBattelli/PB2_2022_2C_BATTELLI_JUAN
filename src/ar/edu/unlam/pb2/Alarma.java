package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Alarma {
	
	private Integer id;
	private String codigoActivacion;
	private String codigoConfiguracion;
	private String nombre;
	
	private Set<Usuario> usuariosOperadores;
	private Set<Sensor> sensores;
	private List<Accion> acciones;

	public Alarma(Integer id, String codigoActivacion, String codigoConfiguracion, String nombre) {
		this.id = id;
		this.codigoActivacion = codigoActivacion;
		this.codigoConfiguracion = codigoConfiguracion;
		this.nombre = nombre;
		this.usuariosOperadores = new HashSet<>();
		this.sensores = new HashSet<>();
		this.acciones = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public String getCodigoActivacion() {
		return codigoActivacion;
	}

	public String getCodigoConfiguracion() {
		return codigoConfiguracion;
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean agregarUsuarioValido(Usuario usuario) {
		return usuariosOperadores.add(usuario);
	}

	public Integer getCantidadUsuariosOperadores() {
		return usuariosOperadores.size();
	}

	
	
}
