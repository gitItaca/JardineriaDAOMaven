package JardineriaDAOMaven.JardineriaDAOMaven.model.builder;

import static org.junit.Assert.*;

import org.junit.Test;

import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongEmailException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongFirstLastLetterNIEException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongLastLetterDNIException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongLengthDocumentException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongNeedNumberDNIException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongNeedNumberNIEException;
import JardineriaDAOMaven.JardineriaDAOMaven.model.Cliente;
import JardineriaDAOMaven.JardineriaDAOMaven.utils.OperacionesCliente;

public class OperacionesClientesTest {

//Email tests
	@Test 
	public void orderEmailNegative_shouldNotWork() {
		try {
			OperacionesCliente.crearCliente(16, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.NIE, "E1856541C", "fedgmail.com", "prueba");
		}catch (Exception e) {
			assertTrue(e instanceof WrongEmailException);
			return;
		}
		fail("Exception not Thrown");
	}
	
	@Test
	public void orderEmailPositive_shouldWork() {
		Cliente testCliente = null;
		try {
			testCliente = OperacionesCliente.crearCliente(16, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.NIE, "E1856541C", "fed@gmail.com", "prueba");
		}catch (Exception e) {
			fail("This must not happen");
		}
		assertNotNull(testCliente);
	}
	
//DNI/NIE tests
	@Test
	public void orderDNILengthNegative_shouldNotWork() {
		try {
			OperacionesCliente.crearCliente(17, "Tod", "Fod", "953321321", 
					Cliente.Documentacion.DNI, "9185116541C", "tod@gmail.com", "prueba");
		}catch (Exception e) {
			assertTrue(e instanceof WrongLengthDocumentException);
			return;
		}
		fail("Exception not Thrown");
	}
	
	@Test
	public void orderDNILengthPositive_shouldWork() {
		Cliente testCliente = null;
		try {
			testCliente = OperacionesCliente.crearCliente(16, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.DNI, "11856541C", "fed@gmail.com", "prueba");
		}catch (Exception e) {
			fail("This must not happen");
		}
		assertNotNull(testCliente);
	}
	
	@Test
	public void orderLastLetterDNINegative_shouldNotWork() {
		try {
			OperacionesCliente.crearCliente(17, "Tod", "Fod", "953321321", 
					Cliente.Documentacion.DNI, "918565414", "tod@gmail.com", "prueba");
		}catch (Exception e) {
			assertTrue(e instanceof WrongLastLetterDNIException);
			return;
		}
		fail("Exception not Thrown");
	}
	
	@Test
	public void orderLastLetterDNIPositive_shouldWork() {
		Cliente testCliente = null;
		try {
			testCliente = OperacionesCliente.crearCliente(16, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.DNI, "11856541C", "fed@gmail.com", "prueba");
		}catch (Exception e) {
			fail("This must not happen");
		}
		assertNotNull(testCliente);
	}

	@Test
	public void orderNumbersDNINegative_shouldNotWork() {
		try {
			OperacionesCliente.crearCliente(17, "Tod", "Fod", "953321321", 
					Cliente.Documentacion.DNI, "918A6541C", "tod@gmail.com", "prueba");
		}catch (Exception e) {
			assertTrue(e instanceof WrongNeedNumberDNIException);
			return;
		}
		fail("Exception not Thrown");
	}
	
	@Test
	public void orderNumbersDNIPositive_shouldWork() {
		Cliente testCliente = null;
		try {
			testCliente = OperacionesCliente.crearCliente(16, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.DNI, "11856541C", "fed@gmail.com", "prueba");
		}catch (Exception e) {
			fail("This must not happen");
		}
		assertNotNull(testCliente);
	}
	
	@Test
	public void orderFirstLastLetterNIENegative_shouldNotWork() {
		try {
			OperacionesCliente.crearCliente(17, "Tod", "Fod", "953321321", 
					Cliente.Documentacion.NIE, "918A6541C", "tod@gmail.com", "prueba");
		}catch (Exception e) {
			assertTrue(e instanceof WrongFirstLastLetterNIEException);
			return;
		}
		fail("Exception not Thrown");
	}
	
	@Test
	public void orderFirstLastLetterNIEPositive_shouldWork() {
		Cliente testCliente = null;
		try {
			testCliente = OperacionesCliente.crearCliente(16, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.NIE, "A1856541C", "fed@gmail.com", "prueba");
		}catch (Exception e) {
			fail("This must not happen");
		}
		assertNotNull(testCliente);
	}

	@Test
	public void orderNumbersNIENegative_shouldNotWork() {
		try {
			OperacionesCliente.crearCliente(17, "Tod", "Fod", "953321321", 
					Cliente.Documentacion.NIE, "A18A6R41C", "tod@gmail.com", "prueba");
		}catch (Exception e) {
			assertTrue(e instanceof WrongNeedNumberNIEException);
			return;
		}
		fail("Exception not Thrown");
	}
	
	@Test
	public void orderNumbersNIEPositive_shouldWork() {
		Cliente testCliente = null;
		try {
			testCliente = OperacionesCliente.crearCliente(16, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.NIE, "A1856541C", "fed@gmail.com", "prueba");
		}catch (Exception e) {
			fail("This must not happen");
		}
		assertNotNull(testCliente);
	}
}
