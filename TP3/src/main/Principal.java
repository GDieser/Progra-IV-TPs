package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DaoCategoria daoCat = new DaoCategoria();
		
		
		// Alta de cat
        System.out.println(" Alta de categorías... ");
        
        Categoria cat1 = new Categoria(1, "Electrónica");
        Categoria cat2 = new Categoria(2, "Hogar");
        Categoria cat3 = new Categoria(3, "Deportes");
        
        daoCat.agregarCategoria(cat1);
        daoCat.agregarCategoria(cat2);
        daoCat.agregarCategoria(cat3);
        
        // Modificar cat
        System.out.println(" Categoría modificada...");
        
        cat3.setNombre("Deportes y Outdoor");
        daoCat.modificarCategoria(cat3);
        
        // Baja de cat
        System.out.println(" Categoría eliminada...");
        
        int idAEliminar = cat3.getIdCategoria();
        int filasEliminadas = daoCat.eliminarCategoria(idAEliminar);
        System.out.println("Filas eliminadas: " + filasEliminadas);
        
        // Listar cat
        System.out.println(" Lista de categorías: ");
        
        ArrayList<Categoria> categorias = daoCat.obtenerCategorias();
        for (Categoria c : categorias) {
            System.out.println(c.getIdCategoria() + " - " + c.getNombre());
        }
        
        DaoProducto daoProd = new DaoProducto();

	    // Alta de productos
	    System.out.println(" Alta de productos... ");
	
	    Producto prod1 = new Producto("M01-4", "Mesa plegable 4 personas", 16575.24, 10, cat2);
	    Producto prod2 = new Producto("SILLA-STD", "Silla estándar", 8590.00, 25, cat2);
	    
	    Categoria cat4 = new Categoria(7, "Ropa");
	    Producto prod3 = new Producto("RemH-SGris", "Remera hombre estampado gris", 7888.25, 7, cat4);
	    
	
	
	    int filasProd1 = daoProd.agregarProducto(prod1);
	    int filasProd2 = daoProd.agregarProducto(prod2);
	    
	    //Intentamos agregar producto sin categoria
	    int filasProd3 = daoProd.agregarProducto(prod3);

	    System.out.println("Filas insertadas (prod1): " + filasProd1);
	    System.out.println("Filas insertadas (prod2): " + filasProd2);
	    System.out.println("Filas insertadas (prod3): " + filasProd3);
	
	    // Modificar producto
	    System.out.println(" Producto modificado... ");
	
	    prod1.setNombre("Mesa plegable 4p reforzada");
	    prod1.setPrecio(17999.99);
	    prod1.setStock(12);
	    int filasProdMod = daoProd.modificarProducto(prod1);
	    System.out.println("Filas modificadas (prod1): " + filasProdMod);
	
	    // Baja de producto
	    System.out.println(" Producto eliminado... ");
	
	    int filasEliminadasProd = daoProd.eliminarProducto(prod2.getCodigo());
	    System.out.println("Filas eliminadas (prod2): " + filasEliminadasProd);
	
	    // Listado de productos
	    System.out.println(" Lista de productos: ");
	
	    ArrayList<Producto> productos = daoProd.obtenerProductos();
	    for (Producto p : productos) {
	        System.out.println(
	            p.getCodigo() + " | " +
	            p.getNombre() + " | $" +
	            String.format("%.2f", p.getPrecio()) + 
	            " | Stock: " + p.getStock() +
	            " | IdCategoria: " + p.getCategoria().getIdCategoria() + 
	            " | NombreCategoria: " + p.getCategoria().getNombre()
	        );
	    }
	    
	    ArrayList<Categoria> categ = daoCat.obtenerCategorias();
	    
	    System.out.println(" Agrega 10 productos con SP...");
	    
        Producto p1 = new Producto("P001", "Celular", 150000, 10, categ.get(0));
        Producto p2 = new Producto("P002", "Televisor", 300000, 5, categ.get(0));
        Producto p3 = new Producto("P003", "Notebook", 500000, 7, categ.get(0));
        Producto p4 = new Producto("P004", "Heladera", 200000, 4, categ.get(0));
        Producto p5 = new Producto("P005", "Microondas", 80000, 12, categ.get(0));
        Producto p6 = new Producto("P006", "Licuadora", 40000, 15, categ.get(1));
        Producto p7 = new Producto("P007", "Pelota Fútbol", 12000, 20, categ.get(1));
        Producto p8 = new Producto("P008", "Bicicleta", 180000, 6, categ.get(1));
        Producto p9 = new Producto("P009", "Raqueta Tenis", 35000, 9, categ.get(1));
        Producto p10 = new Producto("P010", "Colchón", 25000, 11, categ.get(1));
        
        daoProd.agregarProductoConSP(p1);
        daoProd.agregarProductoConSP(p2);
        daoProd.agregarProductoConSP(p3);
        daoProd.agregarProductoConSP(p4);
        daoProd.agregarProductoConSP(p5);
        daoProd.agregarProductoConSP(p6);
        daoProd.agregarProductoConSP(p7);
        daoProd.agregarProductoConSP(p8);
        daoProd.agregarProductoConSP(p9);
        daoProd.agregarProductoConSP(p10);
	}
}
