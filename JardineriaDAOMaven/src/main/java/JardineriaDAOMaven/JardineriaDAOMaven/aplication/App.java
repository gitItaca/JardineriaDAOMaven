package JardineriaDAOMaven.JardineriaDAOMaven.aplication;

import java.util.Calendar;
import java.util.GregorianCalendar;

import JardineriaDAOMaven.JardineriaDAOMaven.dao.ClienteDao;
import JardineriaDAOMaven.JardineriaDAOMaven.dao.PedidoDao;
import JardineriaDAOMaven.JardineriaDAOMaven.model.Cliente;
import JardineriaDAOMaven.JardineriaDAOMaven.model.Pedido;
import JardineriaDAOMaven.JardineriaDAOMaven.utils.OperacionesCliente;
import JardineriaDAOMaven.JardineriaDAOMaven.utils.OperacionesPedido;

public class App {

	public static void main(String[] args) {

		/*ClienteDao cDao = new ClienteDao();
		
		try { //Bien + Numero de digitos del DNI incorrectos.
			cDao.save(OperacionesCliente.crearCliente(11, "Paco", "Galban", "654321321", 
					Cliente.Documentacion.DNI, "18565412A", "paco@gmail.com", "prueba"));
			cDao.save(OperacionesCliente.crearCliente(12, "Sonia", "Galban", "650321321", 
					Cliente.Documentacion.DNI, "185651412A", "prueba", "prueba"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try { //El ultimo digito tiene que ser una letra, la 'ñ' esta excluida.
			cDao.save(OperacionesCliente.crearCliente(13, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.DNI, "185651411", "fed@gmail.com", "prueba"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try { //El digito nº 6 tiene que ser un numero.
			cDao.save(OperacionesCliente.crearCliente(14, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.DNI, "18565C41C", "fed@gmail.com", "prueba"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {  //Bien + El primer digito y el ultimo tienen que ser una letra, la 'ñ' esta excluida.
			cDao.save(OperacionesCliente.crearCliente(15, "Tod", "Fod", "984321321", 
					Cliente.Documentacion.NIE, "B8565141C", "tod@gmail.com", "prueba"));
			cDao.save(OperacionesCliente.crearCliente(16, "Melissa", "Troc", "984111321", 
					Cliente.Documentacion.NIE, "18565141C", "melissa@gmail.com", "prueba"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try { //El digito nº 6 tiene que ser un numero.
			cDao.save(OperacionesCliente.crearCliente(16, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.NIE, "E8565C41C", "fed@gmail.com", "prueba"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try { //Numero de digitos del NIE incorrectos.
			cDao.save(OperacionesCliente.crearCliente(16, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.NIE, "E18565C41C", "fed@gmail.com", "prueba"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try { //Email incorrecto.
			cDao.save(OperacionesCliente.crearCliente(16, "Fed", "Fod", "954321321", 
					Cliente.Documentacion.NIE, "E1856541C", "fedgmail.com", "prueba"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		
		//PRUEBAS PRACTICA 2
		/*try {
			cDao.save(OperacionesCliente.crearCliente(50, "Manuel", "Ros", "607525252"));
			cDao.save(OperacionesCliente.crearCliente(10, "Victor", "Pot", "222525252"));
			cDao.save(OperacionesCliente.crearCliente(50, "Sonia", "Ros", "562525252"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			cDao.save(OperacionesCliente.crearCliente(6, "Sofia", "Brian", "607525252"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			cDao.save(OperacionesCliente.crearCliente(7, "Nacho", "Brian", "787856242"));
			cDao.save(OperacionesCliente.crearCliente(51, "Sonia", "Ros", "562523552"));
			cDao.save(OperacionesCliente.crearCliente(52, "Sonia", "Ros", "662523552"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Cliente cliente : cDao.getAll()) {
			System.out.println(cliente);
		}
		
		PedidoDao pDao = new PedidoDao();
		Calendar today = new GregorianCalendar();
		Calendar day1 = new GregorianCalendar();
		day1.add(Calendar.DAY_OF_MONTH, 4);
		Calendar day2 = new GregorianCalendar();
		day2.add(Calendar.DAY_OF_MONTH, 6);
		Calendar day3 = new GregorianCalendar();
		day3.add(Calendar.DAY_OF_MONTH, 2);
		
		try {
			//System.out.println(today.get(Calendar.DAY_OF_MONTH));
			pDao.save(OperacionesPedido.crearPedido(10, today, day1, day2, 10));
			pDao.save(OperacionesPedido.crearPedido(11, day1, day1, day2, 10));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			pDao.save(OperacionesPedido.crearPedido(12, today, day2, day3, 2));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			pDao.save(OperacionesPedido.crearPedido(12, today, day3, day3, 10));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for (Pedido pedido : pDao.getAll()) {
			System.out.println(pedido);
		}*/
	}//FIN MAIN

}
