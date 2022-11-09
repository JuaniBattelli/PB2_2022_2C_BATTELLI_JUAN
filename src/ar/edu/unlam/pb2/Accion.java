package ar.edu.unlam.pb2;

import java.util.Date;

public class Accion implements Comparable<Accion> {
	
	Integer id;
	Alarma alarma;
	Usuario usuario;
	Integer fechaDeOperacion;
	TipoDeOperacion tipoDeOperacion;

	public Accion(Integer id, Alarma alarma, Usuario usuario, Integer fecha, TipoDeOperacion tipo) {
		this.id = id;
		this.alarma = alarma;
		this.usuario = usuario;
		this.fechaDeOperacion = fecha;
		this.tipoDeOperacion = tipo;
	}

	@Override
	public int compareTo(Accion o) {
		return this.id.compareTo(o.getId());
	}

	private Integer getId() {
		return this.id;
	}
	
	
}
