package ar.edu.unlam.pb2;

public class UsuarioActivador extends Usuario implements IActivable {

	public UsuarioActivador(Integer dni, String nombre) {
		super(dni, nombre);
	}

	@Override
	public Boolean activarDesactivarAlarma(Alarma alarma, String activeCode) {
		if (alarma.getCodigoActivacion().equals(activeCode)) {
			return alarma.activarDesactivar();
		} else
			return false;
	}

}
