package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Alarma {

	private Integer id;
	private String codigoActivacion;
	private String codigoConfiguracion;
	private String nombre;
	private Boolean estado;

	private Set<Usuario> usuariosValidos;
	private Set<Sensor> sensores;
	private Set<Accion> acciones;

	public Alarma(Integer id, String codigoActivacion, String codigoConfiguracion, String nombre) {
		this.id = id;
		this.codigoActivacion = codigoActivacion;
		this.codigoConfiguracion = codigoConfiguracion;
		this.nombre = nombre;
		this.usuariosValidos = new HashSet<>();
		this.sensores = new HashSet<>();
		this.acciones = new TreeSet<>();
		this.estado = false;
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

	public Boolean agregarUsuarioValido(Usuario usuario, String codeConfig) {

		if (usuariosValidos.add(usuario)) {
			acciones.add(crearAccion(acciones.size()+1, this, usuario, 20220911,  TipoDeOperacion.CONFIGURACION));
			return true;
		}

		return false;
	}
	
	public void agregarAccion(Accion accion) {
		acciones.add(accion);
	}

	public Accion crearAccion(Integer id, Alarma alarma, Usuario usuario, Integer fecha, TipoDeOperacion tipo) {
		return new Accion(id, alarma, usuario, fecha, tipo);
		
	}

	private Usuario obtenerUsuarioPorDni(Integer dniUsuario) {
		for (Usuario usuario : usuariosValidos) {
			if (usuario.getDni().equals(dniUsuario)) {
				return usuario;
			}
		}
		return null;
	}

	private Boolean validarCodigoConfiguracion(String codeConfig) {
		if (this.codigoConfiguracion.equals(codeConfig)) {
			return true;
		}
		return false;
	}

	private Boolean validarUsuario(Integer dniUsuario) {
		for (Usuario usuario : usuariosValidos) {
			if (usuario.getDni().equals(dniUsuario)) {
				return true;
			}
		}
		return false;
	}

	public Integer getCantidadUsuariosOperadores() {
		return usuariosValidos.size();
	}

	public Boolean agregarSensor(Sensor sensor) {
		return sensores.add(sensor);
		
	}

	public void activarSensor(Integer idSensor) {
		for (Sensor sensor : sensores) {
			if(sensor.getId().equals(idSensor)) {
				sensor.activarDesactivar();
			}
		}
		
	}

	public Integer getCantidadSensores() {
		return sensores.size();
	}

	public Boolean activarDesactivar() {
		for(Sensor sensor : sensores) {
			if(!sensor.estaActivo()) {
				return false;
			}
		}
		this.estado = true;
		return true;
		
	}

	public Boolean estaActiva() {
		// TODO Auto-generated method stub
		return this.estado;
	}

	public Set<Accion> getAcciones() {
		return acciones;
	}

}
