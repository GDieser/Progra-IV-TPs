package entidad;

public class Producto {

	private String Codigo;
	private String Nombre;
	private double Precio;
	private int Stock;
	private Categoria Categoria;

	public Producto() {
	}

	public Producto(String codigo, String nombre, double precio, int stock, Categoria categoria) {
		this.Codigo = codigo;
		this.Nombre = nombre;
		this.Precio = precio;
		this.Stock = stock;
		this.Categoria = categoria;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public Categoria getCategoria() {
		return Categoria;
	}

	public void setCategoria(Categoria categoria) {
		Categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [Codigo=" + Codigo + ", Nombre=" + Nombre + ", Precio=" + Precio + ", Stock=" + Stock
				+ ", Categoria=" + Categoria + "]";
	}
}
