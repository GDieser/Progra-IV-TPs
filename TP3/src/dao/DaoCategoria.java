package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Categoria;

public class DaoCategoria {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdInventario?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
	
	public DaoCategoria() {
	}

	
	//Alta 
	public int agregarCategoria(Categoria cat) {
			
		Connection cn = null;
		String query = "Insert into Categorias(Nombre) values (?)";
		int filas = 0;
		
		try {
			cn = DriverManager.getConnection(host+dbName,user, pass);
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, cat.getNombre());
			filas = pst.executeUpdate();	
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return filas;
	}
	
	//Listado
	public ArrayList<Categoria> obtenerCategorias() {
		
		Connection cn = null;
		String query = "SELECT * FROM Categorias";
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		try {
			cn = DriverManager.getConnection(host+dbName,user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);	
			
			while(rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setIdCategoria(rs.getInt("IdCategoria"));
				categoria.setNombre(rs.getString("Nombre"));
				categorias.add(categoria);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return categorias;
	}
	
	//Baja
	public int eliminarCategoria(int idCategoria) {
	    Connection cn = null;
	    String query = "DELETE FROM Categorias WHERE IdCategoria = ?";
	    int filas = 0;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        PreparedStatement pst = cn.prepareStatement(query);
	        pst.setInt(1, idCategoria);
	        filas = pst.executeUpdate();
	    } 
	    catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    finally {
	        try {
	             cn.close();
	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return filas;
	}
	
	//Modificacion
	public int modificarCategoria(Categoria cat) {
	    Connection cn = null;
	    String query = "UPDATE Categorias SET Nombre = ? WHERE IdCategoria = ?";
	    int filas = 0;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        PreparedStatement pst = cn.prepareStatement(query);
	        pst.setString(1, cat.getNombre());
	        pst.setInt(2, cat.getIdCategoria());
	        filas = pst.executeUpdate();
	    } 
	    catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    finally {
	        try {
	             cn.close();
	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return filas;
	}
	
}
