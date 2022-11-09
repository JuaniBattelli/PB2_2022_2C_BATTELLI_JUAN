package ar.edu.unlam.pb2;

public class UsuarioConfigurador extends Usuario implements IConfigurable {

	public UsuarioConfigurador(Integer dni, String nombre) {
		super(dni, nombre);
	}

	@Override
	public void agregarUnUsuarioALaListaDeUsuariosDeUnaAlarma(Integer dni, Integer idAlarma, String configCode)
			throws CodigoAlarmaIncorrectoException {
		if(central.obtenerAlarmaPorId(idAlarma).getCodigoConfiguracion().equals(configCode)) {
			central.obtenerAlarmaPorId(idAlarma).agregarUsuarioValido(central.obtenerUsuarioPorDni(dni), configCode);
		} else {
			throw new CodigoAlarmaIncorrectoException("Codigo de Configuracion incorrecto");
		}
		
	}

	@Override
	public void agregarSensorAUnaAlarma(Integer idAlarma, String configCode, Sensor sensor)
			throws SensorDuplicadoException {
		if(central.obtenerAlarmaPorId(idAlarma).getCodigoConfiguracion().equals(configCode)) {
			if(central.obtenerAlarmaPorId(idAlarma).agregarSensor(sensor)) {
				return;
			}
			throw new SensorDuplicadoException("Sensor ya existente");
		}
		
	}

	@Override
	public void activarSensorDeUnaAlarma(Integer idSensor, Integer idAlarma, String configCode) {
		if(central.obtenerAlarmaPorId(idAlarma).getCodigoConfiguracion().equals(configCode)) {
			central.obtenerAlarmaPorId(idAlarma).activarSensor(idSensor); 		
		} 
		
	}

	
	
}
