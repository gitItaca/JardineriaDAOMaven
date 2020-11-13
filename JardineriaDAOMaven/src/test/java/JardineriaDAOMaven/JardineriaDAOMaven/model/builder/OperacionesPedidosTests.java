package JardineriaDAOMaven.JardineriaDAOMaven.model.builder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongOrderDayCreationException;
import JardineriaDAOMaven.JardineriaDAOMaven.model.Pedido;
import JardineriaDAOMaven.JardineriaDAOMaven.utils.OperacionesPedido;

public class OperacionesPedidosTests {

	@Test
	public void orderPedidoHoyNegative_shouldNotWork() {
		try {
			
		}catch (Exception e) {
			assertTrue(e instanceof WrongOrderDayCreationException);
			return;
		}
		fail("Exception not Thrown");
	}
	
	@Test
	public void orderPedidoHoyPositive_shouldWork() {
		Pedido testPedido = null;
		try {
			//testPedido = OperacionesPedido.crearPedido(id_pedido, f_pedido, f_esperada, f_entrega, id_cliente);
		}catch (Exception e) {
			fail("This must not happen");
		}
		assertNotNull(testPedido);
	}
}
