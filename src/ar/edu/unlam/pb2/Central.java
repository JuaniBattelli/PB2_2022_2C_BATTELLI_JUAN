package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Central {

	private String nombre;
	private Set<Alarma> alarmas;
	private Set<Usuario> usuarios;
	
	public Central(String nombre) {
		this.nombre = nombre;
		this.alarmas = new HashSet<>();
		this.usuarios = new HashSet<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public Boolean registrarAlarma(Alarma alarma) {
		return alarmas.add(alarma);	
	}
	
	public Integer getCantidadAlarmas() {
		return alarmas.size();
	}
	
	public Boolean agregarUsuario(Usuario usuario) {
		return usuarios.add(usuario);
	}

	public Alarma buscarAlarmaPorId(Integer idAlarma) {
		for (Alarma alarma : alarmas) {
			if(alarma.getId().equals(idAlarma)) {
				return alarma;
			}
		} return null;
	}

	public Usuario obtenerUsuarioPorDni(Integer dniUsuario) {
		for (Usuario usuario : usuarios) {
			if (usuario.getDni().equals(dniUsuario)) {
				return usuario;
			}
		}
		return null;
	}

	public Integer getCantidadUsuarios() {
		return usuarios.size();
	}

	public Alarma obtenerAlarmaPorId(Integer idAlarma) {
		for (Alarma alarma : alarmas) {
			if (alarma.getId().equals(idAlarma)) {
				return alarma;
			}
		}
		return null;
	}
	
	
}
