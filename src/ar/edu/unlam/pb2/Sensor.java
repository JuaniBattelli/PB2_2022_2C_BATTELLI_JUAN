package ar.edu.unlam.pb2;

import java.util.Objects;

public class Sensor  {

	private Integer id;
	private Boolean estado;
	
	public Sensor(Integer id) {
		this.id = id;
		this.estado = false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return this.id;
	}

	public void activarDesactivar() {
		if(estado == false) {
			estado = true;
		}else {
			estado = false;
		}
	}

	public Boolean estaActivo() {
		return this.estado;
	}


	
}
