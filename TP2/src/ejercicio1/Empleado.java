package ejercicio1;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado extends Persona implements Comparable<Empleado> {
	
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

	//Hashcode y Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(legajo, puesto);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return legajo == other.legajo && Objects.equals(puesto, other.puesto);
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
	
	@Override
	public int compareTo(Empleado otro) {
		return Integer.compare(this.legajo, otro.legajo);
	}
	
	
}
