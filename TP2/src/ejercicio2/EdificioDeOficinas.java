package ejercicio2;

public class EdificioDeOficinas extends Edificio {
	private int cantidadOficinas;

	// Constructor con superficies del edificio + cantidad de oficinas
	public EdificioDeOficinas(double sup, int cantidadOficinas) {
		super(sup);
		this.cantidadOficinas = cantidadOficinas;
	}

	// Getters y Setters
	public int getCantidadOficinas() {
		return cantidadOficinas;
	}

	public void setCantidadOficinas(int cantidadOficinas) {
		this.cantidadOficinas = cantidadOficinas;
	}

	@Override
	public String toString() {
		return super.toString() + " Y tiene :" + getCantidadOficinas() + " oficinas";
	}

}
