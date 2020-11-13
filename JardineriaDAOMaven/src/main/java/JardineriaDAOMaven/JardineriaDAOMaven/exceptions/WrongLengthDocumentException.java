package JardineriaDAOMaven.JardineriaDAOMaven.exceptions;

public class WrongLengthDocumentException extends Exception{
	
	@Override
	public String getMessage() {
		return "El numero de digitos del documento son incorrectos.";
	}
}
