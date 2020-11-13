package JardineriaDAOMaven.JardineriaDAOMaven.exceptions;

public class WrongNeedNumberNIEException extends Exception{
	@Override
	public String getMessage() {
		return "Todos los digitos menos el primero y el ultimo tienen que ser un numero.";
	}
}
