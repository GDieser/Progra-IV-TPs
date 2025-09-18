package entidad;

public class Categoria {

	private int IdCategoria;
	private String Nombre;

	public Categoria() {
	}

	public Categoria(int idCategoria, String nombre) {
		IdCategoria = idCategoria;
		Nombre = nombre;
	}

	// Getters & Setters
	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria [IdCategoria=" + IdCategoria + ", Nombre=" + Nombre + "]";
	}

}
