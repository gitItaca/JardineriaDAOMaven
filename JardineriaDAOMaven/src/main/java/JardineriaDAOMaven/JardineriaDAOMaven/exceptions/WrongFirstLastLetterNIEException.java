package JardineriaDAOMaven.JardineriaDAOMaven.exceptions;

public class WrongFirstLastLetterNIEException extends Exception{
	@Override
	public String getMessage() {
		return "El primer digito y el ultimo tienen que ser una letra, la 'ñ' esta excluida.";
	}
}
