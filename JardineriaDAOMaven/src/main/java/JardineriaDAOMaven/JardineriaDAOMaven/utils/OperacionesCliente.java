package JardineriaDAOMaven.JardineriaDAOMaven.utils;

import java.util.List;

import JardineriaDAOMaven.JardineriaDAOMaven.dao.ClienteDao;
import JardineriaDAOMaven.JardineriaDAOMaven.model.Cliente;

public class OperacionesCliente {

	public static Cliente crearCliente(int id, String nombre, String apellido, String telefono) throws Exception{
		
		ClienteDao cDao = new ClienteDao();
		List <Cliente> clientesSaved = cDao.getAll();
		
		//Comprobar la duplicidad de datos.
		for (Cliente clienteSaved : clientesSaved) {
			
			if (id == clienteSaved.getCodigo_cliente()) 
			{
				throw new Exception("El c�digo ya est� siendo utilizado.");
			}else if (clienteSaved.getNombre_contacto().equals(nombre) && 
				clienteSaved.getApellido_contacto().equals(apellido) ||
				clienteSaved.getTelefono().equals(telefono))  
			{
				throw new Exception("Se puede estar produciendo una duplicidad de datos.");
			}
		}
		
		return new Cliente(id, nombre, apellido, telefono);
		
	}
}

