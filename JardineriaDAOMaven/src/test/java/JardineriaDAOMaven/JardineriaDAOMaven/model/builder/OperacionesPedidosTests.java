package JardineriaDAOMaven.JardineriaDAOMaven.model.builder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import JardineriaDAOMaven.JardineriaDAOMaven.dao.ClienteDao;
import JardineriaDAOMaven.JardineriaDAOMaven.dao.PedidoDao;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.ClientNotFoundException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongFechaMinimaPedidoException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongOrderDayCreationException;
import JardineriaDAOMaven.JardineriaDAOMaven.model.Cliente;
import JardineriaDAOMaven.JardineriaDAOMaven.model.Pedido;
import JardineriaDAOMaven.JardineriaDAOMaven.utils.OperacionesCliente;
import JardineriaDAOMaven.JardineriaDAOMaven.utils.OperacionesPedido;

public class OperacionesPedidosTests {
	Calendar today = new GregorianCalendar();
	ClienteDao cDao = new ClienteDao();
	PedidoDao pDao = new PedidoDao();
	
	public void CrearCliente(int id, String nombre, String tlf) {		//Creo un cliente para poder meterle los pedidos, si no salta error.
		
		try {
			cDao.save(OperacionesCliente.crearCliente(id, nombre, "Galban", tlf, 
					Cliente.Documentacion.DNI, "18565412A", "paco@gmail.com", "prueba"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	@Test
	public void orderPedidoHoyNegative_shouldNotWork() {
		CrearCliente(11, "Paco", "654321321");
		Calendar day1 = new GregorianCalendar();	
		Calendar day2 = new GregorianCalendar();
		day1.add(Calendar.DAY_OF_MONTH, 4);
		day2.add(Calendar.DAY_OF_MONTH, 6);
		
		try {
			OperacionesPedido.crearPedido(11, day1, day1, day2, 11);
		}catch (Exception e) {
			assertTrue(e instanceof WrongOrderDayCreationException);
			return;
		}
		fail("Exception not Thrown");
	}
	
	@Test
	public void orderPedidoHoyPositive_shouldWork() {
		CrearCliente(12, "Luis", "954321321");
		Pedido testPedido = null;
		Calendar day1 = new GregorianCalendar();	
		Calendar day2 = new GregorianCalendar();
		day1.add(Calendar.DAY_OF_MONTH, 4);
		day2.add(Calendar.DAY_OF_MONTH, 6);
		try {
			testPedido = OperacionesPedido.crearPedido(12, today, day1, day2, 12);
		}catch (Exception e) {
			fail("This must not happen");
		}
		assertNotNull(testPedido);
	}

	@Test
	public void orderPedidoFechaMinimaEsperadaNegative_shouldNotWork() {
		CrearCliente(13, "Sofia", "664921321");
		Calendar day1 = new GregorianCalendar();	
		Calendar day2 = new GregorianCalendar();
		day1.add(Calendar.DAY_OF_MONTH, 1);		//Pongo la fecha esperada un dia despues de la fecha del pedido para que me salte la excepcion.
		day2.add(Calendar.DAY_OF_MONTH, 6);
		try {
			OperacionesPedido.crearPedido(13, today, day1, day2, 13);
		}catch (Exception e) {
			assertTrue(e instanceof WrongFechaMinimaPedidoException);
			return;
		}
		fail("Exception not Thrown");
	}
	
	@Test
	public void orderPedidoFechaMinimaEsperadaPositive_shouldWork() {
		CrearCliente(14, "Maria", "664321321");
		Pedido testPedido = null;
		Calendar day1 = new GregorianCalendar();	
		Calendar day2 = new GregorianCalendar();
		day1.add(Calendar.DAY_OF_MONTH, 4);
		day2.add(Calendar.DAY_OF_MONTH, 6);
		try {
			testPedido = OperacionesPedido.crearPedido(14, today, day1, day2, 14);
		}catch (Exception e) {
			fail("This must not happen");
		}
		assertNotNull(testPedido);
	}

	@Test
	public void orderClientNotFoundNegative_shouldNotWork() {
		Calendar day1 = new GregorianCalendar();	
		Calendar day2 = new GregorianCalendar();
		day1.add(Calendar.DAY_OF_MONTH, 4);
		day2.add(Calendar.DAY_OF_MONTH, 6);
		
		try {
			OperacionesPedido.crearPedido(11, today, day1, day2, 20);
		}catch (Exception e) {
			assertTrue(e instanceof ClientNotFoundException);
			return;
		}
		fail("Exception not Thrown");
	}
	
	@Test
	public void orderClientNotFoundPositive_shouldWork() {
		CrearCliente(15, "Mimi", "954321451");
		Pedido testPedido = null;
		Calendar day1 = new GregorianCalendar();	
		Calendar day2 = new GregorianCalendar();
		day1.add(Calendar.DAY_OF_MONTH, 4);
		day2.add(Calendar.DAY_OF_MONTH, 6);
		try {
			testPedido = OperacionesPedido.crearPedido(12, today, day1, day2, 15);
		}catch (Exception e) {
			fail("This must not happen");
		}
		assertNotNull(testPedido);
	}


}
