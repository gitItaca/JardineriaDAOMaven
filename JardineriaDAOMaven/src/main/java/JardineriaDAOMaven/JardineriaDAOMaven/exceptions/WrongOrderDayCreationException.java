package JardineriaDAOMaven.JardineriaDAOMaven.exceptions;

public class WrongOrderDayCreationException extends Exception{
	@Override
	public String getMessage() {
		return "La fecha del pedido tiene que ser el dia de hoy.";
	}
}
