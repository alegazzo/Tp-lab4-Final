package Dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Dominio.Docente;
import Dominio.Docente;
import Dominio.Localidad;
import Dominio.Pais;
import Dominio.Provincia;
import IDao.IDocente;

public class DaoDocente implements IDocente {

	public ArrayList<Docente> listarDocentes() {
		ResultSet resultSet; 
		ArrayList<Docente> Docentes = new ArrayList<Docente>();
		Conexion conexionSql = null; 
		String query = "select d.id, d.legajo, d.nombre, d.apellido, d.fecha_nac as 'Nacimiento', d.adress as 'Direccion', p.id as 'idPais', p.nombre as 'Pais', pr.id as 'idProvincia', pr.nombre as 'Provincia', l.id as 'idLocalidad', l.nombre as 'Localidad', d.email, d.tel, d.estado, d.dni from docente as d inner join localidad as l on l.id = d.id_localidad inner join provincia as pr on pr.id = d.id_provincia inner join pais as p on p.id = d.id_pais where d.estado=true";
			
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{	
				Docentes.add(
				new Docente(
						resultSet.getInt("id"),
						resultSet.getString("legajo"),
						resultSet.getString("dni"),
						resultSet.getString("nombre"),
						resultSet.getString("apellido"),
						LocalDate.parse(resultSet.getString("Nacimiento")),
						resultSet.getString("Direccion"),
						new Localidad(resultSet.getInt("idLocalidad"), resultSet.getInt("idProvincia"),resultSet.getString("Localidad")),
						new Provincia(resultSet.getInt("idProvincia"), resultSet.getString("Provincia"), resultSet.getInt("idPais")),
						new Pais(resultSet.getInt("idPais"), resultSet.getString("Pais")),
						resultSet.getString("email"),
						resultSet.getString("tel"),
						resultSet.getBoolean("estado")
				));
			}
			
			return Docentes; 
				
		} 
		catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return null;
	}

	public int agregarDocente(Docente docente) { 
		String query = "INSERT INTO docente (legajo, dni, nombre, apellido, fecha_nac, adress, id_pais, id_provincia, id_localidad, email, tel, estado) VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	       
		Conexion conexionSql = null;  
		int idGenerado = 0; 
		
		try {
			
		    conexionSql = new Conexion();
			Connection connection  = conexionSql.obtenerConexion(); 
			
			PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, docente.getLegajo());
			statement.setString(2, docente.getDni());
			statement.setString(3, docente.getNombre());
			statement.setString(4, docente.getApellido());
			statement.setString(5, docente.getFecha_Nacimiento().toString());
			statement.setString(6, docente.getAdress());
			statement.setInt(7, docente.getPais().getIdPais());
			statement.setInt(8, docente.getProvincia().getIdProvincia());
			statement.setInt(9, docente.getLocalidad().getIdLocalidad());
			statement.setString(10, docente.getEmail());
			statement.setString(11, docente.getTelefono());
			statement.setBoolean(12, docente.getEstado());
			
			
			
			if(statement.executeUpdate()==1) {
				connection.commit();
				
				ResultSet generatedKeys = statement.getGeneratedKeys(); //devuelve el id del nuevo registro ingresado.
				if (generatedKeys.next()) {
			        idGenerado = generatedKeys.getInt(1);
				}
				
				return idGenerado;
			}
				
		} catch (SQLException e) {
			
			 e.printStackTrace();
			 return idGenerado;
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return idGenerado;
	}

	public boolean eliminarDocente(int idDocente) {
		String query = "update docente set estado = false where id =?";
	       
		Conexion conexionSql = null; 
		
		try {
			
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion(); 
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idDocente);
			
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

	public boolean modificarDocente(Docente docente) {
		String query = "update docente set nombre = ?,  apellido = ?,  fecha_nac = ?,  adress = ?,  id_pais = ?,  id_provincia = ?,  id_localidad = ?,  email = ?,  tel = ?,  estado = ? where id = ?";
	       
		Conexion conexionSql = null; 
		
		try {
			
		    conexionSql = new Conexion();
			Connection connection  = conexionSql.obtenerConexion(); 
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(11, docente.getIdDocente());
			statement.setString(1, docente.getNombre());
			statement.setString(2, docente.getApellido());
			statement.setString(3, docente.getFecha_Nacimiento().toString());
			statement.setString(4, docente.getAdress());
			statement.setInt(5, docente.getPais().getIdPais());
			statement.setInt(6, docente.getProvincia().getIdProvincia());
			statement.setInt(7, docente.getLocalidad().getIdLocalidad());
			statement.setString(8, docente.getEmail());
			statement.setString(9, docente.getTelefono());
			statement.setBoolean(10, docente.getEstado());
			
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
	
	
  






