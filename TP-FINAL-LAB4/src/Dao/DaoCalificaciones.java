package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Dominio.Alumno;
import Dominio.Calificaciones;
import Dominio.Localidad;
import Dominio.Pais;
import Dominio.Provincia;
import IDao.ICalificaciones;

public class DaoCalificaciones implements ICalificaciones{
	public ArrayList<Calificaciones> listarCalificaciones(int idCurso) {
		ResultSet resultSet; 
		ArrayList<Calificaciones> calificaciones = new ArrayList<Calificaciones>();
		Conexion conexionSql = null; 
		String query = "select c.id 'idCalificaciones', c.id_alumno 'idAlumno', a.nombre 'nombreAlumno', a.apellido 'apellidoAlumno', a.legajo 'legajoAlumno', c.id_curso 'idCurso', c.parcial_1, c.parcial_2, c.recuperatorio_1, c.recuperatorio_2, c.estado_academico  from calificacion_x_alumno c inner join alumno a on a.id = c.id_alumno where c.id_curso="+idCurso;
			
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{	
				calificaciones.add(
				new Calificaciones(
						resultSet.getInt("idCalificaciones"),
						new Alumno(resultSet.getInt("idAlumno"),
								resultSet.getString("legajoAlumno"),
								resultSet.getString("nombreAlumno"),
								resultSet.getString("apellidoAlumno")),
						resultSet.getInt("idCurso"),
						resultSet.getFloat("parcial_1"),
						resultSet.getFloat("parcial_2"),
						resultSet.getFloat("recuperatorio_1"),
						resultSet.getFloat("recuperatorio_2"),
						resultSet.getBoolean("estado_academico")
						
				));
			}
			
			return calificaciones; 
				
		} 
		catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return null;
	}
	
	public boolean EditarCalificacionesCurso (Calificaciones calificaciones){
		
		Conexion conexionSql = null; 
		String query = "update calificacion_x_alumno set parcial_1=?,parcial_2=?,recuperatorio_1=?,recuperatorio_2=?,estado_academico=? where id_alumno=? and id_curso=?";		
		
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setFloat(1, calificaciones.getParcial1());
			statement.setFloat(2, calificaciones.getParcial2());
			statement.setFloat(3, calificaciones.getRecuperatorio1());
			statement.setFloat(4, calificaciones.getRecuperatorio2());
			statement.setBoolean(5, calificaciones.getEstadoAcademico());
			statement.setInt(6, calificaciones.getAlumno().getIdAlumno());
			statement.setInt(7, calificaciones.getIdCurso());
		
			
			if(statement.executeUpdate()==1) {
				
				connection.commit();
				return true;
			}
								
		} 
		catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}
		return false;
		
	}
}
