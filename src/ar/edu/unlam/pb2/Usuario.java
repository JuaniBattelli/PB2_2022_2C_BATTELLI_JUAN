package ar.edu.unlam.pb2;

public abstract class Usuario {

	protected Central central;
	private Integer dni;
	private String nombre;
	
	public Usuario(Integer dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.central = null;
	}
	
	public Usuario(Integer dni, String nombre, Central central) {
		this.dni = dni;
		this.nombre = nombre;
		this.central = central;
	}
	
	public void setCentral(Central central) {
		this.central = central;
	}
	
	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}


	
}
