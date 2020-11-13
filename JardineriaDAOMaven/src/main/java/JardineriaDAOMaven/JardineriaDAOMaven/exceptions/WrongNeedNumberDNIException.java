package JardineriaDAOMaven.JardineriaDAOMaven.exceptions;

public class WrongNeedNumberDNIException extends Exception{
	@Override
	public String getMessage() {
		return "Todos los digitos menos el ultimo tienen que ser un numero.";
	}
}
