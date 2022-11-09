package ar.edu.unlam.pb2;

public class UsuarioAdministrador extends Usuario implements IActivable, IConfigurable {

	public UsuarioAdministrador(Integer dni, String nombre, Central central) {
		super(dni, nombre, central);
	}

	public Boolean agregarAlarma(Central central, Alarma alarma, String configCode)
			throws CodigoAlarmaIncorrectoException {

		if (alarma.getCodigoConfiguracion().equals(configCode)) {
			return central.registrarAlarma(alarma);
		} else throw new CodigoAlarmaIncorrectoException("Codigo Incorrecto");
	}

	public Boolean registrarUsuarioALaCentral(Central central, Usuario usuario) {
		return central.agregarUsuario(usuario);
	}

	@Override
	public void agregarUnUsuarioALaListaDeUsuariosDeUnaAlarma(Integer dniUsuario, Integer idAlarma, String configCode)
			throws CodigoAlarmaIncorrectoException {
		if (central.obtenerAlarmaPorId(idAlarma).getCodigoConfiguracion().equals(configCode)) {
			central.obtenerAlarmaPorId(idAlarma).agregarUsuarioValido(central.obtenerUsuarioPorDni(dniUsuario),
					configCode);
		} else {
			throw new CodigoAlarmaIncorrectoException("Codigo de Configuracion incorrecto");
		}

	}

	@Override
	public void agregarSensorAUnaAlarma(Integer idAlarma, String configCode, Sensor sensor)
			throws SensorDuplicadoException {
		if (central.obtenerAlarmaPorId(idAlarma).getCodigoConfiguracion().equals(configCode)) {
			if (central.obtenerAlarmaPorId(idAlarma).agregarSensor(sensor)) {
				return;
			}
			throw new SensorDuplicadoException("Sensor ya existente");
		}

	}

	@Override
	public void activarSensorDeUnaAlarma(Integer idSensor, Integer idAlarma, String configCode) {
		if (central.obtenerAlarmaPorId(idAlarma).getCodigoConfiguracion().equals(configCode)) {
			central.obtenerAlarmaPorId(idAlarma).activarSensor(idSensor);
		}
	}

	@Override
	public Boolean activarDesactivarAlarma(Alarma alarma, String activeCode) {
		if (alarma.getCodigoActivacion().equals(activeCode)) {
			return alarma.activarDesactivar();
		} else
			return false;
	}

}
