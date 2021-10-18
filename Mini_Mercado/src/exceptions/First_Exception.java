package exceptions;

public class First_Exception extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public First_Exception() {
		super("La persona que esta intentando ingresar no puede por el dia");
	}
}
