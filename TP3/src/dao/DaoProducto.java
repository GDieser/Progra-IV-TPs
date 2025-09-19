package dao;

import entidad.Producto;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoProducto {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdInventario?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";

	public DaoProducto() {
	}

	// Alta normal
	public int agregarProducto(Producto prod) {
		
		if (!existeCategoria(prod.getCategoria().getIdCategoria())) {
	        System.out.println("La categoría con id " + prod.getCategoria().getIdCategoria() + " no existe. No se inserta el producto.");
	        return 0;
	    }
		
		Connection cn = null;
		String query = "INSERT INTO Productos(Codigo, Nombre, Precio, Stock, IdCategoria) VALUES (?,?,?,?,?)";
		int filas = 0;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, prod.getCodigo());
			pst.setString(2, prod.getNombre());
			pst.setDouble(3, prod.getPrecio());
			pst.setInt(4, prod.getStock());
			pst.setInt(5, prod.getCategoria().getIdCategoria());
			filas = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filas;
	}
	
	
	// obtener producto por codigo
	public Producto obtenerProductoPorCodigo(String codigo) {
		
		String query = "SELECT p.Codigo, p.Nombre, p.Precio, p.Stock, c.IdCategoria, c.Nombre AS NombreCategoria FROM Productos p INNER JOIN Categorias c ON p.IdCategoria = c.IdCategoria WHERE p.Codigo = ?";
		Connection cn = null;
		Producto prod = new Producto();

		try {
			cn = DriverManager.getConnection(host + dbName,  user,  pass);
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			
			if(!rs.next()) {
				return null;
			}
			
			prod.setCodigo(rs.getString("Codigo"));
			prod.setNombre(rs.getString("Nombre"));
			prod.setPrecio(rs.getDouble("Precio"));
			prod.setStock(rs.getInt("Stock"));
			prod.getCategoria().setIdCategoria(rs.getInt("IdCategoria"));
			prod.getCategoria().setNombre(rs.getString("NombreCategoria"));
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			try {	
				cn.close();
			}
			catch (SQLException e){
				e.printStackTrace();				
			}
		}
		return prod;
	}

	// Listado
	public ArrayList<Producto> obtenerProductos() {
		Connection cn = null;
		String query = "SELECT p.Codigo, p.Nombre, p.Precio, p.Stock, c.IdCategoria, c.Nombre AS NombreCategoria FROM Productos p INNER JOIN Categorias c ON p.IdCategoria = c.IdCategoria";
		ArrayList<Producto> productos = new ArrayList<>();

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Producto prod = new Producto();
				prod.setCodigo(rs.getString("Codigo"));
				prod.setNombre(rs.getString("Nombre"));
				prod.setPrecio(rs.getDouble("Precio"));
				prod.setStock(rs.getInt("Stock"));
				prod.getCategoria().setIdCategoria(rs.getInt("IdCategoria"));
				prod.getCategoria().setNombre(rs.getString("NombreCategoria"));
				productos.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productos;
	}

	// Baja
	public int eliminarProducto(String Codigo) {
		Connection cn = null;
		String query = "DELETE FROM Productos WHERE Codigo = ?";
		int filas = 0;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, Codigo);
			filas = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filas;
	}

	// Modificacion
	public int modificarProducto(Producto prod) {
		if (!existeCategoria(prod.getCategoria().getIdCategoria())) {
	        System.out.println("La categoría con id " + prod.getCategoria().getIdCategoria() + " no existe.");
	        return 0; 
		}
		
		Connection cn = null;
		String query = "UPDATE Productos SET Nombre = ?, Precio = ?, Stock = ?, IdCategoria = ? WHERE Codigo = ?";
		int filas = 0;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, prod.getNombre());
			pst.setDouble(2, prod.getPrecio());
			pst.setInt(3, prod.getStock());
			pst.setInt(4, prod.getCategoria().getIdCategoria());
			pst.setString(5, prod.getCodigo());
			filas = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filas;
	}
	
	// Alta con Procedimiento almacenado
	public boolean agregarProductoConSP(Producto prod) {
		
		boolean exito = false;
		
		 if (!existeCategoria(prod.getCategoria().getIdCategoria())) {
		        System.out.println("La categoría con id " + prod.getCategoria().getIdCategoria() + " no existe.");
		        return exito; 
		 }
		 
		
		Connection cn = null;
		String query = "CALL sp_AgregarProducto(?,?,?,?,?)";

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall(query);
			cst.setString(1, prod.getCodigo());
			cst.setString(2, prod.getNombre());
			cst.setDouble(3, prod.getPrecio());
			cst.setInt(4, prod.getStock());
			cst.setInt(5, prod.getCategoria().getIdCategoria());
			exito = cst.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return exito;
	}
	
	private boolean existeCategoria(int idCategoria) {
	    Connection cn = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    String query = "SELECT 1 FROM Categorias WHERE IdCategoria = ?";
	    boolean existe = false;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        pst = cn.prepareStatement(query);
	        pst.setInt(1, idCategoria);
	        rs = pst.executeQuery();
	        existe = rs.next();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
	        try { if (pst != null) pst.close(); } catch (SQLException e) { e.printStackTrace(); }
	        try { if (cn != null) cn.close(); } catch (SQLException e) { e.printStackTrace(); }
	    }
	    return existe;
	}

}

