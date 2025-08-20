package Dominio;

public class Empleado extends Persona{
	
	private int legajo;
	private String puesto;
	
	
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
