package ejercicio1;

import java.time.LocalDate;

public class Empleado extends Persona{
	
	private final int legajo; // constante
	private String puesto;
	
	private static int legajoAuto=999; //variable legajo automatico de la clase
	
	public Empleado() {
		super();
		legajoAuto++;
		this.legajo = legajoAuto;
		this.puesto = "Sin puesto";
	}
	
	public Empleado(String dni, String nombre, String apellido, LocalDate fechaNacimiento, 
			String genero, String direccion, String telefono, String email, String puesto) 
	{
		super(dni, nombre, apellido, fechaNacimiento, genero, direccion, telefono, email);
		legajoAuto++;
		this.legajo=legajoAuto;
		this.puesto = puesto;
	}
	
	//Metodo
	
	public static int devuelveProximoLegajo()
	{
		return legajoAuto+1;
	}
	
	//Getters y Setters

	public int getLegajo() {
		return legajo;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Empleado [legajo=" + legajo + ", puesto=" + puesto + "]";
	}

}
