package ar.edu.unlam.pb2;

public abstract class Usuario {

	private Integer dni;
	private String nombre;
	
	public Usuario(Integer dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean agregarAlarma(Central central, Alarma alarma) {
		return central.registrarAlarma(alarma);	
	}

	public Boolean registrarUsuarioALaCentral(Central central, Usuario usuario) {
		return central.agregarUsuario(usuario);
	}

	public Boolean agregarUsuarioValidoAUnaAlarma(Alarma alarma, Usuario usuario) {
		return alarma.agregarUsuarioValido(usuario);
	}
	
}
