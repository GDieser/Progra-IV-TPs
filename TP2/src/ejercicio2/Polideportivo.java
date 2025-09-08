package ejercicio2;

public class Polideportivo extends Edificio implements InstalacionDeportiva {

    private String nombre;
    private int tipoInstalacion; 
    // 1 = Techado, 2 = Abierto.

    // Constructores
    public Polideportivo() {
        super();
        this.nombre = "Sin nombre";
        this.tipoInstalacion = 0;
    }

    public Polideportivo(double superficie, String nombre, int tipoInstalacion) {
        super(superficie);
        this.nombre = nombre;
        this.tipoInstalacion = tipoInstalacion;
    }

    @Override
    public int getTipoInstalacion() {
        return tipoInstalacion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoInstalacion(int tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }

    @Override
    public String toString() {
        return "Polideportivo [nombre=" + nombre 
                + ", superficie=" + superficie 
                + ", tipoInstalacion=" + tipoInstalacion + "]";
    }
}
