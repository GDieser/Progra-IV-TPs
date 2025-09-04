package ejercicio1;

public class ExVerificarDNI extends RuntimeException {
	
	public ExVerificarDNI()
	{
		
	}


	@Override
	public String getMessage() {
		
		return "Formato de DNI incorrecto, debe ser exactamende de 8 caracteres numéricos.";
	}
	
	

}
