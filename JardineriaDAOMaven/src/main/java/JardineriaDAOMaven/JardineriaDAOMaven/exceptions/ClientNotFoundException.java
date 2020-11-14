package JardineriaDAOMaven.JardineriaDAOMaven.exceptions;

public class ClientNotFoundException extends Exception{
	@Override
	public String getMessage() {
		return "El cliente del pedido no existe en la base de datos.";
	}
}
