package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Dominio.Pais;
import IDao.IPais;

public class DaoPais implements IPais{

	
	public ArrayList<Pais> listarPaises() {
		ResultSet resultSet; 
		ArrayList<Pais> paises = new ArrayList<Pais>();
		Conexion conexionSql = null; 
		String query = "select id, nombre from pais";
			
		try {
			conexionSql = new Conexion();
			Connection connection = conexionSql.obtenerConexion();
			PreparedStatement statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{	
				paises.add(
				new Pais(
						resultSet.getInt("id"),
						resultSet.getString("nombre")
				));
			}
			
			return paises; 
				
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
