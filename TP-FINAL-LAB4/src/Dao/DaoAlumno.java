package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import Dominio.Alumno;
import Dominio.Localidad;
import Dominio.Pais;
import Dominio.Provincia;
import IDao.IAlumno;

public class DaoAlumno implements IAlumno{

	
	public ArrayList<Alumno> listarAlumnos() {
		ResultSet resultSet; 
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Conexion conexionSql = null; 
		String query = "select a.id, a.legajo, a.nombre, a.apellido, a.fecha_nac as 'Nacimiento', a.adress as 'Direccion', p.id as 'idPais', p.nombre as 'Pais', pr.id as 'idProvincia', pr.nombre as 'Provincia', l.id as 'idLocalidad', l.nombre as 'Localidad', a.email, a.tel, a.estado, a.dni from alumno as a inner join localidad as l on l.id = a.id_localidad inner join provincia as pr on pr.id = a.id_provincia inner join pais as p on p.id = a.id_pais where a.estado=true";
			
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{	
				alumnos.add(
				new Alumno(
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
			
			return alumnos; 
				
		} 
		catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return null;
	}


public boolean agregarAlumno(Alumno alumno) {
		
		String query = "INSERT INTO alumno (legajo, dni, nombre, apellido, fecha_nac, adress, id_pais, id_provincia, id_localidad, email, tel, estado) VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	       
		Conexion conexionSql = null; 
		
		try {
			
		    conexionSql = new Conexion();
			Connection connection  = conexionSql.obtenerConexion(); 
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, alumno.getLegajo());
			statement.setString(2, alumno.getDni());
			statement.setString(3, alumno.getNombre());
			statement.setString(4, alumno.getApellido());
			statement.setString(5, alumno.getFecha_Nacimiento().toString());
			statement.setString(6, alumno.getAdress());
			statement.setInt(7, alumno.getPais().getIdPais());
			statement.setInt(8, alumno.getProvincia().getIdProvincia());
			statement.setInt(9, alumno.getLocalidad().getIdLocalidad());
			statement.setString(10, alumno.getEmail());
			statement.setString(11, alumno.getTelefono());
			statement.setBoolean(12, alumno.getEstado());
			
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

	
	public boolean eliminarAlumno(int idAlumno) {
		
		String query = "update alumno set estado = false where id =?";
	       
		Conexion conexionSql = null; 
		
		try {
			
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion(); 
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idAlumno);
			
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

	
	public boolean modificarAlumno(Alumno alumno) {
		String query = "update alumno set nombre = ?,  apellido = ?,  fecha_nac = ?,  adress = ?,  id_pais = ?,  id_provincia = ?,  id_localidad = ?,  email = ?,  tel = ?,  estado = ? where id = ?";
	       
		Conexion conexionSql = null; 
		
		try {
			
		    conexionSql = new Conexion();
			Connection connection  = conexionSql.obtenerConexion(); 
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(11, alumno.getIdAlumno());
			statement.setString(1, alumno.getNombre());
			statement.setString(2, alumno.getApellido());
			statement.setString(3, alumno.getFecha_Nacimiento().toString());
			statement.setString(4, alumno.getAdress());
			statement.setInt(5, alumno.getPais().getIdPais());
			statement.setInt(6, alumno.getProvincia().getIdProvincia());
			statement.setInt(7, alumno.getLocalidad().getIdLocalidad());
			statement.setString(8, alumno.getEmail());
			statement.setString(9, alumno.getTelefono());
			statement.setBoolean(10, alumno.getEstado());
			
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
