package Dominio;

public class Empleado extends Persona{
	
	private final int legajo;
	private String puesto;
	static int contador = 1000;
	
	public Empleado()
	{
		this.legajo = contador;
		
		contador++;
	}
	
	
	//Getters y Setters
	public int getLegajo() {
		return legajo;
	}


	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}



	//Metodo ToString
	@Override
	public String toString() {
		return "Empleado [legajo=" + legajo + ", puesto=" + puesto + "]";
	}

}
