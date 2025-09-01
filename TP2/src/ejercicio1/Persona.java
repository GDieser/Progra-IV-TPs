package ejercicio1;

import java.time.LocalDate;
import ejercicio1.ExVerificarDNI;

public class Persona {
	
	private String dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String genero;
	private String direccion;
	private String telefono;
	private String email;
	
	// Contructor vacío
	public Persona()
	{
		this.nombre = "Sin nombre";
		this.fechaNacimiento = LocalDate.of(2025, 1, 1);
	}
	 
    // Constructor con parámetros
    public Persona(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String genero, String direccion, String telefono, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // Metodo estatico para verificar DNI
    public static void exVerificarDNI(String dni) throws ExVerificarDNI {
    	if (dni == null || dni.length() != 8) {
            throw new ExVerificarDNI("El DNI debe tener exactamente 8 caracteres.");
        }
        try {
            Integer.parseInt(dni); 
        } catch (NumberFormatException e) {
            throw new ExVerificarDNI("El DNI debe contener solo números.");
        }
	}
	
	//Metodo ToString
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre  + ", apellido=" + apellido 
                +  ", fechaNacimiento=" + fechaNacimiento + ", genero="
				+ genero + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + "]";
	}

	//Getter y Setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
