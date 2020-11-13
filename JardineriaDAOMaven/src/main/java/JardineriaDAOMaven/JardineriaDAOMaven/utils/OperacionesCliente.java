package JardineriaDAOMaven.JardineriaDAOMaven.utils;

import java.util.List;

import JardineriaDAOMaven.JardineriaDAOMaven.dao.ClienteDao;
import JardineriaDAOMaven.JardineriaDAOMaven.model.Cliente;
import JardineriaDAOMaven.JardineriaDAOMaven.model.Cliente.Documentacion;

public class OperacionesCliente {

	public static Cliente crearCliente(int id, String nombre, String apellido, 
			String telefono, Documentacion tipoDocumentacion, String DNI, 
			String email, String password) throws Exception{
		
		ClienteDao cDao = new ClienteDao();
		List <Cliente> clientesSaved = cDao.getAll();
		
		//Comprobar la duplicidad de datos.
		for (Cliente clienteSaved : clientesSaved) {
			
			if (id == clienteSaved.getCodigo_cliente()) 
			{
				throw new Exception("El codigo ya esta siendo utilizado.");
			}else if (clienteSaved.getNombre_contacto().equals(nombre) && 
				clienteSaved.getApellido_contacto().equals(apellido) ||
				clienteSaved.getTelefono().equals(telefono))  
			{
				throw new Exception("Se puede estar produciendo una duplicidad de datos.");
			}
		}
		
		//Comprobar la documentacion.		
		if(tipoDocumentacion == Documentacion.DNI) {	//Comprueba los digitos del DNI.
			if(DNI.length() != 9) {										//Si el dni no tiene 9 digitos salta una excepcion.
				throw new Exception("Numero de digitos del DNI incorrectos.");
			}else {
				char letra = DNI.toUpperCase().charAt(8);				//Almaceno el ultimo digito en mayusculas en la variable 'letra'.
				if(!(letra > 64 && letra < 91)) {						//Si el ultimo digito del dni no es una letra salta una excepcion.
					throw new Exception("El ultimo digito tiene que ser una letra, la 'ñ' esta excluida.");
				}else {
					for(int x=0; x<8; x++) {							//Recorro todos los numeros del dni
						letra = DNI.charAt(x);							//Recojo el numero en la variable letra
						if(!(letra > 47 && letra < 58)) {				//Si la variable letra no contiene un numero salta una excepcion.
							throw new Exception("El digito nº " + (x+1) + " tiene que ser un numero.");
						}
					}
				}
			}
			
		}else if(tipoDocumentacion == Documentacion.NIE) {	//Comprueba los digitos del NIE.
			if(DNI.length() != 9) {										//Si el dni no tiene 9 digitos salta una excepcion.
				throw new Exception("Numero de digitos del NIE incorrectos.");
			}else {
				char letraLast = DNI.toUpperCase().charAt(8);
				char letraFirst = DNI.toUpperCase().charAt(0);
				if((!(letraLast > 64 && letraLast < 91)) || (!(letraFirst > 64 && letraFirst < 91))) {
					throw new Exception("El primer digito y el ultimo tienen que ser una letra, la 'ñ' esta excluida.");
				}else {
					for(int y=1; y<8; y++) {
						letraFirst = DNI.charAt(y);
						if(!(letraFirst > 47 && letraFirst < 58)) {				//Si la variable letra no contiene un numero salta una excepcion.
							throw new Exception("El digito nº " + (y+1) + " tiene que ser un numero.");
						}
					}
				}
			}
		}
		
		return new Cliente(id, nombre, apellido, telefono, tipoDocumentacion, DNI, 
				email, password);
		
	}
}

