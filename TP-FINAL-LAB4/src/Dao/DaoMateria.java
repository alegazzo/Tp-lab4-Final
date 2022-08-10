package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dominio.Materia;
import Dominio.TipoUsuario;
import Dominio.Usuario;
import IDao.IMateria;

public class DaoMateria implements IMateria {

		
	public ArrayList<Materia> listarMaterias() {
	
		ResultSet resultSet; 
		ArrayList<Materia> listaMaterias = new ArrayList<Materia>();
		Conexion conexionSql = null; 
		String query = "SELECT ID, NOMBRE FROM materia";
			
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{	
				listaMaterias.add(
				new Materia(
					resultSet.getInt("id"),
					resultSet.getString("nombre")
				));
			}
			
			return listaMaterias; 
				
		} 
		catch (SQLException e) {
			
			 e.printStackTrace();
		} 
		
		finally {
			conexionSql.cerrarConexion();
		}

		return null;
		
	}

}
