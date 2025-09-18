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

	// Listado
	public ArrayList<Producto> obtenerProductos() {
		Connection cn = null;
		String query = "SELECT * FROM Productos";
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
		Connection cn = null;
		String query = "UPDATE Productos SET Nombre = ?, Precio = ?, Stock = ?, idCategoria = ? WHERE Codigo = ?";
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
	public void agregarProductoConSP(Producto prod) {
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
			cst.execute();
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
	}
}

