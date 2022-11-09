package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CentralAlarmasTest {

	@Test
	public void queSePuedaCrearUnUsuarioConfigurador() {
		Integer dni = 3000;
		String nombre = "Pepe";

		Usuario usuario = new UsuarioConfigurador(dni, nombre);

		assertEquals(dni, usuario.getDni());
		assertEquals(nombre, usuario.getNombre());
	}

	@Test
	public void queSePuedaCrearUnUsuarioAdministrador() {
		Integer dni = 5000;
		String nombre = "PepeAdmin";
		Central central = new Central ("Central");

		Usuario usuario = new UsuarioAdministrador(dni, nombre, central);

		assertEquals(dni, usuario.getDni());
		assertEquals(nombre, usuario.getNombre());
	}

	@Test
	public void queSePuedaCrearUnUsuarioActivador() {
		Integer dni = 5000;
		String nombre = "PepeAdmin";

		Usuario usuario = new UsuarioActivador(dni, nombre);

		assertEquals(dni, usuario.getDni());
		assertEquals(nombre, usuario.getNombre());
	}

	@Test
	public void queSePuedaCrearUnaCentral() {
		String nombre = "CentralAlarmas";

		Central central = new Central(nombre);

		assertEquals(nombre, central.getNombre());
	}

	@Test
	public void queSePuedaCrearUnaAlarma() {
		Integer id = 1;
		String codigoActivacion = "activecode";
		String codigoConfiguracion = "configcode";
		String nombre = "Alarma1";

		Alarma alarma = new Alarma(id, codigoActivacion, codigoConfiguracion, nombre);

		assertEquals(id, alarma.getId());
		assertEquals(codigoActivacion, alarma.getCodigoActivacion());
		assertEquals(codigoConfiguracion, alarma.getCodigoConfiguracion());
		assertEquals(nombre, alarma.getNombre());
	}

	public Alarma crearAlarma(Integer id) {
		String codigoActivacion = "activecode";
		String codigoConfiguracion = "configcode";
		String nombre = "Modelo";

		return new Alarma(id, codigoActivacion, codigoConfiguracion, nombre);
	}

	@Test
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() throws CodigoAlarmaIncorrectoException {
		String nombre = "CentralAlarmas";

		Central central = new Central(nombre);

		Usuario admin = new UsuarioAdministrador(3999, "Admino", central);

		Alarma alarma = crearAlarma(1);

		Boolean valorObtenido = ((UsuarioAdministrador) admin).agregarAlarma(central, alarma,alarma.getCodigoConfiguracion());

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaRegistrarUnUsuarioALaCentral() {
		String nombre = "CentralAlarmas";

		Central central = new Central(nombre);

		Usuario admin = new UsuarioAdministrador(3999, "Admino", central);
		
		Usuario usuario = new UsuarioConfigurador(2323, "Jose");

		Boolean valorObtenido = ((UsuarioAdministrador) admin).registrarUsuarioALaCentral(central, usuario);

		assertTrue(valorObtenido);
		
		
		Integer valorEsperado2 = 1;
		Integer valorObtenido2 = central.getCantidadUsuarios();
		assertEquals(valorEsperado2, valorObtenido2);

	}

	@Test
	public void queSePuedaAgregarUnUsuarioValidoAUnaAlarma() throws CodigoAlarmaIncorrectoException {	
		Central central = new Central("CentralAlarmas");
		Usuario admin = new UsuarioAdministrador(3999, "Admino", central);
		Usuario usuario = new UsuarioConfigurador(2323, "Jose");
		Alarma alarma = crearAlarma(1);
		
		((UsuarioAdministrador) admin).agregarAlarma(central, alarma, alarma.getCodigoConfiguracion());
		((UsuarioAdministrador) admin).registrarUsuarioALaCentral(central, usuario);
		
		((UsuarioAdministrador) admin).agregarUnUsuarioALaListaDeUsuariosDeUnaAlarma(usuario.getDni(), alarma.getId(), alarma.getCodigoConfiguracion());

	}
	
	@Test
	public void queSePuedaAgregarUnSensorAUnaAlarma() throws SensorDuplicadoException, CodigoAlarmaIncorrectoException {	
		Central central = new Central("CentralAlarmas");
		Usuario admin = new UsuarioAdministrador(3999, "Admino", central);
		Usuario usuario = new UsuarioConfigurador(2323, "Jose");
		Sensor sensor = new Sensor(1);
		Alarma alarma = crearAlarma(1);
		
		((UsuarioAdministrador) admin).agregarAlarma(central, alarma, alarma.getCodigoConfiguracion());
		((UsuarioAdministrador) admin).registrarUsuarioALaCentral(central, usuario);

		
		((UsuarioAdministrador) admin).agregarSensorAUnaAlarma(alarma.getId(), alarma.getCodigoConfiguracion(), sensor);

		Integer valorEsperado = 1;
		Integer valorObtenido = alarma.getCantidadSensores();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaActivarUnSensor() throws SensorDuplicadoException, CodigoAlarmaIncorrectoException {
		Central central = new Central("CentralAlarmas");
		Usuario admin = new UsuarioAdministrador(3999, "Admino", central);
		Usuario usuario = new UsuarioConfigurador(2323, "Jose");
		Sensor sensor = new Sensor(1);
		Alarma alarma = crearAlarma(1);
		
		((UsuarioAdministrador) admin).agregarAlarma(central, alarma, alarma.getCodigoConfiguracion());
		((UsuarioAdministrador) admin).registrarUsuarioALaCentral(central, usuario);
		((UsuarioAdministrador) admin).agregarSensorAUnaAlarma(alarma.getId(), alarma.getCodigoConfiguracion(), sensor);
		
		((UsuarioAdministrador) admin).activarSensorDeUnaAlarma(sensor.getId(), alarma.getId(), alarma.getCodigoConfiguracion());
		
		assertTrue(sensor.estaActivo());
	}
	
	@Test
	public void queSePuedaActivarDesactivarUnaAlarma() throws SensorDuplicadoException, CodigoAlarmaIncorrectoException {
		Central central = new Central("CentralAlarmas");
		Usuario admin = new UsuarioAdministrador(3999, "Admino", central);
		Usuario usuario = new UsuarioConfigurador(2323, "Jose");
		Sensor sensor = new Sensor(1);
		Alarma alarma = crearAlarma(1);
		
		((UsuarioAdministrador) admin).agregarAlarma(central, alarma, alarma.getCodigoConfiguracion());
		((UsuarioAdministrador) admin).registrarUsuarioALaCentral(central, usuario);
		((UsuarioAdministrador) admin).agregarSensorAUnaAlarma(alarma.getId(), alarma.getCodigoConfiguracion(), sensor);
		((UsuarioAdministrador) admin).activarSensorDeUnaAlarma(sensor.getId(), alarma.getId(), alarma.getCodigoConfiguracion());
		((UsuarioAdministrador) admin).activarDesactivarAlarma(alarma, alarma.getCodigoActivacion());
		
		assertTrue(alarma.estaActiva());
	}

	@Test (expected = CodigoAlarmaIncorrectoException.class)
	public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlarmaIncorrectoException() throws CodigoAlarmaIncorrectoException {
		Central central = new Central("CentralAlarmas");
		Usuario admin = new UsuarioAdministrador(3999, "Admino", central);
		Usuario usuario = new UsuarioConfigurador(2323, "Jose");
		Sensor sensor = new Sensor(1);
		Alarma alarma = crearAlarma(1);
		
		((UsuarioAdministrador) admin).agregarAlarma(central, alarma, "Cualquiercosa");
	}

	@Test(expected = SensorDuplicadoException.class)
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnaSensorDuplicadoException() throws SensorDuplicadoException, CodigoAlarmaIncorrectoException {
		Central central = new Central("CentralAlarmas");
		Usuario admin = new UsuarioAdministrador(3999, "Admino", central);
		Usuario usuario = new UsuarioConfigurador(2323, "Jose");
		Sensor sensor = new Sensor(1);
		Alarma alarma = crearAlarma(1);
		
		((UsuarioAdministrador) admin).agregarAlarma(central, alarma, alarma.getCodigoConfiguracion());
		((UsuarioAdministrador) admin).registrarUsuarioALaCentral(central, usuario);
		((UsuarioAdministrador) admin).agregarSensorAUnaAlarma(alarma.getId(), alarma.getCodigoConfiguracion(), sensor);
		((UsuarioAdministrador) admin).agregarSensorAUnaAlarma(alarma.getId(), alarma.getCodigoConfiguracion(), sensor);
	}

	@Test
	public void queNoSePuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado() throws SensorDuplicadoException, CodigoAlarmaIncorrectoException {
		Central central = new Central("CentralAlarmas");
		Usuario admin = new UsuarioAdministrador(3999, "Admino", central);
		Usuario usuario = new UsuarioConfigurador(2323, "Jose");
		Sensor sensor = new Sensor(1);
		Alarma alarma = crearAlarma(1);
		
		((UsuarioAdministrador) admin).agregarAlarma(central, alarma, alarma.getCodigoConfiguracion());
		((UsuarioAdministrador) admin).registrarUsuarioALaCentral(central, usuario);
		((UsuarioAdministrador) admin).agregarSensorAUnaAlarma(alarma.getId(), alarma.getCodigoConfiguracion(), sensor);
		//((UsuarioAdministrador) admin).activarSensorDeUnaAlarma(sensor.getId(), alarma.getId(), alarma.getCodigoConfiguracion());
		((UsuarioAdministrador) admin).activarDesactivarAlarma(alarma, alarma.getCodigoActivacion());
		
		assertFalse(alarma.estaActiva());
	}

	@Test
	public void queParaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAccionesDeTipoConfiguracionOrdenadasPorIdDeAccion() {
		Central central = new Central("CentralAlarmas");
		Usuario admin = new UsuarioAdministrador(3999, "Admino", central);
		Alarma alarma = crearAlarma(1);
		
		Accion accion2 = alarma.crearAccion(3, alarma, admin, 20220911, TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(accion2);
		Accion accion1 = alarma.crearAccion(2, alarma, admin, 20220911, TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(accion1);
		Accion accion3 = alarma.crearAccion(5, alarma, admin, 20220911, TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(accion3);
		Accion accion4 = alarma.crearAccion(6, alarma, admin, 20220911, TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(accion4);
		Accion accion5 = alarma.crearAccion(13, alarma, admin, 20220911, TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(accion5);
		
		List<Accion> accionesOrdenadas = new ArrayList<>();
		
		accionesOrdenadas.add(accion1);
		accionesOrdenadas.add(accion2);
		accionesOrdenadas.add(accion3);
		accionesOrdenadas.add(accion4);
		accionesOrdenadas.add(accion5);
		
		List<Accion> accionesObtenidas = new ArrayList<>();
		
		accionesObtenidas.addAll(alarma.getAcciones());
		
		assertEquals(accionesOrdenadas, accionesObtenidas);
		
		//Mil disculpas por no implementar de forma correcta la coleccion de acciones, 
		//este test es solo para demostrar que sé utilizar TreeSet y la interfaz Comparable para ordenarla
		
	}

}
