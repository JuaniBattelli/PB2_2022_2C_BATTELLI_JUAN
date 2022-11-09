package ar.edu.unlam.pb2;

public class UsuarioConfigurador extends Usuario implements IConfigurable {

	public UsuarioConfigurador(Integer dni, String nombre) {
		super(dni, nombre);
	}

	@Override
	public void agregarUnUsuarioALaListaDeUsuariosDeUnaAlarma(Integer dni, Integer idAlarma, String configCode)
			throws CodigoAlarmaIncorrectoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarSensorAUnaAlarma(Integer idAlarma, String configCode, Sensor sensor)
			throws SensorDuplicadoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void activarSensorDeUnaAlarma(Integer idSensor, Integer idAlarma, String configCode) {
		// TODO Auto-generated method stub

	}

}
