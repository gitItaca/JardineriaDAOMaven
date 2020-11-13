package JardineriaDAOMaven.JardineriaDAOMaven.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import JardineriaDAOMaven.JardineriaDAOMaven.dao.ClienteDao;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongEmailException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongFirstLastLetterNIEException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongLastLetterDNIException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongLengthDocumentException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongNeedNumberDNIException;
import JardineriaDAOMaven.JardineriaDAOMaven.exceptions.WrongNeedNumberNIEException;
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
			
			if (id == clienteSaved.getCodigo_cliente()) {
				throw new Exception("El codigo ya esta siendo utilizado.");
			}else if (clienteSaved.getNombre_contacto().equals(nombre) && 
				clienteSaved.getApellido_contacto().equals(apellido) ||
				clienteSaved.getTelefono().equals(telefono))  
			{
				throw new Exception("Se puede estar produciendo una duplicidad de datos.");
			}
		}
		
		//Comprobar la documentacion.		
		if(DNI.length() != 9) {										//Si el dni o nie no tienen 9 digitos salta una excepcion.
			throw new WrongLengthDocumentException();
		}
		if(tipoDocumentacion == Documentacion.DNI) {	//Comprueba los digitos del DNI.			
			char letra = DNI.toUpperCase().charAt(8);				//Almaceno el ultimo digito en mayusculas en la variable 'letra'.
			if(!(letra > 64 && letra < 91)) {						//Si el ultimo digito del dni no es una letra salta una excepcion.
				throw new WrongLastLetterDNIException();
			}else {
				for(int x=0; x<8; x++) {							//Recorro todos los numeros del dni
					letra = DNI.charAt(x);							//Recojo el numero en la variable letra
					if(!(letra > 47 && letra < 58)) {				//Si la variable letra no contiene un numero salta una excepcion.
						throw new WrongNeedNumberDNIException();
					}
				}
			}
						
		}else if(tipoDocumentacion == Documentacion.NIE) {	//Comprueba los digitos del NIE.			
				char letraLast = DNI.toUpperCase().charAt(8);			//Si el primer y ultimo digito del NIE no son una letra salta una excepcion.
				char letraFirst = DNI.toUpperCase().charAt(0);
				if((!(letraLast > 64 && letraLast < 91)) || (!(letraFirst > 64 && letraFirst < 91))) {
					throw new WrongFirstLastLetterNIEException();
				}else {
					for(int y=1; y<8; y++) {
						letraFirst = DNI.charAt(y);
						if(!(letraFirst > 47 && letraFirst < 58)) {				//Si la variable letra no contiene un numero salta una excepcion.
							throw new WrongNeedNumberNIEException();
						}
					}
				}			
		}
		
		//Comprobar email
		Pattern patternEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 	//Creo un Pattern para el mail y lo compilo.
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matherEmail = patternEmail.matcher(email);									//Creo un Matcher y comparo el Pattern creado con el mail del usuario.
		
		if(matherEmail.find() == false) {													//Si el mail no sigue el Pattern establecido salta una excepcion.
			throw new WrongEmailException(); //"Email incorrecto."
		}
		
		return new Cliente(id, nombre, apellido, telefono, tipoDocumentacion, DNI, 
				email, password);
		
	}
}

