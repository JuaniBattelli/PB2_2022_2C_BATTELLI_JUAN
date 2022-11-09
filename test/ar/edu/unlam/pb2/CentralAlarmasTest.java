package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

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

		Usuario usuario = new UsuarioAdministrador(dni, nombre);

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
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() {
		String nombre = "CentralAlarmas";

		Central central = new Central(nombre);

		Usuario admin = new UsuarioAdministrador(3999, "Admino");

		Alarma alarma = crearAlarma(1);

		Boolean valorObtenido = admin.agregarAlarma(central, alarma);

		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaRegistrarUnUsuarioALaCentral() {
		String nombre = "CentralAlarmas";

		Central central = new Central(nombre);

		Usuario admin = new UsuarioAdministrador(3999, "Admino");
		
		Usuario usuario = new UsuarioConfigurador(2323, "Jose");

		Boolean valorObtenido = admin.registrarUsuarioALaCentral(central, usuario);

		assertTrue(valorObtenido);

	}

	@Test
	public void queSePuedaAgregarUnUsuarioValidoAUnaAlarma() {	
		Usuario admin = new UsuarioAdministrador(3999, "Admino");
		Usuario usuario = new UsuarioConfigurador(2323, "Jose");
		Alarma alarma = crearAlarma(1);

		Boolean valorObtenido = admin.agregarUsuarioValidoAUnaAlarma(usuario.getDni(), alarma.getId(), alarma.getCodigoConfiguracion());

		assertTrue(valorObtenido);

	}

	@Test
	public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlarmaIncorrectoException() {
		fail("Not yet implemented");
	}

	@Test
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnaSensorDuplicadoException() {
		fail("Not yet implemented");
	}

	@Test
	public void queNoSePuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado() {
		fail("Not yet implemented");
	}

	@Test
	public void queParaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAccionesDeTipoConfiguracionOrdenadasPorIdDeAccion() {
		fail("Not yet implemented");
	}

}
