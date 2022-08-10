package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Docente;
import Dominio.Materia;
import IDao.ICurso;

public class DaoCurso implements ICurso {

	
	public ArrayList<Curso> listarCursos() {
		ResultSet resultSet; 
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Conexion conexionSql = null; 
		String query = "select c.id, c.nombre as nombreCurso, c.semestre, c.anio, c.id_docente, d.nombre as nombreDocente, d.apellido as apellidoDocente, c.id_materia, m.nombre as nombreMateria, c.estado from curso c inner join docente d on d.id = c.id_docente inner join materia m on m.id = c.id_materia";
			
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{	
				cursos.add(
				   new Curso(
						   resultSet.getInt("id"),
						   resultSet.getString("nombreCurso"),
						   resultSet.getString("semestre"),
						   resultSet.getString("anio"),
						   new Docente(
								 resultSet.getInt("id_docente"),
								 resultSet.getString("nombreDocente"),
								 resultSet.getString("apellidoDocente")
						   ),
						   
						   new Materia(
								   resultSet.getInt("id_materia"),
								   resultSet.getString("nombreMateria")
						   ),
						   
						   resultSet.getBoolean("estado")
				));
			}
			
			return cursos; 
				
		} 
		catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return null;
	}

	
	public ArrayList<Curso> listarMisCursos(int idProfesor) {
		ResultSet resultSet; 
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Conexion conexionSql = null; 
		String query = "select c.id, c.nombre as nombreCurso, c.semestre, c.anio, c.id_docente, d.nombre as nombreDocente, d.apellido as apellidoDocente, c.id_materia, m.nombre as nombreMateria, c.estado from curso c inner join docente d on d.id = c.id_docente inner join materia m on m.id = c.id_materia where c.id_docente ="+ idProfesor;
			
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{	
				cursos.add(
				   new Curso(
						   resultSet.getInt("id"),
						   resultSet.getString("nombreCurso"),
						   resultSet.getString("semestre"),
						   resultSet.getString("anio"),
						   new Docente(
								 resultSet.getInt("id_docente"),
								 resultSet.getString("nombreDocente"),
								 resultSet.getString("apellidoDocente")
						   ),
						   
						   new Materia(
								   resultSet.getInt("id_materia"),
								   resultSet.getString("nombreMateria")
						   ),
						   
						   resultSet.getBoolean("estado")
				));
			}
			
			return cursos; 
				
		} 
		catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}
		return null;
	}
	
	
	public boolean AgregarCurso(Curso curso) {	
		Conexion conexionSql = null; 
		String query = "insert into Curso (nombre,semestre,anio,id_docente,id_materia,estado) values (?,?,?,?,?,?)";
		int idGenerado;
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();			
			PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, curso.getNombre());
			statement.setString(2, curso.getSemestre());
			statement.setString(3, curso.getAnio());
			statement.setInt(4, curso.getDocente().getIdDocente());
			statement.setInt(5, curso.getMateria().getIdMateria());
			statement.setBoolean(6, curso.isEstado());
			
			
			
			if(statement.executeUpdate()==1) {
				
				connection.commit();
				ResultSet generatedKeys = statement.getGeneratedKeys(); //devuelve el id del nuevo registro ingresado.
				if (generatedKeys.next()) {
			        idGenerado = generatedKeys.getInt(1);
			        for(Alumno alumno : curso.getListaAlumnos()){
						
						boolean bandera = AgregarAlumnosDeCurso(alumno,idGenerado);
							if(!bandera) return false; //si falla en agregar algun alumnno.
						}
					return true;
				}
				
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

	public boolean AgregarAlumnosDeCurso (Alumno alumno, int idCurso){
		
		Conexion conexionSql = null; 
		String query = "insert into alumnos_x_curso  values (?,?)";
		
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, alumno.getIdAlumno());
			statement.setInt(2, idCurso);
		
			
			
			if(statement.executeUpdate()==1) {
				
				connection.commit();
				boolean bandera = AgregarCalificacionesAlumno(alumno.getIdAlumno(),idCurso);
				if(!bandera) return false; //si falla en agregar alguna calificacion nueva.
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
	
	public boolean AgregarCalificacionesAlumno (int idAlumno, int idCurso){
		
		Conexion conexionSql = null; 
		String query = "insert into calificacion_x_alumno (id_alumno,id_curso,estado_academico) values (?,?,?)";
		
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idAlumno);
			statement.setInt(2, idCurso);
			statement.setInt(3, 1);

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
