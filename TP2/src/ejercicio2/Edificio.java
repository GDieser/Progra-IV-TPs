package ejercicio2;

public abstract class Edificio {

	protected double superficie;

	// constructores
	public Edificio() {
		this.superficie = 0;
	}

	public Edificio(double sup) {
		this.superficie = sup;
	}

	// getters y setters
	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	@Override
	public String toString() {
		return "El edificio tiene una superficie de : " + getSuperficie();
	}

}