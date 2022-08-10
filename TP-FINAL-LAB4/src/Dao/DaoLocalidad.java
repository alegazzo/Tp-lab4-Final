package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dominio.Localidad;
import IDao.ILocalidad;


public class DaoLocalidad implements ILocalidad {
	
public ArrayList<Localidad> listarLocalidades() {
		
		ResultSet resultSet; 
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		Conexion conexionSql = null; 
		String query = "select id, nombre, id_provincia from localidad";
			
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{	
				localidades.add(
				new Localidad(
						resultSet.getInt("id"),
						resultSet.getInt("id_Provincia"),
						resultSet.getString("nombre")
				));
			}
			
			return localidades; 
				
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
