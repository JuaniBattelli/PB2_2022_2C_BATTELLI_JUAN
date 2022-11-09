package ar.edu.unlam.pb2;

public interface IConfigurable {

	public void agregarUnUsuarioALaListaDeUsuariosDeUnaAlarma(Integer dni, Integer idAlarma, String configCode) throws CodigoAlarmaIncorrectoException;
	
	public void agregarSensorAUnaAlarma(Integer idAlarma, String configCode, Sensor sensor) throws SensorDuplicadoException;
	
	public void activarSensorDeUnaAlarma(Integer idSensor, Integer idAlarma, String configCode);
	
}
