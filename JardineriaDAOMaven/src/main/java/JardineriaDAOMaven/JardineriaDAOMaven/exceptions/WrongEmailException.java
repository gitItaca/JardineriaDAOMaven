package JardineriaDAOMaven.JardineriaDAOMaven.exceptions;

public class WrongEmailException extends Exception{

	@Override
	public String getMessage() {
		return "Email incorrecto.";
	}

	
}
