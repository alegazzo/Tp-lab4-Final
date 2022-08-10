package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Dominio.Alumno;
import Dominio.Localidad;
import Dominio.Pais;
import Dominio.Provincia;
import Dominio.TipoUsuario;
import Dominio.Usuario;
import IDao.IUsuario;

public class DaoUsuario implements IUsuario {

	public ArrayList<Usuario> listarUsuarios() {
		ResultSet resultSet; 
		ArrayList<Usuario> usuario = new ArrayList<Usuario>();
		Conexion conexionSql = null; 
		String query = "select u.id, u.user_name, u.pass, u.tipo, u.token, u.estado, tu.id as idTipo, tu.nombre_tipo from usuario u join tipo_usuario tu ON u.tipo = tu.id WHERE u.estado = true";
			
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{	
				usuario.add(
				new Usuario(
					resultSet.getInt("id"),
					resultSet.getString("user_name"),
					resultSet.getString("pass"),
					new TipoUsuario(resultSet.getInt("idTipo"), resultSet.getString("nombre_tipo")),
					resultSet.getInt("token"),
					resultSet.getBoolean("estado")
				));
			}
			
			return usuario; 
				
		} 
		catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return null;
	}

	public boolean agregarUsuario(Usuario usuario) {
		
		String query = "INSERT INTO usuario (user_name, pass, tipo, token, estado) VALUES " + "(?, ?, ?, ?, ?)";
	       
		Conexion conexionSql = null; 
		
		try {
			
		    conexionSql = new Conexion();
			Connection connection  = conexionSql.obtenerConexion(); 
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, usuario.getUser_Name());
			statement.setString(2, usuario.getPass());
			statement.setInt(3, usuario.getTipoUsuario().getIdTipoUsuario());
			statement.setInt(4, usuario.getReferencia());
			statement.setBoolean(5, usuario.getEstado());
			
			if(statement.executeUpdate()==1) {
				connection.commit();
				return true;
			}
				
		} catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return false;
		
	}
	
	public boolean modificarUsuario(Usuario usuario) {
		
		String query = "UPDATE usuario set user_name = ?, pass = ? where id = ?";
	       
		Conexion conexionSql = null; 
		
		try {
			
		    conexionSql = new Conexion();
			Connection connection  = conexionSql.obtenerConexion(); 
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, usuario.getUser_Name());
			statement.setString(2, usuario.getPass());
			statement.setInt(3, usuario.getIdUsuario());
			
			if(statement.executeUpdate()==1) {
				connection.commit();
				return true;
			}
				
		} catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return false;
		
	}

	public boolean eliminarUsuario(int idUsuario) {
		
		String query = "update usuario set estado = false where id =?";
	       
		Conexion conexionSql = null; 
		
		try {
			
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion(); 
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idUsuario);
			
			if(statement.executeUpdate()==1) {
				connection.commit();
				return true;
			}
				
		} catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return false;
		
		
	}



}
