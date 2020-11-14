package JardineriaDAOMaven.JardineriaDAOMaven.exceptions;

public class WrongFechaMinimaPedidoException extends Exception {
	@Override
	public String getMessage() {
		return "La fecha de entrega esperada no puede ser anterior a tres dias despues de la fecha de creacion.";
	}
}
